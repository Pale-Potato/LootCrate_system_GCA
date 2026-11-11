package models;
import exceptions.*;

public class LootCrate {
    private int crateId;
    private int price;
    private String loot;

    public LootCrate(int crateId, int price, String loot) {
        this.crateId = crateId;
        this.price = price;
        this.loot = loot;
    }

    public int getCrateId() {
        return crateId;
    }

    public int getPrice() {
        return price;
    }

    public String getLoot() {
        return loot;
    }

    public void openCrate(Player player) throws NotEnoughCreditsException, PlayerNotFoundException {
        player.spendCredits(price);
        System.out.println("You got " + getLoot());
    }



}
