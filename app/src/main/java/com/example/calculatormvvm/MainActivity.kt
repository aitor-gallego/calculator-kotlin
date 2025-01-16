package com.example.calculatormvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.calculatormvvm.ui.calculator.CalculatorScreen
import com.example.calculatormvvm.ui.calculator.CalculatorViewModel
import com.example.calculatormvvm.ui.listresults.ListResultViewModel
import com.example.calculatormvvm.ui.listresults.ListResultsScreen
import com.example.calculatormvvm.ui.theme.CalculatorMVVMTheme

class MainActivity :
    ComponentActivity() {
    private val list: ListResultViewModel =
        ListResultViewModel()
    private val calculator: CalculatorViewModel =
        CalculatorViewModel()

    @OptIn(
        ExperimentalMaterial3Api::class
    )
    override fun onCreate(
        savedInstanceState: Bundle?
    ) {
        super.onCreate(
            savedInstanceState
        )

        enableEdgeToEdge()

        setContent {
            val navController =
                rememberNavController()

            CalculatorMVVMTheme {
                val scrollBehavior =
                    TopAppBarDefaults.pinnedScrollBehavior(
                        rememberTopAppBarState()
                    )
                Scaffold(
                    modifier = Modifier.nestedScroll(
                        scrollBehavior.nestedScrollConnection
                    ),
                    topBar = {
                        CenterAlignedTopAppBar(
                            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                                containerColor = Color.Transparent,
                                titleContentColor = Color.Black,
                            ),
                            title = {
                                Text(
                                    "Calculator",
                                    textAlign = TextAlign.Start,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                            },
                            actions = {
                                IconButton(
                                    onClick = {
                                        navController.navigate(
                                            "CalculatorScreen"
                                        )
                                    }) {
                                    Icon(
                                        tint = Color.DarkGray,
                                        painter = painterResource(
                                            id = R.drawable.material_symbols_outlined_calculate
                                        ),
                                        contentDescription = "Listar Resultados"
                                    )
                                }
                                IconButton(
                                    onClick = {
                                        navController.navigate(
                                            "ListResultScreen"
                                        )
                                    }) {
                                    Icon(
                                        tint = Color.DarkGray,
                                        painter = painterResource(
                                            id = R.drawable.material_symbols_outlined_filter_list
                                        ),
                                        contentDescription = "Listar Operaciones"
                                    )
                                }
                            },
                            scrollBehavior = scrollBehavior,
                        )
                    },
                    content = { paddingValues ->
                        NavHost(
                            modifier = Modifier.padding(
                                paddingValues
                            ),
                            navController = navController,
                            startDestination = "CalculatorScreen"
                        ) {
                            composable(
                                "CalculatorScreen"
                            ) {
                                CalculatorScreen(
                                    calculator
                                )
                            }

                            composable(
                                "ListResultScreen"
                            ) {
                                ListResultsScreen(
                                    list
                                )
                            }
                        }
                    }
                )
            }
        }
    }
}