package com.snakesandladders.service

import com.snakesandladders.domain.MoveTokenData
import com.snakesandladders.dto.BoardGameResponse
import org.springframework.stereotype.Service

@Service
class TokenCanMoveAcrossTheBoardImpl : TokenCanMoveAcrossTheBoard {
    override fun moveToken(data: MoveTokenData): BoardGameResponse? {
        return BoardGameResponse(data)
    }
}