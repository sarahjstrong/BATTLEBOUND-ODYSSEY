package com.techelevator;

public class Dwarf extends  Character {

    public Dwarf(String name) {
        super("DWARF", name);
    }

    @Override
    public void powerAttack() {
        if (isHasPowerAttack() == true) {
            setCurrentRoll(10);
            System.out.println(getName() + " used power attack! 10 will be added to next roll.");
            setHasPowerAttack(false);
        } else {
            System.out.println(getName() + " already used their power attack.");
        }
    }

    @Override
    public void fullHeal() {
        if (isHasFullHeal() == true) {
            setHealth(50);
            System.out.println(getName() + " has used their full heal!");
            setHasFullHeal(false);
        } else {
            System.out.println(getName() + " has already used their full heal.");
        }
        System.out.println(getName() + "'S health: " + getHealth());
    }

    @Override
    public void partialHeal() {
        if (isHasPartialHeal() == true) {
            if (getHealth() <= 40) {
                setHealth(getHealth() + 10);
            } else {
                setHealth(50);
            }
            setHasPartialHeal(false);
            System.out.println(getName() + " used their partial heal!");
        } else {
            System.out.println(getName() + " already used their partial health.");
        }
        System.out.println(getName() + "'S health: " + getHealth());
    }

    @Override
    public void performSpecialPower(Character otherPlayer) {
        System.out.println("Since " + getName() + " is a " + getType() + ", their special power is the BATTLEAXE!");
        System.out.println("Opponent takes the mighty hit of the battleaxe!");
        otherPlayer.setHealth(otherPlayer.getHealth() - 12);
        System.out.println(otherPlayer.getName() + "'s health decreases by 12.");
        setHealth(getHealth() - 2);
        System.out.println("Unfortunately, the battleaxe is extremely heavy and " + getName() + "'s health also decreases by 2.");

    }
}
