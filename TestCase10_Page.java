package TC;

        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.support.ui.ExpectedConditions;
        import org.openqa.selenium.support.ui.Select;
        import org.openqa.selenium.support.ui.WebDriverWait;

        import java.time.Duration;

public class TestCase10_Page {
    private WebDriver driver;
    private WebDriverWait wait;

    public TestCase10_Page(WebDriver driver) {
        this.driver = driver;
    }

    private final By Username = By.id("username");
    private final By Password = By.id("login");
    private final By SubmitBtn = By.cssSelector("input[type='submit']");
    private final By CloseBtn = By.cssSelector("a[title='close'] span");
    private final By NavBar = By.id("nav");
    private final By DBSales = By.linkText("Sales");
    private final By Orders = By.linkText("Orders");
    private final By DBExport = By.id("sales_order_grid_export");
    private final By Export = By.cssSelector("button[title='Export']");



    public void login(String username, String password) {
        driver.findElement(Username).sendKeys(username);
        driver.findElement(Password).sendKeys(password);
        driver.findElement(SubmitBtn).click();
    }
    public void closeMsgBox(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(CloseBtn)).click();
    }
    public void goToOrders() {
        driver.findElement(NavBar).findElement(DBSales).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(Orders)).click();
    }
    public void exportOrdersToCSV(String orderId, String fromDate, String toDate) {
        WebElement exportDropdown = driver.findElement(DBExport);
        Select select = new Select(exportDropdown);
        select.selectByVisibleText("CSV");

        // Input Order ID
        WebElement orderInput = driver.findElement(By.id("sales_order_grid_filter_real_order_id"));
        orderInput.clear(); // Clear any existing value
        orderInput.sendKeys(orderId);

        // Input From Date
        WebElement fromDateInput = driver.findElement(By.id("sales_order_grid_filter_created_at1699504084.2437_from"));
        fromDateInput.clear(); // Clear any existing value
        fromDateInput.sendKeys(fromDate);

        // Input To Date
        WebElement toDateInput = driver.findElement(By.id("sales_order_grid_filter_created_at1699504084.2437_to"));
        toDateInput.clear(); // Clear any existing value
        toDateInput.sendKeys(toDate);

        // Click the button to perform the export
        driver.findElement(Export).click();
    }
}

