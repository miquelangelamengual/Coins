package es.hulk.coins.utils.aquamenu;

import java.util.*;

import es.hulk.coins.Coins;
import es.hulk.coins.utils.aquamenu.menu.AquaMenu;
import lombok.*;

@Getter
public class MenuManager {

  private Coins plugin;

  public Map<UUID, AquaMenu> openedMenus = new HashMap<>();
  public Map<UUID, AquaMenu> lastOpenedMenus = new HashMap<>();

  public MenuManager(Coins plugin) {
    this.plugin = plugin;
  }
}
