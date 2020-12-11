package com.snakesandladders.resource

import com.snakesandladders.domain.MoveTokenData
import com.snakesandladders.dto.BoardGameResponse
import com.snakesandladders.resource.TokenCanMoveAcrossTheBoardResourceImpl.Companion.BASE_URL
import com.snakesandladders.service.TokenCanMoveAcrossTheBoard
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(value = [BASE_URL])
class TokenCanMoveAcrossTheBoardResourceImpl(private val tokenMoveService: TokenCanMoveAcrossTheBoard) :
    TokenCanMoveAcrossTheBoardResource {

    @PostMapping
    override fun moveToken(@RequestBody data: MoveTokenData): ResponseEntity<BoardGameResponse> {
        val boardGameResponse = this.tokenMoveService.moveToken(data)
        return ResponseEntity.status(HttpStatus.OK).body(boardGameResponse)
    }
    
    companion object {
        const val BASE_URL: String = "/api/v1/movetoken"
    }
}