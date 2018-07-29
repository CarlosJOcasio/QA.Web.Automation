package schema;

import org.openqa.selenium.By;
import java.lang.reflect.Method;

class Invoke {
    void method(String className, String methodName, By arg1, By arg2) {
        try {
            Class<?> clazz = Class.forName(className);
            Method method = clazz.getDeclaredMethod(methodName, By.class, By.class);
            method.setAccessible(true);
            method.invoke(clazz.newInstance(), arg1, arg2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void method(String className, String methodName) {
        try {
            Class<?> clazz = Class.forName(className);
            Method method = clazz.getDeclaredMethod(methodName);
            method.setAccessible(true);
            method.invoke(clazz.newInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void method(String className, String methodName, String arg1) {
        try {
            Class<?> clazz = Class.forName(className);
            Method method = clazz.getDeclaredMethod(methodName, String.class);
            method.setAccessible(true);
            method.invoke(clazz.newInstance(), arg1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void method(String className, String methodName, By arg1) {
        try {
            Class<?> clazz = Class.forName(className);
            Method method = clazz.getDeclaredMethod(methodName, By.class);
            method.setAccessible(true);
            method.invoke(clazz.newInstance(), arg1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void method(String className, String methodName, By arg1, String arg2) {
        try {
            Class<?> clazz = Class.forName(className);
            Method method = clazz.getDeclaredMethod(methodName, By.class, String.class);
            method.setAccessible(true);
            method.invoke(clazz.newInstance(), arg1, arg2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}