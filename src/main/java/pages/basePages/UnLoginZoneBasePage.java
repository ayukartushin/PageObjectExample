package pages.basePages;

import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.RegisterPage;

public abstract class UnLoginZoneBasePage extends BasePage{
    public UnLoginZoneBasePage(WebDriver driver) {
        super(driver);
    }

    /**
     * Переход на страницу Авторизации
     * @return страница авторизации
     */
    public LoginPage menuGoToLoginPage(){
        return menu.goToLoginPage();
    }

    /**
     * Переход на страницу Регистрации
     * @return страница Регистрации
     */
    public RegisterPage menuGoToRegisterPage(){
        return menu.goToRegisterPage();
    }
}
