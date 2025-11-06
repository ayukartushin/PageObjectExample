import exeptions.BrowserNotSupport;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.LoginPage;
import tools.RandomStrings;
import webDriverManager.Browser;
import webDriverManager.WebDriverFactory;

public class RegisterTests {

    private WebDriver driver;

    @BeforeEach
    public void launchDriver() throws BrowserNotSupport {
        driver = WebDriverFactory.getDriver(Browser.FIREFOX);
        //TODO: Параметризировать
        driver.get("https://wishlist.otus.kartushin.su/");
    }

    @AfterEach
    public void closeDriver(){
        if (driver != null)
            driver.close();
    }

    @Test
    @DisplayName("Позитивная регистрация пользователя")
    @Tag("Positive")
    public void registerPositive() throws InterruptedException {
        String login = RandomStrings.getString(10);
        String password = RandomStrings.getString(10);
        String email = RandomStrings.getEmail(5);

        var actual = new LoginPage(driver)
                .menuGoToRegisterPage()
                .typeLogin(login)
                .typeEmail(email)
                .typePassword(password)
                .register()
                .getHeaderText();

        Assertions.assertEquals("Вход в систему", actual);
    }
}
