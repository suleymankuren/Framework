package ui_test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginOpenMrsPage {

    public LoginOpenMrsPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "username")
    public WebElement userName;

    @FindBy(id = "password")
    public WebElement passWord;

    @FindBy(id = "Pharmacy")
    public WebElement locatioN;

    @FindBy(id = "loginButton")
    public WebElement loginButton;

    @FindBy(id = "error-message")
    public WebElement error;

    @FindBy(xpath = "//a[contains(text(),'Logout')]")
    public WebElement logoutButton;
}
