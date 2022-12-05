package objectpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MystoreMainPage {

    private final WebDriver driver;

    @FindBy(css = ".user_login.navigation-link")
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
