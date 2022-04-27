package es.hulk.coins.utils.aquamenu.menu;

import java.util.*;
import java.util.stream.*;

import es.hulk.coins.Coins;
import es.hulk.coins.utils.TaskUtil;
import es.hulk.coins.utils.Utils;
import es.hulk.coins.utils.aquamenu.slots.Slot;
import lombok.*;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.inventory.*;

public abstract class AquaMenu {

    public Coins plugin = Coins.getInstance();
    @Getter private List<Slot> slots = new ArrayList<>();
    @Setter @Getter private boolean updateInTask = false;
    public abstract List<Slot> getSlots(Player player);
    public abstract String getName(Player player);

    public void open(Player player) {
        AquaMenu previous = plugin.getMenuManager().getOpenedMenus().get(player.getUniqueId());
        if (previous != null) {
            previous.onClose(player);
            plugin.getMenuManager().getOpenedMenus().remove(player.getUniqueId());
        }

        this.slots = this.getSlots(player);
        String title = this.getName(player);

        if (title.length() > 32) title = title.substring(0, 32);
        title = Utils.color(title);

        Inventory inventory = Bukkit.createInventory(player, this.getInventorySize(this.slots), title);

        this.slots.forEach(slot -> {
            inventory.setItem(slot.getSlot(), slot.getItem(player));

            if (slot.getSlots() != null) {
                Arrays.stream(slot.getSlots()).forEach(extra -> {
                    inventory.setItem(extra, slot.getItem(player));
                });
            }
        });

        TaskUtil.run(() -> {
            if (player.getOpenInventory() != null) {
                player.closeInventory();
            }
            plugin.getMenuManager().getOpenedMenus().put(player.getUniqueId(), this);
            player.openInventory(inventory);

            this.onOpen(player);
        });
    }

    public void update(Player player) {
        this.slots = this.getSlots(player);
        String title = this.getName(player);

        if (title.length() > 32) title = title.substring(0, 32);
        title = (title);

        boolean passed = false;
        Inventory inventory = null;
        AquaMenu currentlyOpenedMenu = plugin.getMenuManager().getOpenedMenus().get(player.getUniqueId());
        Inventory current = player.getOpenInventory().getTopInventory();

        if (currentlyOpenedMenu != null && Utils.color(currentlyOpenedMenu.getName(player)).equals(player.getOpenInventory().getTitle()) && current.getSize() == this.getInventorySize(this.slots)) {
            inventory = current;
            passed = true;
        }

        if (inventory == null) {
            inventory = Bukkit.createInventory(player, this.getInventorySize(this.slots), title);
        }

        /**
         * TemporaryInventory
         * Used to prevent item flickering because 'inventory' is live player inventory
         */
        Inventory temporaryInventory = Bukkit.createInventory(player, inventory.getSize(), title);

        this.slots.forEach(slot -> {
            temporaryInventory.setItem(slot.getSlot(), slot.getItem(player));

            if (slot.getSlots() != null) {
                Arrays.stream(slot.getSlots()).forEach(extra -> {
                    temporaryInventory.setItem(extra, slot.getItem(player));
                });
            }
        });

        plugin.getMenuManager().getOpenedMenus().remove(player.getUniqueId());
        plugin.getMenuManager().getOpenedMenus().put(player.getUniqueId(), this);

        inventory.setContents(temporaryInventory.getContents());
        if (passed) {
            player.updateInventory();
        } else {
            Inventory finalInventory = inventory;
            TaskUtil.run(() -> player.openInventory(finalInventory));
        }
    }

    private int getInventorySize(List<Slot> slots) {
        int highest = 0;
        if (!slots.isEmpty()) {
            highest = slots.stream().sorted(Comparator.comparingInt(Slot::getSlot).reversed()).map(Slot::getSlot).collect(Collectors.toList()).get(0);
        }
        for (Slot slot : slots) {
            if (slot.getSlots() != null) {
                for (int i = 0; i < slot.getSlots().length; i++) {
                    if (slot.getSlots()[i] > highest) {
                        highest = slot.getSlots()[i];
                    }
                }
            }
        }
        return (int) (Math.ceil((highest + 1) / 9D) * 9D);
    }

    public boolean hasSlot(int value) {
        return (this.slots.stream().filter(slot -> slot.getSlot() == value || slot.getSlots() != null && Arrays.stream(slot.getSlots()).anyMatch(i -> i == value)).findFirst().orElse(null) != null);
    }

    public Slot getSlot(int value) {
        return this.slots.stream().filter(slot -> slot.getSlot() == value || slot.getSlots() != null && Arrays.stream(slot.getSlots()).anyMatch(i -> i == value)).findFirst().orElse(null);
    }

    public void onOpen(Player player) {
    }

    public void onClose(Player player) {
        plugin.getMenuManager().getLastOpenedMenus().remove(player.getUniqueId());
        plugin.getMenuManager().getLastOpenedMenus().put(player.getUniqueId(), this);
    }
}
