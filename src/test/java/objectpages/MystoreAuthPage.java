package objectpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MystoreAuthPage {

    private WebDriver driver;

    @FindBy(id = "field-email")
    private WebElement emailInput;

    @FindBy(id = "field-password")
    private WebElement passwordInput;

    @FindBy(id = "submit-login")
    private WebElement submitBtn;

    public MystoreAuthPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public MystoreMyaccountPage signInWithCredentials(String email, String password) {

        emailInput.clear();
        emailInput.sendKeys(email);
        passwordInput.clear();
        passwordInput.sendKeys(password);
        submitBtn.click();
        return new MystoreMyaccountPage((driver));
    }


}
