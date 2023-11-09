package TC;

import driver.driverFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class TestCase9_Test {
    @Test
    public void Main() throws IOException {
        int scc = 0;
        WebDriver driver = driverFactory.getChromeDriver();
        driver.get("http://live.techpanda.org/");

        TC.TestCase9_Page page = new TC.TestCase9_Page(driver);

        page.clickOnMobileMenu();
        page.addToCartIphone();
        page.enterCouponCode("GURU50");
        page.clickApplyCouponButton();


        Assert.assertEquals(page.DiscountedPrice(), page.Price() * 0.95);
        System.out.println("Price is discounted by 5%");
        scc = (scc+9);
        TakesScreenshot screenshot =((TakesScreenshot)driver);
        File srcFile= screenshot.getScreenshotAs(OutputType.FILE);
        String png =("C:\\Users\\ADMIN\\Desktop\\SWT\\selenium-webdriver-java-master\\src\\test\\java\\testcase\\" + scc +".png");
        FileHandler.copy(srcFile, new File(png));
        driver.quit();
    }
}