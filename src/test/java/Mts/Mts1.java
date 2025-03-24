package Mts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Mts1{

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        // путь к драйверу
       WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Открытие сайта
        driver.get("http://mts.by");
        driver.manage().window().maximize();
        close();

    }

    private void close() {
        try {
            WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[6]/main/div/div[2]/div/div[2]/button[2]")));
            closeButton.click();
        } catch (Exception e) {
            System.out.println("окна нет");
        }
    }

    @Test
    public void testBlockTitle() {
     WebElement text = wait.until(ExpectedConditions.visibilityOfElementLocated(
             By.xpath( "//h2[normalize-space(.)='Онлайн пополнение без комиссии']")));
        String expectedText = "Онлайн пополнение без комиссии";
        String actualText = text.getText()
                .replaceAll("\n", " ")
                .replaceAll("\\s+", " ")
                .trim();

        assertEquals(expectedText, actualText, "Текстне совпадает");

        // Проверка 2: Наличие <br> в структуре
       // String innerHTML = text.getAttribute("innerHTML");
       // assertTrue(innerHTML.contains("<br>"), "Отсутствует тег переноса строки");
    }

    @Test
    public void testElementVisa() {
        // наличия логотипов платёжных
        List<WebElement> logos = driver.findElements(By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/div[2]/ul/li[1]/img"));
        assertFalse(logos.isEmpty(), "Логотипы платёжных систем отсутствуют");
    }

    @Test
    public void testElementVisa2() {
        // наличия логотипов платёжных
        List<WebElement> logos = driver.findElements(By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/div[2]/ul/li[2]/img"));
        assertFalse(logos.isEmpty(), "Логотипы платёжных систем отсутствуют");

    }
    @Test
    public void testElementMaster() {
        // наличия логотипов платёжных
        List<WebElement> logos = driver.findElements(By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/div[2]/ul/li[3]/img"));
        assertFalse(logos.isEmpty(), "Логотипы платёжных систем отсутствуют");

    }
    @Test
    public void testElementMaster2() {
        // наличия логотипов платёжных
        List<WebElement> logos = driver.findElements(By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/div[2]/ul/li[4]/img"));
        assertFalse(logos.isEmpty(), "Логотипы платёжных систем отсутствуют");

    }
    @Test
    public void testElementBel() {
        // наличия логотипов платёжных
        List<WebElement> logos = driver.findElements(By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/div[2]/ul/li[5]/img"));
        assertFalse(logos.isEmpty(), "Логотипы платёжных систем отсутствуют");

    }

    @Test
    public void testDetailis() {
        // «Подробнее о сервисе»
        WebElement detailsLink = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/a")));
        detailsLink.click();

        wait.until(ExpectedConditions.urlContains("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/"));
        assertTrue(driver.getCurrentUrl().contains("https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/"));
        System.out.println("Переход : https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/");
    }

    @Test
    public void testContinue() {
        // Заполнение полей и проверка кнопки «Продолжить»
        WebElement car = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id='pay-section']/div/div/div[2]/section/div/div[1]/div[1]/div[2]/button/span[1]")));
        assertEquals("Услуги связи",car.getText());
        System.out.println("Услуги связи: " + car.getText());

        WebElement phoneInput = driver.findElement(By.xpath("//*[@id='connection-phone']"));
        phoneInput.sendKeys("297777777");

        WebElement sum =driver.findElement(By.xpath("//*[@id='connection-sum']"));
        sum.sendKeys("12");

        WebElement continueB = driver.findElement(By.xpath("//*[@id='pay-connection']/button"));
        assertEquals("Продолжить",continueB.getText());
        System.out.println("Продолжить: " + continueB.getText());
        continueB.click();


    }

    @AfterEach
    public void off() {
        // Закрытие браузера
        if (driver != null) {
            driver.quit();
        }
    }
}
