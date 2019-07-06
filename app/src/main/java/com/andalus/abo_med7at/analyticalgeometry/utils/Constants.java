package com.andalus.abo_med7at.analyticalgeometry.utils;

public class Constants {

    public class Keys {
        public static final String SHAPE = "shape";

        private Keys() {
        }
    }

    public class Messages {
        private Messages() {
        }

        public static final String MISSING_DATA =
                "Some data are missing, please fill them and try again!";
        public static final String ZOOM_MESSAGE = "Pinch to zoom";
    }

    public class ShapeNames {
        private ShapeNames() {
        }

        public static final String CIRCLE = "Circle";
        public static final String ELLIPSE = "Ellipse";
        public static final String HYPERBOLA = "Hyperbola";
        public static final String PAIR_OF_LINES = "Pair Of Lines";
        public static final String PARABOLA = "Parabola";
        public static final String GENERAL = "General";
    }

    private Constants() {
    }
}
