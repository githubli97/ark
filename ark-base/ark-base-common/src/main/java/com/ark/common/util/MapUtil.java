package com.ark.common.util;

import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.Map;

public final class MapUtil {
    private MapUtil() {
    }

   public static <K, V> Map<K, V> simpleMap(K key, V value) {
        HashMap<K, V> result = Maps.newHashMapWithExpectedSize(1);
        result.put(key, value);
        return result;
    }
}
