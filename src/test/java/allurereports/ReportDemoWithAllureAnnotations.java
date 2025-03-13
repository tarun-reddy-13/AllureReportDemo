package allurereports;

import io.qameta.allure.*;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ReportDemoWithAllureAnnotations extends Base{
    private WebDriver driver;

    @BeforeMethod
    public void setUp(){
        init();
        driver = getDriver();
    }

    @SneakyThrows
    @Test(priority = 2)
    @Description("Login test case")
    @Epic("EPIC-001")
    @Feature("Feature-002")
    @Step("Verify login")
    @Severity(SeverityLevel.BLOCKER)
    public void testLogin(){
        driver.get("https://opensource-demo.orangehrmlive.com/");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
        Assert.assertEquals("OrangeHRM1", driver.getTitle());
    }

    @SneakyThrows
    @Test(priority = 1, description = "Verify presence of Logo on home page")
    @Description("logo presence test case")
    @Epic("EPIC-001")
    @Feature("Feature-001")
    @Step("Verify logo presence")
    public void testLogoPresence(){
        driver.get("https://opensource-demo.orangehrmlive.com/");
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(By.xpath("//img[@alt=\"company-branding\"]")).isDisplayed());
    }

    @Test(priority = 3)
    @Description("Registration test case")
    @Epic("EPIC-001")
    @Feature("Feature-003")
    @Step("Verify Registration")
    public void forgotPassword(){
        throw new SkipException("Skipped the test");
    }

    @AfterClass
    public void tearDown(){
        if(driver!=null)
            driver.quit();
    }
}
