package ru.netology.tasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    @Test
    public void shouldRegisterAndFindPlayers() {
        Game game = new Game();
        Player player1 = new Player(1, "Alice", 100);
        game.register(player1);

        assertDoesNotThrow(() -> game.round("Alice", "Alice"));
    }

    @Test
    public void shouldThrowExceptionIfPlayerNotRegistered() {
        Game game = new Game();

        assertThrows(NotRegisteredException.class, () -> game.round("Alice", "Bob"));
    }

    @Test
    public void shouldReturnWinnerCorrectly() {
        Game game = new Game();
        Player player1 = new Player(1, "Alice", 100);
        Player player2 = new Player(2, "Bob", 90);
        game.register(player1);
        game.register(player2);

        assertEquals(1, game.round("Alice", "Bob"));
        assertEquals(2, game.round("Bob", "Alice"));
        assertEquals(0, game.round("Alice", "Alice"));
    }

    @Test
    public void shouldReturnDrawIfPlayersHaveEqualStrength() {
        Game game = new Game();
        Player player1 = new Player(1, "Alice", 100);
        Player player2 = new Player(2, "Bob", 100);
        game.register(player1);
        game.register(player2);

        int result = game.round("Alice", "Bob");
        assertEquals(0, result);
    }

    @Test
    public void shouldThrowExceptionIfOnePlayerNotRegistered() {
        Game game = new Game();
        Player player1 = new Player(1, "Alice", 100);
        game.register(player1);

        assertThrows(NotRegisteredException.class, () -> game.round("Alice", "Bob"));
    }

    @Test
    public void shouldGetPlayerDetails() {
        Player player = new Player(1, "Alice", 100);

        assertEquals(1, player.getId());
        assertEquals("Alice", player.getName());
        assertEquals(100, player.getStrength());
    }

    @Test
    public void shouldReturnToString() {
        Player player = new Player(1, "Alice", 100);
        String expected = "Player{id=1, name='Alice', strength=100}";

        assertEquals(expected, player.toString());
    }
}
