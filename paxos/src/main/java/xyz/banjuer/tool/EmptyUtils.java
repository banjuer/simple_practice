package xyz.banjuer.tool;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;

public class EmptyUtils {
    public EmptyUtils() {
    }

    public static boolean isEmpty(Object o) throws IllegalArgumentException {
        if (o == null) {
            return true;
        } else if (o instanceof String) {
            return ((String)o).length() == 0;
        } else if (o instanceof Collection) {
            return ((Collection)o).isEmpty();
        } else if (o.getClass().isArray()) {
            return Array.getLength(o) == 0;
        } else {
            return o instanceof Map ? ((Map)o).isEmpty() : false;
        }
    }

    public static boolean isNotEmpty(Object o) {
        return !isEmpty(o);
    }
}
