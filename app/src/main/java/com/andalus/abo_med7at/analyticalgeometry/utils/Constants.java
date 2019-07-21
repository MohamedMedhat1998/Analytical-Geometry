package com.andalus.abo_med7at.analyticalgeometry.utils;

public class Constants {

    public class Keys {
        public static final String SHAPE = "shape";
        public static final String CAN_WELCOME = "can-welcome";

        private Keys() {
        }
    }

    public class Messages {
        private Messages() {
        }

        public static final String MISSING_DATA =
                "Some data are missing, please fill them and try again!";
        public static final String ZOOM_MESSAGE = "Pinch to zoom";

        public static final String CIRCLE_UNABLE_TO_DRAW_MESSAGE = "Not a circle";
        public static final String ELLIPSE_UNABLE_TO_DRAW_MESSAGE = "Not an ellipse";
        public static final String HYPERBOLA_UNABLE_TO_DRAW_MESSAGE = "Not a hyperbola";
        public static final String PAIR_OF_LINES_UNABLE_TO_DRAW_MESSAGE = "Not a pair";
        public static final String PARABOLA_UNABLE_TO_DRAW_MESSAGE = "Not a parabola";
        public static final String GENERAL_UNABLE_TO_DRAW_MESSAGE = "Unable to draw";

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
