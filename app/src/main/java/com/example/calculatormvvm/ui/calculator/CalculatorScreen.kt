package com.example.calculatormvvm.ui.calculator

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CalculatorScreen(
    viewModel: CalculatorViewModel,
    modifier: Modifier = Modifier
) {
    val state by viewModel.state

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = modifier
                .padding(
                    5.dp
                )
                .fillMaxWidth()
                .fillMaxHeight()
                .align(
                    Alignment.BottomCenter
                )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(
                        1.5f
                    )
                    .padding(
                        horizontal = 15.dp
                    ),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.Bottom
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = "${state.number1} ${state.operation} ${state.number2}",
                        textAlign = TextAlign.End,
                        style = TextStyle(
                            fontSize = 20.sp,
                            color = Color.LightGray
                        )
                    )
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = if (!state.operationPressed) {
                            state.number1.ifEmpty { "0" }
                        } else {
                            state.number2.ifEmpty { "0" }
                        },
                        textAlign = TextAlign.End,
                        style = TextStyle(
                            fontSize = 60.sp,
                            color = Color.DarkGray
                        )
                    )
                }
            }

            Column(
                modifier = modifier
                    .weight(
                        2f
                    )
                    .fillMaxHeight()
                    .padding(
                        horizontal = 5.dp
                    ),
                verticalArrangement = Arrangement.Bottom
            ) {
                listOf(
                    listOf(
                        "AC",
                        "DEL",
                        "/"
                    ),
                    listOf(
                        "1",
                        "2",
                        "3",
                        "+"
                    ),
                    listOf(
                        "4",
                        "5",
                        "6",
                        "-"
                    ),
                    listOf(
                        "7",
                        "8",
                        "9",
                        "*"
                    ),
                    listOf(
                        "0",
                        ".",
                        "="
                    )
                ).forEach { row ->
                    Row(modifier = Modifier.fillMaxWidth()) {
                        row.forEach { symbol ->
                            CalculatorButton(
                                onClick = {
                                    when (symbol) {
                                        "AC" -> viewModel.onClickAC()
                                        "DEL" -> viewModel.onClickDelete()
                                        "/" -> viewModel.onClickOperation(
                                            "/"
                                        )

                                        "+" -> viewModel.onClickOperation(
                                            "+"
                                        )

                                        "-" -> viewModel.onClickOperation(
                                            "-"
                                        )

                                        "*" -> viewModel.onClickOperation(
                                            "*"
                                        )

                                        "=" -> viewModel.onClickEqual()
                                        "." -> viewModel.onClickDecimal()
                                        else -> viewModel.onClickNumber(
                                            symbol
                                        )
                                    }
                                },
                                symbol = symbol,
                                modifier = Modifier.weight(
                                    if (symbol == "0" || symbol == "DEL") 2f else 1f
                                ),
                                buttonColor = when {
                                    symbol.toIntOrNull() != null || symbol == "." -> MaterialTheme.colorScheme.secondary

                                    else -> MaterialTheme.colorScheme.background
                                },
                                buttonTextColor = when {
                                    symbol.toIntOrNull() != null || symbol == "." -> MaterialTheme.colorScheme.onSecondary
                                    else -> MaterialTheme.colorScheme.onBackground
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun CalculatorButton(
    onClick: () -> Unit,
    symbol: String,
    modifier: Modifier = Modifier,
    buttonColor: Color,
    buttonTextColor: Color,
    elevation: Dp = 5.dp
) {
    Surface(
        shape = RoundedCornerShape(
            5.dp
        ),
        shadowElevation = elevation,
        modifier = modifier
            .padding(
                5.dp
            )
    ) {
        Button(
            onClick = onClick,
            shape = RoundedCornerShape(
                5.dp
            ),
            colors = ButtonDefaults.buttonColors(
                containerColor = buttonColor
            ),
            modifier = Modifier
                .size(
                    70.dp
                )
        ) {
            Text(
                text = symbol,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                style = TextStyle(
                    fontSize = 25.sp,
                    color = buttonTextColor
                )
            )
        }
    }
}


@Preview
@Composable
fun CalculatorPreview() {
    CalculatorScreen(
        CalculatorViewModel()
    )
}