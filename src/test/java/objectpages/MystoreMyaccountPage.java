package objectpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MystoreMyaccountPage {

    private WebDriver driver;

    @FindBy(id = "addresses-link")
    private WebElement addressesBtn;

    @FindBy(name = "s")
    private WebElement searchField;

    @FindBy(xpath = "//button[@type = 'submit']")
    private WebElement searchSubmit;

    public MystoreMyaccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public MystoreAddressesPage enterAddressesPage() {
        addressesBtn.click();
        return new MystoreAddressesPage(driver);
    }

    public MystoreMyaccountPage searchItem(String item) {

        searchField.click();
        searchField.clear();
        searchField.sendKeys(item);
        searchSubmit.click();
        return new MystoreMyaccountPage(driver);
    }



}

