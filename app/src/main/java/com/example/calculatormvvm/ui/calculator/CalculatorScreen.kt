package com.example.calculatormvvm.ui.calculator

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(
    ExperimentalMaterial3Api::class
)
@Composable
fun CalculatorScreen(
    viewModel: CalculatorViewModel,
    modifier: Modifier = Modifier
) {
    val state by viewModel.state

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Calculator"
                    )
                })
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(
                        paddingValues
                    )
                    .padding(
                        5.dp
                    )
            ) {
                Row(
                    modifier = modifier
                        .fillMaxWidth()
                        .height(
                            100.dp
                        ),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.Bottom
                ) {
                    Column(
                        modifier = Modifier
                            .padding(
                                horizontal = 10.dp,
                                vertical = 1.dp
                            )
                            .fillMaxWidth()
                    ) {
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = "${state.number1} ${state.operation} ${state.number2}",
                            textAlign = TextAlign.End,
                            style = TextStyle(
                                fontSize = 20.sp,
                                color = Color.LightGray
                            ),
                        )
                        Text(
                            modifier = Modifier.fillMaxWidth(),
                            text = if (!state.operationPressed) {
                                state.number1.ifEmpty {
                                    "0"
                                }
                            } else {
                                state.number2.ifEmpty {
                                    "0"
                                }
                            },
                            textAlign = TextAlign.End,
                            style = TextStyle(
                                fontSize = 60.sp,
                                color = Color.DarkGray
                            ),
                        )
                    }
                }
                Column(
                    modifier = modifier.fillMaxSize()
                ) {
                    Row(modifier = modifier.fillMaxWidth()) {
                        CalculatorButton(
                            onClick = {viewModel.onClickAC()},
                            symbol = "AC",
                            modifier = modifier.weight(
                                1f
                            )
                        )
                        CalculatorButton(
                            onClick = {viewModel.onClickDelete()},
                            symbol = "DEL",
                            modifier = modifier.weight(
                                2f
                            )
                        )
                        CalculatorButton(
                            onClick = {viewModel.onClickOperation(operationButton = "/")},
                            symbol = "/",
                            modifier = modifier.weight(
                                1f
                            )
                        )
                    }
                    Row(modifier = modifier.fillMaxWidth()) {
                        CalculatorButton(
                            onClick = {
                                viewModel.onClickNumber(
                                    "1"
                                )
                            },
                            symbol = "1",
                            modifier = modifier.weight(
                                1f
                            )
                        )
                        CalculatorButton(
                            onClick = {
                                viewModel.onClickNumber(
                                    "2"
                                )
                            },
                            symbol = "2",
                            modifier = modifier.weight(
                                1f
                            )
                        )
                        CalculatorButton(
                            onClick = {
                                viewModel.onClickNumber(
                                    "3"
                                )
                            },
                            symbol = "3",
                            modifier = modifier.weight(
                                1f
                            )
                        )
                        CalculatorButton(
                            onClick = {
                                viewModel.onClickOperation(
                                    "+"
                                )
                            },
                            symbol = "+",
                            modifier = modifier.weight(
                                1f
                            )
                        )
                    }
                    Row(modifier = modifier.fillMaxWidth()) {
                        CalculatorButton(
                            onClick = {
                                viewModel.onClickNumber(
                                    "4"
                                )
                            },
                            symbol = "4",
                            modifier = modifier.weight(
                                1f
                            )
                        )
                        CalculatorButton(
                            onClick = {
                                viewModel.onClickNumber(
                                    "5"
                                )
                            },
                            symbol = "5",
                            modifier = modifier.weight(
                                1f
                            )
                        )
                        CalculatorButton(
                            onClick = {
                                viewModel.onClickNumber(
                                    "6"
                                )
                            },
                            symbol = "6",
                            modifier = modifier.weight(
                                1f
                            )
                        )
                        CalculatorButton(
                            onClick = {
                                viewModel.onClickOperation(
                                    "-"
                                )
                            },
                            symbol = "-",
                            modifier = modifier.weight(
                                1f
                            )
                        )
                    }
                    Row(modifier = modifier.fillMaxWidth()) {
                        CalculatorButton(
                            onClick = {
                                viewModel.onClickNumber(
                                    "7"
                                )
                            },
                            symbol = "7",
                            modifier = modifier.weight(
                                1f
                            )
                        )
                        CalculatorButton(
                            onClick = {
                                viewModel.onClickNumber(
                                    "8"
                                )
                            },
                            symbol = "8",
                            modifier = modifier.weight(
                                1f
                            )
                        )
                        CalculatorButton(
                            onClick = {
                                viewModel.onClickNumber(
                                    "9"
                                )
                            },
                            symbol = "9",
                            modifier = modifier.weight(
                                1f
                            )
                        )
                        CalculatorButton(
                            onClick = {
                                viewModel.onClickOperation(
                                    "*"
                                )
                            },
                            symbol = "*",
                            modifier = modifier.weight(
                                1f
                            )
                        )
                    }
                    Row(modifier = modifier.fillMaxWidth()) {
                        CalculatorButton(
                            onClick = {
                                viewModel.onClickNumber(
                                    "0"
                                )
                            },
                            symbol = "0",
                            modifier = modifier.weight(
                                2f
                            )
                        )
                        CalculatorButton(
                            onClick = {viewModel.onClickDecimal()},
                            symbol = ".",
                            modifier = modifier.weight(
                                1f
                            )
                        )
                        CalculatorButton(
                            onClick = {
                                viewModel.onClickEqual()
                            },
                            symbol = "=",
                            modifier = modifier.weight(
                                1f
                            )
                        )
                    }
                }
            }
        })
}

@Composable
fun CalculatorButton(
    onClick: () -> Unit,
    symbol: String,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        shape = RoundedCornerShape(
            5.dp
        ),
        colors = ButtonDefaults.buttonColors(
            Color.LightGray
        ),
        modifier = modifier
            .size(
                75.dp
            )
            .padding(
                5.dp
            )
    ) {
        Text(
            text = symbol,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontSize = 25.sp,
                color = Color.DarkGray
            )
        )
    }
}

//@Preview
@Composable
fun CalculatorPreview() {
    CalculatorScreen(
        CalculatorViewModel()
    )
}