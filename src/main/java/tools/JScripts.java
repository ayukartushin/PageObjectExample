package tools;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JScripts {
    private final WebDriver driver;

    public JScripts(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Универсальный метод выполнения JavaScript
     */
    public Object run(String script, Object... args) {
        return ((JavascriptExecutor) driver).executeScript(script, args);
    }

    /**
     * Подсветка элемента (включить рамку)
     */
    public void highlight(WebElement element) {
        run("arguments[0].style.border='2px solid red'", element);
    }

    /**
     * Убрать подсветку
     */
    public void unhighlight(WebElement element) {
        run("arguments[0].style.border='none'", element);
    }

    /**
     * Прокрутка до элемента
     */
    public void scrollTo(WebElement element) {
        run("arguments[0].scrollIntoView(true);", element);
    }

    /**
     * Клик через JS (если стандартный click() не работает)
     */
    public void jsClick(WebElement element) {
        run("arguments[0].click();", element);
    }
}
