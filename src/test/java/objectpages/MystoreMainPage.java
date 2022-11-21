package objectpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MystoreMainPage {

    private WebDriver driver;

    @FindBy(xpath = "//a[@title='Log in to your customer account']")
    private WebElement signInBtn;

    public MystoreMainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void signIn() {

        signInBtn.click();
    }

    public MystoreAuthPage signInPage() {
        signIn();
        return new MystoreAuthPage(driver);
    }




}
