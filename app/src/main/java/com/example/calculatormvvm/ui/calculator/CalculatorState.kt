package com.example.calculatormvvm.ui.calculator

data class CalculatorState(
    val number1: String = "",
    val number2: String = "",
    val operation: String = "",
    var operationPressed: Boolean = false,
    var number1Decimal: Boolean = false,
    var number2Decimal: Boolean = false,
    val result: String = ""
)