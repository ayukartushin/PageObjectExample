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

    /**
     * Ввод логина в поле
     * @param login логин
     * @return текущая страница
     */
    public RegisterPage typeLogin(String login){
        type(loginInput, login);
        return this;
    }

    /**
     * Ввод почты в поле
     * @param email почта
     * @return текущая страница
     */
    public RegisterPage typeEmail(String email){
        type(emailInput, email);
        return this;
    }

    /**
     * Ввод пароля в поле
     * @param password пароль
     * @return текущая страница
     */
    public RegisterPage typePassword(String password){
        type(passwordInput, password);
        return this;
    }

    /**
     * Нажатие на кнопку зарегистрировать
     * @return автопереход на страницу авторизации
     */
    public LoginPage register(){
        click(registerButton);
        var page = new LoginPage(driver);
        page.isPageLoaded();
        return page;
    }
}
