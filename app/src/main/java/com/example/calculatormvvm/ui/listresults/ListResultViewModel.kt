package com.example.calculatormvvm.ui.listresults

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class ListResultViewModel :
    ViewModel() {
    var state =
        mutableStateOf(
            ListResultState()
        )
        private set

}