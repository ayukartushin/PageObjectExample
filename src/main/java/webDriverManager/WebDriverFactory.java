package webDriverManager;

import exeptions.BrowserNotSupport;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {
    public static WebDriver getDriver(Browser browser) throws BrowserNotSupport {
        switch (browser){
            case CHROME -> {
                io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            }
            case FIREFOX -> {
                io.github.bonigarcia.wdm.WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            }
            default -> throw new BrowserNotSupport(browser.toString());
        }
    }
}
