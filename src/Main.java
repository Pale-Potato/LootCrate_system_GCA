import exceptions.*;
import models.*;

void main() {
    PlayerManager manager = new PlayerManager();
    Player player1 = new Player(1, "Alice", 100);
    Player player2 = new Player(2, "Bob", 89);
    Player player3 = new Player(3, "Charlie", 10);
    Player player4 = new Player(4, "David", 82);
    Player player5 = new Player(5, "Edward", 56);

    LootCrate lootCrate1 = new LootCrate(1, 5, "Teddy");
    LootCrate lootCrate2 = new LootCrate(2, 30, "Blaster gun");
    LootCrate lootCrate3 = new LootCrate(3, 10, "Popcorn");
    LootCrate lootCrate4 = new LootCrate(4, 20, "Rocket");
    LootCrate lootCrate5 = new LootCrate(5, 25, "Hat");
    LootCrate lootCrate6 = new LootCrate(6, 15, "Ballon");

    manager.addPlayer(player1);
    manager.addPlayer(player2);
    manager.addPlayer(player3);
    manager.addPlayer(player4);
    manager.addPlayer(player5);

    System.out.println("=====================================================");

    //open crate succes
    try {
        String name = "Alice";
        Player player = manager.findPlayer(name);
        lootCrate1.openCrate(player);
    }
    catch (NotEnoughCreditsException nece) {
        System.out.println("Rejected: " + nece.getMessage());
    }
    catch (PlayerNotFoundException pnfe) {
        System.out.println("Rejected: " + pnfe.getMessage());
    }

    System.out.println("=====================================================");

    //open crate not enough credits
    try {
        String name = "Charlie";
        Player player = manager.findPlayer(name);
        lootCrate2.openCrate(player);
    }
    catch (NotEnoughCreditsException nece) {
        System.out.println("Rejected: " + nece.getMessage());
    }
    catch (PlayerNotFoundException pnfe) {
        System.out.println("Rejected: " + pnfe.getMessage());
    }

    System.out.println("=====================================================");

    //add negative credits
    System.out.println("Balance: " + player1.getCredits());
    try {
        player1.addCredits(-20);
        System.out.println("New balance: " + player1.getCredits());
    }
    catch (NegativeAmountException nae){
        System.out.println("rejected: " + nae.getMessage());
    }

    System.out.println("=====================================================");

    //add valid credits
    System.out.println("Balance: " + player4.getCredits());
    try {
        player4.addCredits(27);
        System.out.println("New balance: " + player4.getCredits());
    }
    catch (NegativeAmountException nae){
        System.out.println("rejected: " + nae.getMessage());
    }

    System.out.println("=====================================================");


    //Crate opens for nonexistent player
    try {
        String name = "Mikkel";
        Player player = manager.findPlayer(name);
        lootCrate4.openCrate(player);
    }
    catch (NotEnoughCreditsException nece) {
        System.out.println("Rejected: " + nece.getMessage());
    }
    catch (PlayerNotFoundException pnfe) {
        System.out.println("Rejected: " + pnfe.getMessage());
    }

    System.out.println("=====================================================");

    //Show details
    player3.showDetails();

}
