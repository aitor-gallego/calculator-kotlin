package com.example.calculatormvvm.data.repository

import com.example.calculatormvvm.data.model.Result

object ResultRepository {
    private var resultList: MutableList<Result> =
        mutableListOf()

    fun add(
        number1: String,
        number2: String,
        operation: String,
        result: String
    ) {
        resultList.add(
            Result(
                number1,
                number2,
                operation,
                result
            )
        )
    }

    fun get(): MutableList<Result> {
        return resultList
    }
}