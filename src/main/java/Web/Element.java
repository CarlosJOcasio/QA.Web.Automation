package Web;

import org.openqa.selenium.By;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

enum Locator {
    id,
    name,
    cssSelector,
    xpath,
    linkText,
    className,
    partialLinkText,
    tagName,
    notDefined
}

public abstract class Element extends By {

    public By find(Locator type, String locator) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Method method = this.getClass().getMethod(type.toString());
        return (By)method.invoke(this, locator);
    }
}
