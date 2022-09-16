package com.example.infinitebutton.tech

fun forAllCombination(
    range1: IntRange,
    range2: IntRange,
    func: (Int, Int) -> Unit
) = range1.forEach { r1 ->
    range2.forEach { r2 ->
        func(r1, r2)
    }
}