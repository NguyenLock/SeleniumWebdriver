package TC;

import driver.driverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class TestCase4 {
    @Test
    public static void testcase4() throws IOException {
        int scc = 0;
        WebDriver driver = driverFactory.getChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("http://live.techpanda.org/");

        TestCase4_Page page = new TestCase4_Page(driver);

        page.clickOnMobileMenu();
        page.addToCompareSonyXperia();
        page.addToCompareIphone();
        page.clickOnCompareButton();


        String expectedHeading = "COMPARE PRODUCTS";
        String actualHeading = page.getPopupHeading();
        assert actualHeading.equals(expectedHeading) : "Popup heading does not match!";
        String x = page.getProductNames1();
        System.out.println(x);
        String y = page.getProductNames2();
        System.out.println(y);
        String z = page.getProductPrice1();
        System.out.println(z);
        String w = page.getProductPrice2();
        System.out.println(w);

        //take a picture
        scc = (scc + 4);
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String png = "C:\\Users\\ADMIN\\Desktop\\SWT\\selenium-webdriver-java-master\\src\\test\\java\\testcase\\" + scc + ".png";
        FileUtils.copyFile(srcFile, new File(png));
        driver.quit();
    }
}