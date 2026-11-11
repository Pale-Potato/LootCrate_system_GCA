package models;
import exceptions.*;


public class Player {
    private int id;
    private String name;
    private int credits;

    public Player(int id, String name, int credits) {
        this.id = id;
        this.name = name;
        this.credits = credits;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCredits() {
        return credits;
    }

    public void showDetails() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Credits: " + credits);
    }

    public void addCredits(int amount) throws NegativeAmountException{
        if (amount < 0){
            throw new NegativeAmountException();
        }
        this.credits += amount;
    }

    public void spendCredits(int amount) throws NotEnoughCreditsException {
            if (amount > credits) {
                throw new NotEnoughCreditsException();
            }
            credits -= amount;
        }



    }

