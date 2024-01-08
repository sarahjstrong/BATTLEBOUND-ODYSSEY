package com.techelevator;

public class Halfelf extends Character {

    public Halfelf(String name) {
        super("HALFELF", name);
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
            if (getHealth() <= 35) {
                setHealth(getHealth() + 15);
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
        System.out.println("Since " + getName() + " is a " + getType() + ", their special power is SPEED!");
        System.out.println(getName() + " bolts to hide and then plants a sneak attack upon the opponent!");
        otherPlayer.setHealth(otherPlayer.getHealth() - 11);
        System.out.println(otherPlayer.getName() + "'s health decreases by 11.");
        setHealth(getHealth() - 1);
        System.out.println("Unfortunately, running quickly takes a toll on " + getName() + "'s energy level. Health decreases by 1.");
    }
}
