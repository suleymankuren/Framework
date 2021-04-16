package ui_test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PatientRegisterOpenMrsPage {

    public PatientRegisterOpenMrsPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "referenceapplication-registrationapp-registerPatient-homepageLink-referenceapplication-registrationapp-registerPatient-homepageLink-extension")
    public WebElement registerButton;

    @FindBy(name = "givenName")
    public WebElement givenName;

    @FindBy(name = "familyName")
    public WebElement familyName;

    @FindBy(xpath = "//span[@id='genderLabel']")
    public WebElement genderLabel;

    @FindBy(id = "gender-field")
    public WebElement patientGender;

    @FindBy(xpath = "//span[@id='birthdateLabel']")
    public WebElement birthdayLabel;

    @FindBy(id = "birthdateDay-field")
    public WebElement birthDay;

    @FindBy(id = "birthdateMonth-field")
    public WebElement birthMonth;

    @FindBy(id = "birthdateYear-field")
    public WebElement birthYear;

    @FindBy(xpath = "//span[.='Address']")
    public WebElement addressField;

    @FindBy(id = "address1")
    public WebElement address;

    @FindBy(id = "cityVillage")
    public WebElement city;

    @FindBy(id = "stateProvince")
    public WebElement state;

    @FindBy(id = "country")
    public WebElement country;

    @FindBy(id = "postalCode")
    public WebElement postalCode;

    @FindBy(xpath = "//span[.='Phone Number']")
    public WebElement phoneNumberField;

    @FindBy(name = "phoneNumber")
    public WebElement phoneNumber;

    @FindBy(xpath = "//span[.='Relatives']")
    public WebElement relatives;

    @FindBy(id = "relationship_type")
    public WebElement relationOfRelative;

    @FindBy(xpath = "//input[@class='person-typeahead ng-pristine ng-untouched ng-valid ng-empty']")
    public WebElement relativeName;

    @FindBy(id = "confirmation_label")
    public WebElement confirm;

    @FindBy(id = "submit")
    public WebElement secondConfirm;

    @FindBy(className = "PersonName-givenName")
    public WebElement givenNameCheck;

    @FindBy(className = "field-error")
    public List<WebElement> errorMessages;

    @FindBy(xpath = "//div[contains(@class,'toast')]")
    public WebElement toastMessage;

    @FindBy(xpath = "//a[contains(@href,'openmrs/index')]")
    public WebElement mainPage;

}
