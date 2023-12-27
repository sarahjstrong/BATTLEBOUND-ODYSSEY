package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BattleTest {

    Battle sut;
    @Before
    public void setup() {
        sut = new Battle();
    }

    @Test
    public void createCharacter_returns_Dragonborn_named_Jaryax_for_1() {
        Character expected = new Dragonborn("Jaryax");
        Character actual = sut.createCharacter(1, "Jaryax");
        assertCharactersMatch(expected, actual);
    }

    @Test
    public void createCharacter_returns_Halfelf_named_Eumenes_for_5() {
        Character expected = new Halfelf("Eumenes");
        Character actual = sut.createCharacter(5, "Eumenes");
        assertCharactersMatch(expected, actual);
    }

    @Test
    public void createCharacter_returns_Human_named_Randoul_for_9() {
        Character expected = new Human("Randoul");
        Character actual = sut.createCharacter(9, "Randoul");
        assertCharactersMatch(expected, actual);
    }

    @Test
    public void createCharacter_returns_null_for_10() {
        Character actual = sut.createCharacter(10, "Ponto");
        Assert.assertNull("Invalid character code should return null character with invalid input message:", actual);

    }

    private void assertCharactersMatch(Character expected, Character actual) {
        Assert.assertEquals(expected.getName(), actual.getName());
        Assert.assertEquals(expected.getType(), actual.getType());
    }
}
