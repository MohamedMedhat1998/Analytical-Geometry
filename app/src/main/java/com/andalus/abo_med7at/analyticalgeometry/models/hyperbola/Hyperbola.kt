package com.andalus.abo_med7at.analyticalgeometry.models.hyperbola

import com.andalus.abo_med7at.analyticalgeometry.models.Shape
import com.andalus.abo_med7at.analyticalgeometry.utils.Constants.Messages.HYPERBOLA_UNABLE_TO_DRAW_MESSAGE
import com.andalus.abo_med7at.analyticalgeometry.utils.Constants.ShapeNames.HYPERBOLA

abstract class Hyperbola : Shape {
    override val category: String
        get() = HYPERBOLA
    override val unableToDrawMessage: String
        get() = HYPERBOLA_UNABLE_TO_DRAW_MESSAGE
}