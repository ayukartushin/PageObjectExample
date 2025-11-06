package components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tools.JScripts;

import java.time.Duration;

public class BaseComponent {
    protected WebDriver driver;
    protected final WebDriverWait wait;

    public BaseComponent(WebDriver driver){
        this.driver = driver;
        this.wait  = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    protected WebElement visible(WebElement el) {
        return wait.until(ExpectedConditions.visibilityOf(el));
    }

    protected WebElement clickable(WebElement el) {
        return wait.until(ExpectedConditions.elementToBeClickable(el));
    }

    protected void type(WebElement el, String text) {
        WebElement v = visible(el);
        var js = new JScripts(driver);
        js.scrollTo(v);
        js.highlight(v);
        v.clear();
        v.sendKeys(text);
        js.unhighlight(v);
    }

    protected void click(WebElement el) {
        var js = new JScripts(driver);
        js.scrollTo(el);
        js.highlight(el);
        clickable(el).click();
        js.unhighlight(el);
    }
}
