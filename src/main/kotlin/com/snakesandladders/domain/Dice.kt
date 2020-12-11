package com.snakesandladders.domain

class Dice {
    fun roll(): Int {
        return (0..7).random()
    }
}