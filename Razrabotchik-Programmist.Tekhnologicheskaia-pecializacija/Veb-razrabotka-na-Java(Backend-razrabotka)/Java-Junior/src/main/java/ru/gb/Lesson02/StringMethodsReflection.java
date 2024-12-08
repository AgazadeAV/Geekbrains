package ru.gb.Lesson02;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringMethodsReflection {
    public static void main(String[] args) {
        Class<String> stringClass = String.class;

        Method[] methods = stringClass.getDeclaredMethods();

        System.out.println("Методы класса String:");

        for (Method method : methods) {
            String modifiers = Modifier.toString(method.getModifiers());

            String returnType = method.getReturnType().getSimpleName();

            String methodName = method.getName();

            Class<?>[] parameterTypes = method.getParameterTypes();
            String parameters = Stream.of(parameterTypes)
                    .map(Class::getSimpleName)
                    .collect(Collectors.joining(", "));

            System.out.printf("%s %s %s(%s)%n", modifiers, returnType, methodName, parameters);
        }
    }
}
