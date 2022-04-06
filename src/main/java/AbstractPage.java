import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AbstractPage {

    @FindBy(xpath = "//button[@data-role='accept-consent']")
    private WebElement acceptCookie;

    protected static WebDriver webDriver;

    public AbstractPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Method which accepted cookie
     */
    public void acceptingCookies(){
        acceptCookie.click();
    }
}