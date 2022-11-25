package objectpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MystoreCheckoutPage {
    private WebDriver driver;

    @FindBy(name = "confirm-addresses")
    private WebElement confirmAddressBtn;

    @FindBy(name = "confirmDeliveryOption")
    private WebElement confirmDeliveryOptionBtn;

    @FindBy(id = "payment-option-1")
    private WebElement payByCheckRadioBtn;

    @FindBy(id = "conditions_to_approve[terms-and-conditions]")
    private WebElement termsOfAggrementCheckBox;

    @FindBy(css = ".ps-shown-by-js .center-block")
    private WebElement placeOrderBtn;

    public MystoreCheckoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public MystoreCheckoutPage orderItem() {
        confirmAddressBtn.click();
        confirmDeliveryOptionBtn.click();
        payByCheckRadioBtn.click();
        termsOfAggrementCheckBox.click();
        placeOrderBtn.click();
        return new MystoreCheckoutPage(driver);
    }
}
