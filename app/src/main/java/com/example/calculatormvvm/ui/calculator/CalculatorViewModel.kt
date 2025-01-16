package com.example.calculatormvvm.ui.calculator

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.calculatormvvm.data.repository.ResultRepository

class CalculatorViewModel :
    ViewModel() {

    var state =
        mutableStateOf(
            CalculatorState()
        )
        private set


    fun onClickNumber(
        numberButton: String
    ) {
        if (!state.value.operationPressed) {
            if (state.value.number1 == "0") {
                state.value =
                    state.value.copy(
                        number1 = numberButton
                    )
            } else {
                state.value =
                    state.value.copy(
                        number1 = state.value.number1 + numberButton
                    )
            }
        } else {
            if (state.value.number1 == "0") {
                state.value =
                    state.value.copy(
                        number1 = numberButton
                    )
            } else {
                state.value =
                    state.value.copy(
                        number2 = state.value.number2 + numberButton
                    )
            }
        }
    }

    fun onClickOperation(
        operationButton: String
    ) {
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
        val number1 =
            if (state.value.number1.isNotEmpty() && state.value.number1.matches(
                    Regex(
                        "^[0-9.]+$"
                    )
                )
            ) state.value.number1.toFloat() else 0f
        val number2 =
            if (state.value.number2.isNotEmpty() && state.value.number2.matches(
                    Regex(
                        "^[0-9.]+$"
                    )
                )
            ) state.value.number2.toFloat() else 0f

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
                            "undefined"
                    }

                    else -> 0f
                }.toString()
            )

        saveResult(
            state.value.number1,
            state.value.number2,
            state.value.operation,
            state.value.result
        )

        state.value =
            state.value.copy(
                operationPressed = false
            )

        if (!state.value.number1.contains(
                "."
            )
        ) {
            state.value =
                state.value.copy(
                    number2Decimal = false
                )
        }

        if (state.value.result.endsWith(
                ".0"
            )
        ) {
            state.value =
                state.value.copy(
                    result = state.value.result.dropLast(
                        2
                    )
                )
        }
        state.value =
            state.value.copy(
                number1 = state.value.result
            )

        state.value =
            state.value.copy(
                number2 = ""
            )

        state.value =
            state.value.copy(
                operation = ""
            )

        state.value =
            state.value.copy(
                number2Decimal = false
            )
    }

    private fun saveResult(
        number1: String,
        number2: String,
        operation: String,
        result: String
    ) {
        ResultRepository.add(
            number1,
            number2,
            operation,
            result
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

        state.value =
            state.value.copy(
                number1Decimal = false
            )

        state.value =
            state.value.copy(
                number2Decimal = false
            )
    }

    fun onClickDelete() {
        if (state.value.operationPressed) {
            if (state.value.number2.isEmpty()) {
                state.value =
                    state.value.copy(
                        operationPressed = false
                    )
                state.value =
                    state.value.copy(
                        operation = ""
                    )
            } else {
                if (state.value.number2.last() == '.') {
                    state.value =
                        state.value.copy(
                            number2Decimal = false
                        )
                }

                state.value =
                    state.value.copy(
                        number2 = state.value.number2.dropLast(
                            1
                        )
                    )
            }
        } else {
            if (state.value.number1.isEmpty())
                return

            if (state.value.number1.last() == '.') {
                state.value =
                    state.value.copy(
                        number1Decimal = false
                    )
            }
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
            if (!state.value.number2Decimal) {
                if (state.value.number2.isNotEmpty()) {
                    state.value =
                        state.value.copy(
                            number2 = state.value.number2 + "."
                        )
                } else {
                    state.value =
                        state.value.copy(
                            number2 = "0."
                        )
                }
                state.value =
                    state.value.copy(
                        number2Decimal = true
                    )
            }
        } else {
            if (!state.value.number1Decimal) {
                if (state.value.number1.isNotEmpty()) {
                    state.value =
                        state.value.copy(
                            number1 = state.value.number1 + "."
                        )
                } else {
                    state.value =
                        state.value.copy(
                            number1 = "0."
                        )
                }
                state.value =
                    state.value.copy(
                        number1Decimal = true
                    )
            }
        }
    }
}