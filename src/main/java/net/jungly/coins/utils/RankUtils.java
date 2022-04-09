package net.jungly.coins.utils;

import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.group.Group;
import net.luckperms.api.node.Node;
import net.luckperms.api.node.NodeType;
import net.luckperms.api.node.types.InheritanceNode;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.List;

public class RankUtils {

    public static void setPermRank(Player player, String rank, String server) {
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + player.getName() + " parent add " + rank);
    }

    public static void setTempRank(Player player, String rank, String server) {
        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "lp user " + player.getName() + " parent addTemp " + rank + " 30d");
    }

    public static boolean hasRank(Player player, String rank) {
        LuckPerms api = LuckPermsProvider.get();

        net.luckperms.api.model.user.User user = api.getUserManager().getUser(player.getUniqueId());
        Group group = api.getGroupManager().getGroup(rank);

        Group userGroup = api.getGroupManager().getGroup(user.getPrimaryGroup());

        if (group != null) {
            if (userGroup.equals(group)) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public static boolean isTempRank(Player player) {
        LuckPerms api = LuckPermsProvider.get();

        net.luckperms.api.model.user.User user = api.getUserManager().getUser(player.getUniqueId());

        List<Node> allUserNodes = (List<Node>) user.getNodes();
        for (Node node : allUserNodes) {
            InheritanceNode groupNode = NodeType.INHERITANCE.tryCast(node).orElse(null);
            if (groupNode == null) return false;
            if (groupNode.hasExpiry()) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}
