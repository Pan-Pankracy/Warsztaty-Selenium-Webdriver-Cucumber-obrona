package objectpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MystoreAddressesPage {

    private WebDriver driver;

    @FindBy(xpath = "//a[@data-link-action='add-address']")
    private WebElement createNewAddressBtn;

    @FindBy(xpath = "//article[@class = 'address']")
    private WebElement newAddress;

    @FindBy(id = "main")
    private List <WebElement> addresses;

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

    public String getAddressAsText() {
        WebElement address = addresses.get(0);
        String addressDetails = address.findElement(By.xpath("//html/body/main/section/div/div/section/section/div[2]/article/div[1]")).getText();
        return addressDetails;
    }





}
