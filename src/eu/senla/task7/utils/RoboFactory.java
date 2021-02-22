package eu.senla.task7.utils;

import eu.senla.task7.entity.BodyType;
import eu.senla.task7.entity.HeadType;
import org.apache.commons.lang3.RandomUtils;

public class RoboFactory {

    public static BodyType createBody() {

        switch (RandomUtils.nextInt(1, 5)) {
            case 1:
                return BodyType.METAL;
            case 2:
                return BodyType.LIQUID_METAL;
            case 3:
                return BodyType.PLASTIK;
            case 4:
                return BodyType.WOOD;
            default:
                return BodyType.METAL;
        }
    }

    public static HeadType createHead() {
        switch (RandomUtils.nextInt(1, 5)) {
            case 1:
                return HeadType.CUBE;
            case 2:
                return HeadType.CYLINDER;
            case 3:
                return HeadType.OVAL;
            case 4:
                return HeadType.PARALLELEPIPED;
            default:
                return HeadType.CUBE;
        }
    }
}
