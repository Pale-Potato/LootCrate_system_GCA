package models;
import exceptions.*;
import java.util.ArrayList;

public class PlayerManager {

        private ArrayList<Player> players = new ArrayList<>();

        public void addPlayer(Player player) {
            players.add(player);
        }

        public Player findPlayer(String name) throws PlayerNotFoundException {
            for (Player player : players) {
                if (player.getName().equalsIgnoreCase(name)) {
                    return player;
                }
            }
            throw new PlayerNotFoundException();
        }
    }

