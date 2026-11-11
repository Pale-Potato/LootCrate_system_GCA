package models;
import exceptions.*;

public class LootCrate {
    private int crateId;
    private int price;
    private String loot;

    public LootCrate(int crateId, int price, String loot) {
        this.crateId = crateId;
        if (price < 0){
            throw new IllegalArgumentException("Price can't be negative");
        } else {
            this.price = price;
        }
        if (loot == null || loot.isBlank()) {
            throw new IllegalArgumentException("Loot required");
        } else {
            this.loot = loot;
        }
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
