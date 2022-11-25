package objectpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MystoreSearchResultsPage {
    private WebDriver driver;

    @FindBy(css = "div.js-product")
    private WebElement searchItem;

    public MystoreSearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public MystoreSearchResultsPage selectSearchItem() {
        searchItem.click();
        return new MystoreSearchResultsPage(driver);
    }

}
