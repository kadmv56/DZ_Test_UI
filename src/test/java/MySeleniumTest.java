import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class MySeleniumTest {
    @Test
    @DisplayName("Проверка отображения поля с заполненными данными из формы.")
    public void getFormText() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/text-box");
        WebElement fullName = driver.findElement(By.id("userName"));
        WebElement email = driver.findElement(By.id("userEmail"));
        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        WebElement permanentAddress = driver.findElement(By.id("permanentAddress"));
        WebElement button = driver.findElement(By.id("submit"));

        fullName.sendKeys("Ivanov Ivan Ivanovich");
        email.sendKeys("fdghj@mail.ru");
        currentAddress.sendKeys("Orenburg, ul. Komsomol`skaj");
        permanentAddress.sendKeys("Orenburg, ul. Komsomol`skaj");

        button.click();
        WebElement outputBox = driver.findElement(By.id("output"));
        boolean isShowOutput = outputBox.isDisplayed();

        Assertions.assertTrue(isShowOutput);
        Thread.sleep(5000);
        driver.quit();
    }
}
