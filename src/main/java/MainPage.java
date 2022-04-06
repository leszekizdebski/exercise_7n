import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * The class shows how phones are counted and high price calculated
 *
 */
public class MainPage extends AbstractPage {

    @FindBy(xpath = "//input[@data-role='search-input']")
    private WebElement searchInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//span[normalize-space()='czarny']")
    private WebElement chooseBlackColor;

    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void putSerchingPhoneModel(String phonemodel){
        searchInput.sendKeys(phonemodel);
        submitButton.click();
    }

    /**
     * Method which choosing black color
     */
    public void choosingBlackColor(){
        chooseBlackColor.click();
    }

    /**
     * Method which count phones and print score
     */
    public void countPhonesAndPrint(){
        List<WebElement> products = webDriver.findElements(By.xpath("//span[contains(@class,'_1svub _lf05o')]"));
        System.out.println("Counted phones: " + products.size());
    }

    /**
     * Method which shows highest price and print score
     */
    public void showHighestPrices(){
        List<WebElement> priceElements = webDriver.findElements(By.xpath("//span[contains(@class,'_1svub _lf05o')]"));
        List<Double> listOfPrices = new ArrayList<Double>();

        for (int i=0; i<priceElements.size();i++) {
            try {
                listOfPrices.add(Double.parseDouble(priceElements.get(i).getText().replaceAll(",", ".").replaceAll(" ", "").replaceAll("zł", "")));
            }
            catch (org.openqa.selenium.StaleElementReferenceException ex)
            {
                listOfPrices.add(Double.parseDouble(priceElements.get(i).getText().replaceAll(",", ".").replaceAll(" ", "").replaceAll("zł", "")));
            }
            }
        Collections.sort(listOfPrices);
        System.out.println("Highest price: " + listOfPrices.get(listOfPrices.size()-1));
    }

}