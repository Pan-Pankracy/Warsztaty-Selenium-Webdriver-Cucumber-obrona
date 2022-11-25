package tests;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class MystoreAccountEditTest {

    @RunWith(Cucumber.class)
    @CucumberOptions(features = "src/cucumber/features/mystore-account-edit.feature", plugin = {"pretty", "html:out"})
    public class mystoreAccountEditTest {

    }

}
