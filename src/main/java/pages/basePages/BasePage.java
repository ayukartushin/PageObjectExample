package pages.basePages;

import components.MenuComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    protected WebDriver driver;
    protected final WebDriverWait wait;

    protected MenuComponent menu;

    public BasePage(WebDriver driver){
        this.driver = driver;
        this.wait  = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
        menu = new MenuComponent(driver);
    }

    protected WebElement visible(WebElement el) {
        return wait.until(ExpectedConditions.visibilityOf(el));
    }

    protected WebElement clickable(WebElement el) {
        return wait.until(ExpectedConditions.elementToBeClickable(el));
    }

    protected void type(WebElement el, String text) {
        WebElement v = visible(el);
        v.clear();
        v.sendKeys(text);
    }

    protected void click(WebElement el) {
        clickable(el).click();
    }

    /**
     * Проверка открытия страницы
     * @return true если открылась
     */
    public abstract boolean isPageLoaded();
}
