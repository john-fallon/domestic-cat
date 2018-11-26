package au.com.domesticcat.restaurants.util;

import java.util.Collection;

public class Util {
    public static int sizeOf(Collection c) {
        return c == null ? 0 : c.size();
    }
}
