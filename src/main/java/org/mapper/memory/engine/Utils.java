package org.mapper.memory.engine;

public final class Utils {

    private Utils() {
    }

    public static Long next(Long qId) {

        return qId + 1;
    }

    public static Long previous(Long qId) {
        return qId - 1;
    }

}
