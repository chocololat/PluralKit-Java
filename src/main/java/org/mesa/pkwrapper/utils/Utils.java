package org.mesa.pkwrapper.utils;

public class Utils {
    /**
     * Nullish coalescent operator equivalent [ ?? ]
     * If <b>object</b> is null, it will return <b>defaultObject</b>
     * @param object
     * @param defaultObject
     * @return
     * @param <T>
     */
    public static <T> T coalesce(T object, T defaultObject) {
        return object != null ? object : defaultObject;
    }
}