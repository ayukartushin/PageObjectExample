package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.basePages.UnLoginZoneBasePage;

public class LoginPage extends UnLoginZoneBasePage {

    @FindBy(xpath = "//*[@class='form-control' and @type='text']")
    private WebElement loginInput;
    @FindBy(xpath = "//*[@class='form-control' and @type='password']")
    private WebElement passwordInput;
    @FindBy(xpath = "//*[@type='submit']")
    private WebElement loginButton;
    @FindBy(xpath = "//h2")
    private WebElement header;

    public LoginPage(WebDriver driver) {
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
            wait.until(ExpectedConditions.urlMatches(".*/login$"));
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
    public LoginPage typeLogin(String login){
        type(loginInput, login);
        return this;
    }

    /**
     * Ввод пароля в поле
     * @param password пароль
     * @return текущая страница
     */
    public LoginPage typePassword(String password){
        type(passwordInput, password);
        return this;
    }

    /**
     * Нажатие на кнопку Войти
     * @return автопереход в ЛК
     */
    public WishlistPage loginButtonClick(){
        click(loginButton);
        return new WishlistPage(driver);
    }

    /**
     * Получить текст из заголовка
     * @return текст из заголовка
     */
    public String getHeaderText(){
        return header.getText();
    }
}
