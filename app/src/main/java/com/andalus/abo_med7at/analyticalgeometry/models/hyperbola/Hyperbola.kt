package com.andalus.abo_med7at.analyticalgeometry.models.hyperbola

import com.andalus.abo_med7at.analyticalgeometry.models.Shape
import com.andalus.abo_med7at.analyticalgeometry.utils.Constants.ShapeNames.HYPERBOLA

abstract class Hyperbola : Shape{
    override val category: String
        get() = HYPERBOLA
}