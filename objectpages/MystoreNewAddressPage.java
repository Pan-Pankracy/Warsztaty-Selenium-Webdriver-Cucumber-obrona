package objectpages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MystoreNewAddressPage {

    private static WebDriver driver;

    @FindBy(id = "field-alias")
    private WebElement aliasInput;

    @FindBy(id = "field-address1")
    private WebElement addressInput;

    @FindBy(id = "field-city")
    private WebElement cityInput;

    @FindBy(id = "field-postcode")
    private WebElement zipPostalCodeInput;

    @FindBy(id = "field-id_country")
    private WebElement countryInput;

    @FindBy(xpath = "//option[@value='17']")
    private WebElement countryDropdownElement;

    @FindBy(id = "field-phone")
    private WebElement phoneInput;

    @FindBy(xpath = "//button[@class= 'btn btn-primary form-control-submit float-xs-right']")
    private WebElement saveBtn;

    public MystoreNewAddressPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void provideNewAddressDetails(String alias, String address, String city, int zipPostalCode, int phone) {

        aliasInput.clear();
        aliasInput.sendKeys(alias);

        addressInput.clear();
        addressInput.sendKeys(address);

        cityInput.clear();
        cityInput.sendKeys(city);

        zipPostalCodeInput.clear();
        zipPostalCodeInput.sendKeys(String.valueOf(zipPostalCode);

        phoneInput.clear();
        phoneInput.sendKeys(String.valueOf(phone);
    }

    public MystoreAddressesPage saveNewAddress() {
        saveBtn.click();
        return new MystoreAddressesPage(driver);
    }



}
