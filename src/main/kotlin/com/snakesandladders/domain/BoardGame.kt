package com.snakesandladders.domain

class BoardGame (var players: Array<Player>) {
    var isStarted: Boolean = false
    var isFinished: Boolean = false

    fun start() {
        isStarted = true
        for (player in players) {
            player.token.position = 1
        }
    }

    fun finish() {
        isFinished = true
    }
}