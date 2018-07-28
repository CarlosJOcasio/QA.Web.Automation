package Web;

import org.openqa.selenium.By;
import java.lang.reflect.Method;

public abstract class Element {
    protected By locate(LocatorType type, String locator) {
        Method method;
        Object result = null;

        try {
            Class<?> c = Class.forName(org.openqa.selenium.By.class.getName());
            method = c.getMethod(type.toString(), String.class);
            result = method.invoke(c, locator);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return (By) result;
    }
}