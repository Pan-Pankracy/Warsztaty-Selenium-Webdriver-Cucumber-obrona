package objectpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MystoreMyaccountPage {

   private WebDriver driver;

   @FindBy(id="addresses-link")
    private WebElement addressesBtn;

    public MystoreMyaccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public MystoreAddressesPage enterAddressesPage() {
        addressesBtn.click();
        return new MystoreAddressesPage(driver);
    }



    }

