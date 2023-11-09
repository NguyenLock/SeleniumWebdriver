    package TC;
    import org.openqa.selenium.By;

    import org.openqa.selenium.OutputType;
    import org.openqa.selenium.TakesScreenshot;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.io.FileHandler;
    import org.testng.annotations.Test;
    import driver.driverFactory;

    import java.io.File;
    import java.io.IOException;

    public class TestCase10_Test {
        @Test
        public void Main() throws IOException {
            int scc = 0;
            WebDriver driver = driverFactory.getChromeDriver();
            TestCase10_Page page = new TestCase10_Page(driver);

            // Step 1: Go to backend login page
            driver.get("http://live.techpanda.org/index.php/backendlogin");

            // Step 2: Login with provided credentials
            page.login("user01", "guru99com");

            // Step 3: Navigate to Sales -> Orders menu
            page.closeMsgBox();
            page.goToOrders();

            // Step 4: Input OrderId and FromDate -> ToDate
            String orderId = "123"; // Replace with the actual Order ID
            String fromDate = "11/8/2023"; // Replace with the actual From Date
            String toDate = "12/10/2023"; // Replace with the actual To Date
            page.exportOrdersToCSV(orderId, fromDate, toDate);

            //step 5
            driver.findElement(By.id("id_f441c07d944c839121ad774f50c118f4")).click();

            //step 6
            scc = (scc+10);
            TakesScreenshot screenshot =((TakesScreenshot)driver);
            File srcFile= screenshot.getScreenshotAs(OutputType.FILE);
            String png =("C:\\Users\\ADMIN\\Desktop\\SWT\\selenium-webdriver-java-master\\src\\test\\java\\testcase\\" + scc +".png");
            FileHandler.copy(srcFile, new File(png));

            driver.quit();
        }
    }