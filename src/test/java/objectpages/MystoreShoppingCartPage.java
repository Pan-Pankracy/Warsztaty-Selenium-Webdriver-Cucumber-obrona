package objectpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MystoreShoppingCartPage {

    private WebDriver driver;

    @FindBy(css = ".checkout .btn-primary")
    private WebElement proceedToCheckoutBtn;


    public MystoreShoppingCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public MystoreShoppingCartPage proceedToCheckout() {
        proceedToCheckoutBtn.click();
        return new MystoreShoppingCartPage(driver);
    }
}
