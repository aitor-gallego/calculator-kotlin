package com.example.calculatormvvm.ui.calculator

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CalculatorScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.padding(5.dp)
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .height(100.dp),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.Bottom
        ) {
            Column (
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 1.dp)
            ){
                Text(
                    text = "0*0",
                    textAlign = TextAlign.Center,
                    style = TextStyle(fontSize = 20.sp, color = Color.LightGray),
                )
                Text(
                    text = "0",
                    textAlign = TextAlign.Center,
                    style = TextStyle(fontSize = 60.sp, color = Color.DarkGray),
                )
            }
        }
        Column (
            modifier = modifier.fillMaxSize()
        ){
            Row(modifier = modifier.fillMaxWidth()) {
                CalculatorButton(onClick = {}, symbol = "AC", modifier = modifier.weight(1f))
                CalculatorButton(onClick = {}, symbol = "DEL", modifier = modifier.weight(2f))
                CalculatorButton(onClick = {}, symbol = "/", modifier = modifier.weight(1f))
            }
            Row(modifier = modifier.fillMaxWidth()) {
                CalculatorButton(onClick = {}, symbol = "1", modifier = modifier.weight(1f))
                CalculatorButton(onClick = {}, symbol = "2", modifier = modifier.weight(1f))
                CalculatorButton(onClick = {}, symbol = "3", modifier = modifier.weight(1f))
                CalculatorButton(onClick = {}, symbol = "+", modifier = modifier.weight(1f))
            }
            Row(modifier = modifier.fillMaxWidth()) {
                CalculatorButton(onClick = {}, symbol = "4", modifier = modifier.weight(1f))
                CalculatorButton(onClick = {}, symbol = "5", modifier = modifier.weight(1f))
                CalculatorButton(onClick = {}, symbol = "6", modifier = modifier.weight(1f))
                CalculatorButton(onClick = {}, symbol = "-", modifier = modifier.weight(1f))
            }
            Row(modifier = modifier.fillMaxWidth()) {
                CalculatorButton(onClick = {}, symbol = "7", modifier = modifier.weight(1f))
                CalculatorButton(onClick = {}, symbol = "8", modifier = modifier.weight(1f))
                CalculatorButton(onClick = {}, symbol = "9", modifier = modifier.weight(1f))
                CalculatorButton(onClick = {}, symbol = "*", modifier = modifier.weight(1f))
            }
            Row(modifier = modifier.fillMaxWidth()) {
                CalculatorButton(onClick = {}, symbol = "0", modifier = modifier.weight(2f))
                CalculatorButton(onClick = {}, symbol = ".", modifier = modifier.weight(1f))
                CalculatorButton(onClick = {}, symbol = "=", modifier = modifier.weight(1f))
            }
        }
    }
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
        modifier = modifier.size(75.dp).padding(5.dp)
    ) {
        Text(
            text = symbol,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            style = TextStyle(fontSize = 25.sp, color = Color.DarkGray)
        )
    }
}

@Preview(
    showBackground = true
)
@Composable
fun PreviewCalculatorButton() {
    CalculatorScreen()
}
