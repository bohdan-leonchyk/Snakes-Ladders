package com.snakesandladders.service

import com.snakesandladders.domain.BoardGame
import com.snakesandladders.domain.MoveTokenData
import com.snakesandladders.domain.Player
import com.snakesandladders.domain.Token
import com.snakesandladders.exception.GameNotStartedException
import com.snakesandladders.exception.NoSuchPlayerException
import org.junit.Assert
import org.junit.Test

class TokenCanMoveAcrossTheBoardImplTest {

    @Test(expected = GameNotStartedException::class)
    fun `game is not started exception`() {
        val player = Player(VALID_PLAYER_ID, VALID_PLAYER_NAME, Token(VALID_TOKEN_ID, VALID_TOKEN_COLOR, 0))
        val game = BoardGame(arrayOf(player))
        Assert.assertFalse(game.isStarted)
        TokenCanMoveAcrossTheBoardImpl().moveToken(MoveTokenData(game, 4, VALID_PLAYER_ID))
    }

    @Test(expected = NoSuchPlayerException::class)
    fun `no such player exception`() {
        val player = Player(VALID_PLAYER_ID, VALID_PLAYER_NAME, Token(VALID_TOKEN_ID, VALID_TOKEN_COLOR, 0))
        val game = BoardGame(arrayOf(player))
        game.start()
        Assert.assertTrue(game.isStarted)
        TokenCanMoveAcrossTheBoardImpl().moveToken(MoveTokenData(game, 4, INVALID_PLAYER_ID))
    }

    @Test
    fun `token start position when game started`() {
        val player = Player(VALID_PLAYER_ID, VALID_PLAYER_NAME, Token(VALID_TOKEN_ID, VALID_TOKEN_COLOR, 0))
        val game = BoardGame(arrayOf(player))
        game.start()
        Assert.assertEquals(1, game.players[0].token.position)
    }

    @Test
    fun `token position after first roll`() {
        val player = Player(VALID_PLAYER_ID, VALID_PLAYER_NAME, Token(VALID_TOKEN_ID, VALID_TOKEN_COLOR, 0))
        val game = BoardGame(arrayOf(player))
        game.start()
        TokenCanMoveAcrossTheBoardImpl().moveToken(MoveTokenData(game, 3, VALID_PLAYER_ID))
        Assert.assertEquals(4, game.players[0].token.position)
    }

    @Test
    fun `token position after second roll`() {
        val player = Player(VALID_PLAYER_ID, VALID_PLAYER_NAME, Token(VALID_TOKEN_ID, VALID_TOKEN_COLOR, 0))
        val game = BoardGame(arrayOf(player))
        game.start()
        TokenCanMoveAcrossTheBoardImpl().moveToken(MoveTokenData(game, 3, VALID_PLAYER_ID))
        TokenCanMoveAcrossTheBoardImpl().moveToken(MoveTokenData(game, 4, VALID_PLAYER_ID))
        Assert.assertEquals(8, game.players[0].token.position)
    }

    companion object {
        const val VALID_PLAYER_ID = 1L
        const val INVALID_PLAYER_ID = 42L
        const val VALID_TOKEN_ID = 1L
        const val VALID_PLAYER_NAME = "John Doe"
        const val VALID_TOKEN_COLOR = "red"
    }
}