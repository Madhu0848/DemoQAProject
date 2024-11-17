package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InteractionsPage {
    WebDriver driver;

    public InteractionsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//div[text()=\"Interactions\"]")

     private WebElement interactionsLink;

    public WebElement getInteractionsLink() {
        return interactionsLink;
    }
}
