package com.example.calculatormvvm.ui.calculator

data class CalculatorState(
    val number1: String = "",
    val number2: String = "",
    val operation: String = "",
    var operationPressed: Boolean = false,
    val result: Float = 0f
)