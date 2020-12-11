package com.snakesandladders.service

import com.snakesandladders.domain.MoveTokenData
import com.snakesandladders.dto.BoardGameResponse
import com.snakesandladders.exception.GameNotStartedException
import com.snakesandladders.exception.NoSuchPlayerException
import org.springframework.stereotype.Service

@Service
class TokenCanMoveAcrossTheBoardImpl : TokenCanMoveAcrossTheBoard {
    override fun moveToken(data: MoveTokenData): BoardGameResponse? {
        if (data.game.isStarted) {
            for (player in data.game.players) {
                if (player.id == data.playerId) {
                    player.token.position += data.moves
                    return BoardGameResponse(data)
                }
            }
            throw NoSuchPlayerException(String.format("There is no such player with id: %d", data.playerId))
        }
        throw GameNotStartedException("Can not move. Game is not started.")
    }
}