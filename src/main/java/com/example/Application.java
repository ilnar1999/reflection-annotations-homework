package com.example;

import com.example.annotation.Secured;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> entityClass = Class.forName("com.example.entity.Entity");
        List<Method> methods = Arrays.stream(entityClass.getDeclaredMethods())
                .filter(Application::hasIntegerParameter)
                .filter(method -> method.isAnnotationPresent(Secured.class))
                .collect(Collectors.toList());

        for (Method method : methods) {
            System.out.println(method + " " + method.getAnnotation(Secured.class));
        }
    }

    public static boolean hasIntegerParameter(Method method) {
        return Arrays.stream(method.getParameterTypes())
                .anyMatch(type -> type.equals(Integer.class) || type.equals(int.class));
    }
}