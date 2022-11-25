package tests;

import objectpages.*;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.*;


import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;

public class MystoreOrderTest {

    private static WebDriver driver;

    @BeforeEach
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://mystore-testlab.coderslab.pl/index.php");
    }

    @Test
    public void orderTest() throws IOException {

        Date currentDate = new Date();
        String screenshotFileName = currentDate.toString().replace(" ", "-").replace(":", "-");

        MystoreMainPage mainPage = new MystoreMainPage(driver);
        MystoreAuthPage authPage = mainPage.signInPage();

        MystoreMyaccountPage myAccountPage = authPage.signInWithCredentials("cngrbqzorrkigyrozf@tmmcv.com", "TestPass22");
        myAccountPage.searchItem("Hummingbird Printed Sweater");
        MystoreSearchResultsPage searchResultsPage = new MystoreSearchResultsPage(driver);
        searchResultsPage.selectSearchItem();
        MystoreProductPage productPage = new MystoreProductPage(driver);
        productPage.addCustomItemToCart("5");
        MystoreShoppingCartPage shoppingCart = new MystoreShoppingCartPage(driver);
        shoppingCart.proceedToCheckout();
        MystoreCheckoutPage checkoutPage = new MystoreCheckoutPage(driver);
        checkoutPage.orderItem();


        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File(".//screenshots/" + screenshotFileName + ".png"));
    }
}

