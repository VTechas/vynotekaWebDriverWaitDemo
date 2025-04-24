import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class vynoteka {
    public static WebDriver driver;
    public static WebDriverWait wait;

    public void acceptCookies() {
        WebElement acceptBtn = driver.findElement(By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll"));
        acceptBtn.click();
    }


    public void closeAd() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        try {
            WebElement closeButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"omnisend-form-63ff1f31b40d6530aba59a6d-form-close-icon\"]\n")));
            wait.until(ExpectedConditions.elementToBeClickable(closeButton)).click();
        } catch (Exception e) {
        }
    }

    public void ageConfirm() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn.primary.full-w"))).click();
    }

    public void productSearch() {
        WebElement searchInput = wait.until(ExpectedConditions.elementToBeClickable(By.className("form-control")));
        searchInput.sendKeys("Alus");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".btn.primary.full-w.text-uppercase.text-uppercase"))).click();

    }

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://vynoteka.lt/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        acceptCookies();
        ageConfirm();
        closeAd();
        productSearch();
    }

    @BeforeMethod
    public void beforeMethod() {
    }

    @Test
    public void test1() {

    }
}