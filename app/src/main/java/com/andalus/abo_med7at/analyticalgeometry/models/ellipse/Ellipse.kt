package com.andalus.abo_med7at.analyticalgeometry.models.ellipse

import com.andalus.abo_med7at.analyticalgeometry.models.Shape
import com.andalus.abo_med7at.analyticalgeometry.utils.Constants.Messages.ELLIPSE_UNABLE_TO_DRAW_MESSAGE
import com.andalus.abo_med7at.analyticalgeometry.utils.Constants.ShapeNames.ELLIPSE

abstract class Ellipse : Shape {
    override val category: String
        get() = ELLIPSE
    override val unableToDrawMessage: String
        get() = ELLIPSE_UNABLE_TO_DRAW_MESSAGE
}