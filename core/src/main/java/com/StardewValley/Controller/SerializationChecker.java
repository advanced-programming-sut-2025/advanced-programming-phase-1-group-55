package com.StardewValley.Controller;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

public class SerializationChecker {
    private static Set<Class<?>> visited = new HashSet<>();

    public static void checkClass(Object obj) {
        if (obj == null) return;
        Class<?> clazz = obj.getClass();
        if (visited.contains(clazz)) return;
        visited.add(clazz);

        if (!(obj instanceof Serializable)) {
            System.out.println("Not Serializable: " + clazz.getName());
        }

        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            try {
                Object value = field.get(obj);
                if (value != null && !field.getType().isPrimitive()) {
                    checkClass(value);
                }
            } catch (Exception ignored) {}
        }
    }
}
