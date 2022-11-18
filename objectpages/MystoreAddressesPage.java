package objectpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MystoreAddressesPage {

    private WebDriver driver;

    @FindBy(xpath = "//a[@data-link-action='add-address']")
    private WebElement createNewAddressBtn;

    @FindBy(xpath = "//article[@class = 'address']")
    private WebElement newAddress;

    public MystoreAddressesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean newAddressIsVisible() {
        return newAddress.isDisplayed();
    }

    public String getAddressDetails() {
        return newAddress.getText();
    }




}
