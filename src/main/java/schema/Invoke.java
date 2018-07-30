package schema;

import org.openqa.selenium.By;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Invoke {

    void method(String className, String methodName, By arg1, By arg2) throws IllegalAccessException, InstantiationException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException {
        Class<?> clazz = Class.forName(className);
        Method method = clazz.getDeclaredMethod(methodName, By.class, By.class);
        method.setAccessible(true);
        method.invoke(clazz.newInstance(), arg1, arg2);
    }

    void method(String className, String methodName) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<?> clazz = Class.forName(className);
        Method method = clazz.getDeclaredMethod(methodName);
        method.setAccessible(true);
        method.invoke(clazz.newInstance());
    }

    void method(String className, String methodName, String arg1) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<?> clazz = Class.forName(className);
        Method method = clazz.getDeclaredMethod(methodName, String.class);
        method.setAccessible(true);
        method.invoke(clazz.newInstance(), arg1);
    }

    void method(String className, String methodName, By arg1) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<?> clazz = Class.forName(className);
        Method method = clazz.getDeclaredMethod(methodName, By.class);
        method.setAccessible(true);
        method.invoke(clazz.newInstance(), arg1);
    }

    void method(String className, String methodName, By arg1, String arg2) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<?> clazz = Class.forName(className);
        Method method = clazz.getDeclaredMethod(methodName, By.class, String.class);
        method.setAccessible(true);
        method.invoke(clazz.newInstance(), arg1, arg2);
    }
}