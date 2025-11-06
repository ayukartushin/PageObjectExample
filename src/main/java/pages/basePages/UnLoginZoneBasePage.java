package pages.basePages;

import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.RegisterPage;

public abstract class UnLoginZoneBasePage extends BasePage{
    public UnLoginZoneBasePage(WebDriver driver) {
        super(driver);
    }

    public LoginPage menuGoToLoginPage(){
        return menu.goToLoginPage();
    }

    public RegisterPage menuGoToRegisterPage(){
        return menu.goToRegisterPage();
    }
}
