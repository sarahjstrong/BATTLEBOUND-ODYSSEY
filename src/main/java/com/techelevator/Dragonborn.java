package com.techelevator;

public class Dragonborn extends Character {

    public Dragonborn(String name) {
        super("DRAGONBORN", name);
        setHealth(60);
    }

    @Override
    public void powerAttack() {
        if (isHasPowerAttack() == true) {
            setCurrentRoll(5);
            System.out.println(getName() + " used power attack! 5 will be added to next roll.");
            setHasPowerAttack(false);
        } else {
            System.out.println(getName() + " already used their power attack.");
        }
    }

    @Override
    public void fullHeal() {
        if (isHasFullHeal() == true) {
            setHealth(60);
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
            if (getHealth() <= 50) {
                setHealth(getHealth() + 10);
            } else {
                setHealth(60);
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
        System.out.println("Since " + getName() + " is a " + getType() + ", their special power is FIRE!");
        System.out.println("Fire engulfs opponent. That looks like it hurts!");
        otherPlayer.setHealth(otherPlayer.getHealth() - 10);
        System.out.println(otherPlayer.getName() + "'s health decreases by 10.");
    }
}
