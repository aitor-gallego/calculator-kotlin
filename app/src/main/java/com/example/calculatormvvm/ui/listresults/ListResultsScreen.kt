package com.example.calculatormvvm.ui.listresults

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculatormvvm.data.repository.ResultRepository

@Composable
fun ListResultsScreen(
    viewModel: ListResultViewModel,
    repository: ResultRepository = ResultRepository
) {
    val resultList =
        repository.get()

    LazyColumn {
        items(
            resultList
        ) { result ->
            ResultItemComposable(
                "${result.number1} ${result.operation} ${result.number2} = ${result.result}"
            )
        }
    }
}

@Composable
fun ResultItemComposable(
    text: String
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 50.dp,
                vertical = 10.dp
            ),
        elevation = CardDefaults.cardElevation(
            6.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent,
            contentColor = Color.Transparent
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    MaterialTheme.colorScheme.background
                )
                .padding(
                    16.dp
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = text,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                style = TextStyle(
                    fontSize = 20.sp,
                    color = Color.DarkGray,
                )
            )
        }
    }
}

