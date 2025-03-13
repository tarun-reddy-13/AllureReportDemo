package allurereports;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ReportDemo {
    private WebDriver driver;

    @BeforeMethod
    public void init(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @SneakyThrows
    @Test(priority = 2)
    public void testLogin(){
        driver.get("https://opensource-demo.orangehrmlive.com/");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
        Assert.assertEquals("OrangeHRM1", driver.getTitle());
    }

    @SneakyThrows
    @Test(priority = 1)
    public void testLogoPresence(){
        driver.get("https://opensource-demo.orangehrmlive.com/");
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(By.xpath("//img[@alt=\"company-branding\"]")).isDisplayed());
    }

    @SneakyThrows
    @Test(priority = 3)
    public void forgotPassword(){
        throw new SkipException("Skipped the test");
    }

    @AfterMethod
    public void cleanUp(){
        if(driver!=null)
            driver.quit();
    }

}
