package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GameTest {

    @Test
    public void FirstPlayerWinTest() {

        Player Ivan = new Player(12, "Ivan", 45);
        Player Egor = new Player(1, "Egor", 40);
        Game game = new Game();

        game.register(Ivan);
        game.register(Egor);

        int actual = game.round("Ivan", "Egor");
        int expected = 1;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void SecondPlayerWinTest() {

        Player Ivan = new Player(12, "Ivan", 40);
        Player Egor = new Player(1, "Egor", 45);
        Game game = new Game();

        game.register(Ivan);
        game.register(Egor);

        int actual = game.round("Ivan", "Egor");
        int expected = 2;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void NoOneOfPlayersIsNoWinTest() {

        Player Ivan = new Player(12, "Ivan", 40);
        Player Egor = new Player(1, "Egor", 40);
        Game game = new Game();

        game.register(Ivan);
        game.register(Egor);

        int actual = game.round("Ivan", "Egor");
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void SecondPlayerNotExistTest() {

        Player Ivan = new Player(12, "Ivan", 40);

        Game game = new Game();

        game.register(Ivan);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Ivan", "Egor")
        );
    }

    @Test
    public void FirstPlayerNotExistTest() {

        Player Egor = new Player(1, "Egor", 40);

        Game game = new Game();

        game.register(Egor);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Ivan", "Egor")
        );
    }
}