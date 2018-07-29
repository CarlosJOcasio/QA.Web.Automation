package Web;

import org.openqa.selenium.By;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class Element {
    public static By locate(LocatorType type, String locator) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, ClassNotFoundException {
        Method method;
        Object result = null;
        Class<?> c = Class.forName(org.openqa.selenium.By.class.getName());
        method = c.getMethod(type.toString(), String.class);
        result = method.invoke(c, locator);

        return (By) result;
    }
}