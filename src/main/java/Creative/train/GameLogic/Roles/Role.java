package Creative.train.GameLogic.Roles;

import Creative.train.GameLogic.Items.Item;

import java.util.ArrayList;
import java.util.List;

public abstract class Role {

    protected final String name;
    protected final Team team;
    protected final String hex;

    final List<Item> itemShop = new ArrayList<>();
    final List<Item> baseInventory = new ArrayList<>();

    protected final int coinsPerMin;
    public Role(String name, Team team,int coinsPerMin,String hex) {
        this.name = name;
        this.team = team;
        this.hex = hex;
        this.coinsPerMin = coinsPerMin;
    }

    public int getCoinsPerMin() {
        return coinsPerMin;
    }

    public List<Item> getItemShop() {
        return itemShop;
    }

    public List<Item> getBaseInventory() {
        return baseInventory;
    }

    public String getHex(){
        return hex;
    }
    public String getName() {
        return name;
    }

    public Team getTeam() {
        return team;
    }

    public enum Team {
        CIVILIAN,
        NEUTRAL,
        KILLER
    }
}
