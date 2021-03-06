package com.andalus.abo_med7at.analyticalgeometry.models.parabola

import com.andalus.abo_med7at.analyticalgeometry.models.Shape
import com.andalus.abo_med7at.analyticalgeometry.utils.Constants
import com.andalus.abo_med7at.analyticalgeometry.utils.Constants.ShapeNames.PARABOLA

abstract class Parabola : Shape {
    override val category: String
        get() = PARABOLA
    override val unableToDrawMessage: String
        get() = Constants.Messages.PARABOLA_UNABLE_TO_DRAW_MESSAGE
}