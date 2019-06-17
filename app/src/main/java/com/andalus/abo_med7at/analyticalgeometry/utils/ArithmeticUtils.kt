package com.andalus.abo_med7at.analyticalgeometry.utils

class ArithmeticUtils private constructor() {

    companion object {
        fun invertY(coordinate: Float, height: Int): Float {
            return coordinate * 20 + height / 2f - coordinate * 40
        }
    }

}