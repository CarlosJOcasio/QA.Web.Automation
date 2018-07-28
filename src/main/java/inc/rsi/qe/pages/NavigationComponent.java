package inc.rsi.qe.pages;

import Web.WepPageComponent;

public class NavigationComponent extends WepPageComponent {
    private final NavigationElement element = new NavigationElement();

    public void clickAboutUsLink() {
        clickNavigatorLink(element.getMenuButton(), element.getAboutUsLink());
    }
}
