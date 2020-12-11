package com.snakesandladders.service

import com.snakesandladders.domain.MoveTokenData
import com.snakesandladders.dto.BoardGameResponse

interface TokenCanMoveAcrossTheBoard {
    fun moveToken(data: MoveTokenData): BoardGameResponse?
}