package com.example.calculatormvvm.ui.calculator

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CalculatorViewModel : ViewModel() {

    var state = mutableStateOf(CalculatorState())
        private set

    fun onClickNumber(numberButton: String) {
        if (!state.value.operationPressed)
            state.value =
                state.value.copy(
                    number1 = state.value.number1 + numberButton
                )
        else
            state.value =
                state.value.copy(
                    number2 = state.value.number2 + numberButton
                )
    }

    fun onClickOperation(operationButton: String) {
        state.value =
            state.value.copy(
                operation = operationButton
            )
        state.value =
            state.value.copy(
                operationPressed = true
            )
    }

    fun onClickEqual() {
        val number1 = if (state.value.number1.isNotEmpty()) state.value.number1.toFloat() else 0f
        val number2 = if (state.value.number2.isNotEmpty()) state.value.number2.toFloat() else 0f

        val operation: String =
            state.value.operation

        state.value =
            state.value.copy(
                result = when (operation) {
                    "+" -> number1 + number2
                    "-" -> number1 - number2
                    "*" -> number1 * number2
                    "/" -> {
                        if (number2 != 0f)
                            number1 / number2
                        else
                            -1f
                    }

                    else -> 0f
                }
            )

        state.value =
            state.value.copy(
                operationPressed = false
            )

        state.value =
            state.value.copy(
                number1 = state.value.result.toString()
            )

        state.value =
            state.value.copy(
                number2 = ""
            )

        state.value =
            state.value.copy(
                operation = ""
            )
    }

    fun onClickAC() {
        state.value =
            state.value.copy(
                operationPressed = false
            )

        state.value =
            state.value.copy(
                number1 = ""
            )

        state.value =
            state.value.copy(
                number2 = ""
            )

        state.value =
            state.value.copy(
                operation = ""
            )
    }

    fun onClickDelete() {

        if (state.value.operationPressed) {
            if (state.value.number2.isEmpty()){
                state.value =
                    state.value.copy(
                        operationPressed = false
                    )
                state.value =
                    state.value.copy(
                        operation = ""
                    )
            }
            else {
                state.value =
                    state.value.copy(
                        number2 = state.value.number2.dropLast(
                            1
                        )
                    )
            }
        } else {
            state.value =
                state.value.copy(
                    number1 = state.value.number1.dropLast(
                        1
                    )
                )
        }
    }

    fun onClickDecimal() {
        if (state.value.operationPressed) {
            if (state.value.number2.isNotEmpty()){
                state.value =
                    state.value.copy(
                        number2 = state.value.number2 + "."
                    )
            }
            else{
                state.value =
                    state.value.copy(
                        number2 = "0."
                    )
            }
        } else {
            if (state.value.number1.isNotEmpty()){
                state.value =
                    state.value.copy(
                        number1 = state.value.number1 + "."
                    )
            }
            else{
                state.value =
                    state.value.copy(
                        number1 = "0."
                    )
            }
        }
    }
}