import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class TestBase {

    @Getter
    protected static WebDriver webDriver;

    protected static String key = "webdriver.chrome.driver";
    protected static String value = "src/main/resources/chromedriver.exe";
    public static String main_path = "https://www.allegro.pl";


    @BeforeSuite
    public void before() {
        System.setProperty(key, value);

        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get(main_path);
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterSuite
    public void after() {
        webDriver.quit();
    }
}