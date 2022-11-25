package objectpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class MystoreProductPage {
    private WebDriver driver;

    @FindBy(id = "group_1")
    private WebElement sizeDropdownBtn;

    @FindBy(xpath = "//option[@title='M']" )
    private WebElement sizeM;

    @FindBy(id = "quantity_wanted")
    private WebElement quantityInput;

    @FindBy(css = ".add-to-cart")
    private WebElement addToCartBtn;

    @FindBy(css = ".cart-content-btn .btn-primary")
    private WebElement proceedToCheckoutBtn;

    public MystoreProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public MystoreProductPage addCustomItemToCart(String inputAmount) {
        sizeDropdownBtn.click();
        sizeM.click();
        quantityInput.click();
        quantityInput.clear();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        quantityInput.sendKeys(inputAmount);
        addToCartBtn.click();
        proceedToCheckoutBtn.click();
        return new MystoreProductPage(driver);
    }


}
