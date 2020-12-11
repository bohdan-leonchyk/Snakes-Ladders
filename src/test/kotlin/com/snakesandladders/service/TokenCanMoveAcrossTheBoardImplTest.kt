package com.snakesandladders.service

import com.snakesandladders.exception.GameNotStartedException
import com.snakesandladders.exception.NoSuchPlayerException
import org.junit.Test

class TokenCanMoveAcrossTheBoardImplTest {

    @Test(expected = GameNotStartedException::class)
    fun `game is not started exception`() {
    }

    @Test(expected = NoSuchPlayerException::class)
    fun `no such player exception`() {
    }

    @Test
    fun `token start position when game started`() {
    }

    @Test
    fun `token position after first roll`() {
    }

    @Test
    fun `token position after second roll`() {
    }
}