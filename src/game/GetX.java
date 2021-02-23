package game;

import org.jbox2d.common.Vec2;



// adds functionality for extracting the X coordinate from a body position
public class GetX {
        public Float getX (Vec2 coord) {

            //formats a vec2 coordinate to a string
            String coordString = coord.toString();

           // splits the string and takes just the X coordinate
            coordString = coordString.split("\\(")[1];
            coordString = coordString.split(",")[0];

            return Float.parseFloat(coordString);
        }
    }
