package com.andalus.abo_med7at.analyticalgeometry.models.pair_of_lines

import com.andalus.abo_med7at.analyticalgeometry.models.Shape
import com.andalus.abo_med7at.analyticalgeometry.utils.Constants.ShapeNames.PAIR_OF_LINES

abstract class PairOfLines : Shape {
    override val category: String
        get() = PAIR_OF_LINES
}