package com.snakesandladders.resource

import com.snakesandladders.domain.MoveTokenData
import com.snakesandladders.dto.BoardGameResponse
import org.springframework.http.ResponseEntity

interface TokenCanMoveAcrossTheBoardResource {
    fun moveToken(data: MoveTokenData): ResponseEntity<BoardGameResponse>
}