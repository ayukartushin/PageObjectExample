package pages;

import org.openqa.selenium.WebDriver;
import pages.basePages.BasePage;

public class WishlistPage extends BasePage {
    public WishlistPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Проверка открытия страницы
     *
     * @return true если открылась
     */
    @Override
    public boolean isPageLoaded() {
        return false;
    }
}
