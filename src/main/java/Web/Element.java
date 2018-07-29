package Web;

import org.openqa.selenium.By;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class Element {
    public static By locate(LocatorType type, String locator) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, ClassNotFoundException {
        Class<?> clazz = Class.forName(org.openqa.selenium.By.class.getName());
        Method method = clazz.getMethod(type.toString(), String.class);
        return (By) method.invoke(clazz, locator);
    }
}