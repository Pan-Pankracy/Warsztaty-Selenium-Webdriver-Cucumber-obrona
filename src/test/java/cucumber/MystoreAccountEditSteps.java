package cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import objectpages.MystoreAddressesPage;
import objectpages.MystoreAuthPage;
import objectpages.MystoreMyaccountPage;
import objectpages.MystoreNewAddressPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MystoreAccountEditSteps {

    private MystoreNewAddressPage mystoreNewAddressPage;
    private MystoreAddressesPage mystoreAddressesPage;
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

    @And("I fill in the address details {string} {string} {string} {int} and {int}")
    public void enterNewAddressDetails() {
        mystoreNewAddressPage.provideNewAddressDetails("JJ", "Flat street 1", "Burmingham", 12345, 123456789);

        mystoreNewAddressPage.saveNewAddress();
    }

    @And("I save the changes")
    public void saveChanges() {
        mystoreNewAddressPage.saveNewAddress();
    }

    @Then("I can see the new address on the addresses page")
    public void seeNewAddress() {
        Assertions.assertTrue(mystoreAddressesPage.newAddressIsVisible());
    }

    @And("Verify the created address {string} {string} {string} {int} and {int}")
    public void verifyCreatedAddress(String alias, String address, String postalCode, String city, String
            phoneNumber) {
        String addressAsText = mystoreAddressesPage.getAddressAsText();
        String expectedAddress = String.join(alias.toUpperCase(), address, postalCode, city, phoneNumber);
        Assertions.assertEquals(expectedAddress, addressAsText);

    }


}
