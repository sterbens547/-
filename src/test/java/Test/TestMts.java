package Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.*;
import org.example.PegeMts;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Epic("Тесты оплаты на сайте МТС")
@Feature("Проверка формы оплаты")
public class TestMts extends PegeMts {

    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }


    @Test
    @Story("Проверка полей формы")
    @Description("Тест проверяет корректность отображения полей 'Номер телефона' и 'Сумма'")
    @Severity(SeverityLevel.BLOCKER)
    public void testFieldСheck() {
        driver.get(url);
        close();
        driver.findElement(By.xpath(payLink)).click();
        // driver.findElement(By.xpath(mobileServices)).click();
        String phoneLabel = driver.findElement(By.xpath(phoneNumber)).getText();
        String sumLabel = driver.findElement(By.xpath(summa)).getText();
        System.out.println("Проверка полей:");
        System.out.println(phoneLabel.contains("Номер телефона") ? "✓ Номер телефона" : "✗ Номер телефона");
        System.out.println(sumLabel.contains("Сумма") ? "✓ Сумма" : "✗ Сумма");
    }

    @Test
    @Story("Проверка процесса оплаты")
    @Description("Тест проверяет заполнение формы и отображение всплывающего окна")
    public void testContinur() {

        driver.get(url);
        close();
        WebElement phone = driver.findElement(By.xpath(phoneNumber));
        phone.click();
        phone.sendKeys(number);
        WebElement sum = driver.findElement(By.xpath(summa));
        sum.click();
        sum.sendKeys(prise);
        driver.findElement(By.xpath(continueButton)).click();
        WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("/html/body/app-root/div/div")));

        WebElement amount = popup.findElement(By.xpath(summaRec));
        System.out.println("Сумма корректна: " + amount.isDisplayed());


        WebElement phonen = popup.findElement(By.xpath(phoneRec));
        System.out.println("Номер корректный: " + phonen.isDisplayed());

        String[] cardFields = {"Номер карты", "Срок действия", "CVC", "Имя держателя"};
        for (String field : cardFields) {
            WebElement element = popup.findElement(By.xpath(card + field + date + field + cvc + field + nameCard));
            System.out.println("Поле '" + field + "' найдено: " + element.isDisplayed());
        }

        WebElement payButton = popup.findElement(By.xpath(buttonSum));
        System.out.println("Кнопка оплаты найдена: " + payButton.isDisplayed());


        WebElement visaLogo = popup.findElement(By.xpath(visa));
        System.out.println("Логотип VISA найден: " + visaLogo.isDisplayed());

        WebElement masterLogo = popup.findElement(By.xpath(master));
        System.out.println("Логотип VISA найден: " + masterLogo.isDisplayed());

        WebElement belLogo = popup.findElement(By.xpath(bel));
        System.out.println("Логотип VISA найден: " + belLogo.isDisplayed());

        WebElement mirLogo = popup.findElement(By.xpath(mir));
        System.out.println("Логотип VISA найден: " + mirLogo.isDisplayed());



    }



    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
