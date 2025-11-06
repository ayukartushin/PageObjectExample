package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.basePages.UnLoginZoneBasePage;

public class RegisterPage extends UnLoginZoneBasePage {

    @FindBy(xpath = "//*[@class='form-control' and @type='text']")
    private WebElement loginInput;
    @FindBy(xpath = "//*[@class='form-control' and @type='email']")
    private WebElement emailInput;
    @FindBy(xpath = "//*[@class='form-control' and @type='password']")
    private WebElement passwordInput;
    @FindBy(xpath = "//*[@type='submit']")
    private WebElement registerButton;

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Проверка открытия страницы
     *
     * @return true если открылась
     */
    @Override
    public boolean isPageLoaded() {
        try {
            wait.until(ExpectedConditions.urlMatches(".*/register$"));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public RegisterPage typeLogin(String login){
        type(loginInput, login);
        return this;
    }

    public RegisterPage typeEmail(String email){
        type(emailInput, email);
        return this;
    }

    public RegisterPage typePassword(String password){
        type(passwordInput, password);
        return this;
    }

    public LoginPage register(){
        click(registerButton);
        var page = new LoginPage(driver);
        page.isPageLoaded();
        return page;
    }
}
