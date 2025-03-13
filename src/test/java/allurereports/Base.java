package allurereports;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
    private WebDriver driver;

    public void init(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    public WebDriver getDriver(){
        return driver;
    }
}
