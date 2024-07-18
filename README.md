MyStore Test Automation Project

This project is designed to automate the testing of the MyStore website using Selenium WebDriver with Java, Cucumber, and Gherkin.
Project Description

This project logs into a MyStore account, navigates to the addresses section, creates a new address, fills in the address details, and verifies that the entered details are correct.
Prerequisites

Before you begin, ensure you have met the following requirements:

-  Java JDK 8 or above
-  Maven
-  ChromeDriver (compatible with your version of Chrome)
-  temporary email service like 10minutemail
    
Installation

   1.  Clone this repository to your local machine:
      git clone https://github.com/your-repo/mystore-test-automation.git

   2.  Navigate to the project directory: cd mystore-test-automation
   3.  Install the project dependencies: mvn install  

Usage
Creating a User Manually

  1.  Go to: https://mystore-testlab.coderslab.pl.
  2.  Create a user manually. You can use a temporary email service like https://10minutemail.com/ to generate a temporary email address.  
    

Running the Tests

   1.  Open the project in your preferred IDE.
   2.  Update the chromedriver.exe path in the setup method if necessary.
   3.  Execute the tests using the following command: mvn test

Project Structure

   - src/test/java/tests: Contains test classes.
   - src/test/java/cucumber: Contains Cucumber step definitions.
   - src/test/resources/features: Contains feature files written in Gherkin.
   - src/test/resources/drivers: Contains WebDriver executables. 
    
Configuration

Ensure that the ChromeDriver path is correctly set in your system properties. You can update the path in the setup method:
System.setProperty("web-driver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");

Writing Tests

Below is an example of a test file using JUnit and Selenium:

package tests;

import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class MystoreAccountEditTest {

    private static WebDriver driver;

    @BeforeEach
    public void setup() {
        System.setProperty("web-driver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
    }
}

Below is an example of Cucumber step definitions:

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

Contributing

If you would like to contribute to this project, please fork the repository and submit a pull request. We welcome any contributions that improve the project.

License

This project is licensed under the MIT License - see the LICENSE file for details.

Contact

For more information or help, please contact [christian.grzeszczuk@outlook.com].




    

    
