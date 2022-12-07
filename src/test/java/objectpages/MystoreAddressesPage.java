package objectpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

public class MystoreAddressesPage {

    private WebDriver driver;

    @FindBy(xpath = "//a[@data-link-action='add-address']")
    private WebElement createNewAddressBtn;

    @FindBy(xpath = "//article[@class = 'address']")
    private WebElement newAddress;

    @FindBy(className = "address-body")
    private List<WebElement> addresses;

    public MystoreAddressesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public MystoreNewAddressPage addNewAddress() {
        createNewAddressBtn.click();
        return new MystoreNewAddressPage(driver);
    }

    public boolean newAddressIsVisible() {
        return newAddress.isDisplayed();
    }

    public String getAddressDetails() {
        return newAddress.getText();
    }

    public String getAddressAsText() {
        WebElement address = addresses.get(addresses.size() - 1);
        String[] addressDetails = address.getText().split("\n");
        return Arrays.toString(addressDetails);
    }


}
