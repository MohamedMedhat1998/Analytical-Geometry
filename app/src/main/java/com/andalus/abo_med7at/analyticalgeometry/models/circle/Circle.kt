package com.andalus.abo_med7at.analyticalgeometry.models.circle

import com.andalus.abo_med7at.analyticalgeometry.models.Shape
import com.andalus.abo_med7at.analyticalgeometry.utils.Constants.Messages.CIRCLE_UNABLE_TO_DRAW_MESSAGE
import com.andalus.abo_med7at.analyticalgeometry.utils.Constants.ShapeNames.CIRCLE

abstract class Circle : Shape {
    override val category: String
        get() = CIRCLE
    override val unableToDrawMessage: String
        get() = CIRCLE_UNABLE_TO_DRAW_MESSAGE
}