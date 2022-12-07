package cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import objectpages.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;

public class MystoreAccountEditSteps {

    private MystoreNewAddressPage mystoreNewAddressPage;
    private MystoreAddressesPage mystoreAddressesPage;
    private WebDriver driver;

    @Given("I'm on the mystore main page")
    public void openMainPageInBrowser() {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
            this.driver = new ChromeDriver();
            this.driver.get("https://mystore-testlab.coderslab.pl/index.php");
    }

    @When("I go to the signin page")
    public void signInOnMainPage () {
        MystoreMainPage mainPage = new MystoreMainPage(driver);
        mainPage.signIn();
    }

    @And("I sign in with my credentials")
    public void signInWithCredentials() {
        MystoreAuthPage mystoreAuthPage = new MystoreAuthPage(driver);
        mystoreAuthPage.signInWithCredentials("cngrbqzorrkigyrozf@tmmcv.com", "TestPass22");
    }

    @And("I click on \"ADDRESSES\" card")
    public void goToAddressesPage() {
        MystoreMyaccountPage mystoreMyaccountPage = new MystoreMyaccountPage(driver);
        MystoreAddressesPage mystoreAddressesPage = mystoreMyaccountPage.enterAddressesPage();
        mystoreNewAddressPage = mystoreAddressesPage.addNewAddress();
    }

   /* @And("Create a new address")
    public void createNewAddress() {
        MystoreNewAddressPage mystoreNewAddressesPage = mystoreAddressesPage.addNewAddress();
    }*/

    @And("^I fill in the address details (.*?) (.*) (.*) (.*) and (.*)$")
    public void enterNewAddressDetails(String alias, String address, String city, int postalCode, int phone) {
        mystoreNewAddressPage.provideNewAddressDetails(alias, address, city, postalCode, phone);
    }

    @And("I save the changes")
    public void saveChanges() {
        mystoreAddressesPage = mystoreNewAddressPage.saveNewAddress();
    }

    @Then("I can see the new address on the addresses page")
    public void seeNewAddress() {
        Assertions.assertTrue(mystoreAddressesPage.newAddressIsVisible());
    }

    @And("Verify the created address {string} {string} {string} {string} {string} {string} and {string}")
    public void verifyCreatedAddress(String alias, String fullname, String address, String postalCode, String city, String country, String
            phoneNumber) {
        String addressAsText = mystoreAddressesPage.getAddressAsText();
        String[] expectedAddressDetails = {alias, fullname, address, postalCode, city, country, phoneNumber};
        String expectedAddress = Arrays.toString(expectedAddressDetails);
        Assertions.assertEquals(expectedAddress, addressAsText);
    }


}
