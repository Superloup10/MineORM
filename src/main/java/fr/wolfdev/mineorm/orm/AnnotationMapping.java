package fr.wolfdev.mineorm.orm;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.stream.Stream;

public class AnnotationMapping
{
    public static Stream<Field> getAnnotations(Class clazz) {
        return Arrays.stream(clazz.getFields()).filter(f -> !Modifier.isStatic(f.getModifiers()) && f.isAnnotationPresent(SavedToNBT.class));
    }
}
