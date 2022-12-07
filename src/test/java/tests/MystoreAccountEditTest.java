package tests;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

    @RunWith(Cucumber.class)
    @CucumberOptions(features = "src/cucumber/features/mystore-account-edit.feature", glue = {"cucumber"}, plugin = {"pretty", "html:out"})
    public class MystoreAccountEditTest {

    }

