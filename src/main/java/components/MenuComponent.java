package components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.LoginPage;
import pages.RegisterPage;

public class MenuComponent extends BaseComponent{

    /**
     * Кнопка перехода на главную страницу
     */
    @FindBy(xpath = "//*[@class='navbar-brand']")
    private WebElement index;
    /**
     * Кнопка перехода на страницу авторизации
     */
    @FindBy(xpath = "//*[@id='basic-navbar-nav']//*[@href='/login']")
    private WebElement login;
    /**
     * Кнопка перехода на страницу регистрации
     */
    @FindBy(xpath = "//*[@id='basic-navbar-nav']//*[@href='/register']")
    private WebElement register;

    //Авторизованная зона
    /**
     * Кнопка разлогина
     */
    @FindBy(xpath = "//*[@id='basic-navbar-nav']//*[@role='button']")
    private WebElement logout;
    /**
     * Кнопка перехода на страницу списков желаний
     */
    @FindBy(xpath = "//*[@id='basic-navbar-nav']//*[@href='/wishlists']")
    private WebElement myLists;
    /**
     * Кнопка перехода на страницу пользователей
     */
    @FindBy(xpath = "//*[@id='basic-navbar-nav']//*[@href='/users']")
    private WebElement users;

    public MenuComponent(WebDriver driver) {
        super(driver);
    }

    /**
     * Переход на страницу авторизации
     * @return Страница авторизации
     */
    public LoginPage goToLoginPage(){
        click(login);
        return new LoginPage(driver);
    }

    /**
     * Переход на страницу регистрации
     * @return Страница регистрации
     */
    public RegisterPage goToRegisterPage(){
        click(register);
        return new RegisterPage(driver);
    }
}
