package cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import objectpages.MystoreAuthPage;
import objectpages.MystoreMyaccountPage;
import objectpages.MystoreNewAddressPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MystoreAccountEditSteps {

    MystoreNewAddressPage mystoreNewAddressPage;
    WebDriver driver;

    @Given("^I'm on the mystore main page$")
    public void openMainPageInBrowser() {
        System.setProperty("web-driver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.driver.get("https://mystore-testlab.coderslab.pl/index.php");

    }

    @When("^I go to the signin page$")
    public void signIn() {
        signIn();
    }

    @And("^I sign in with my credentials$")
    public void signInWithCredentials() {
        MystoreAuthPage mystoreAuthPage = new MystoreAuthPage(driver);
        mystoreAuthPage.signInWithCredentials("cngrbqzorrkigyrozf@tmmcv.com", "TestPass22");
    }

    @And("^I click on \"ADDRESSES\" card$")
    public void goToAddressesPage() {
        MystoreMyaccountPage mystoreMyaccountPage = new MystoreMyaccountPage(driver);
        mystoreMyaccountPage.enterAddressesPage();
    }

    @And("I fill in the address details alias {word}, address {word}, city {word}, zip/postal code {int} and phone {int}")
    public void enterNewAddressDetails() {
        mystoreNewAddressPage.provideNewAddressDetails("JJ", "Flat street 1", "Burmingham", 12345, 123456789 );

        mystoreNewAddressPage.saveNewAddress();
    }


}
