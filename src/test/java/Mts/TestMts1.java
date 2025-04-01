package Mts;

import io.qameta.allure.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import java.io.ByteArrayInputStream;
import java.time.Duration;

@Epic("Тесты оплаты на сайте МТС")
@Feature("Проверка формы оплаты")
public class TestMts1 extends PegeMts {

    @Test
    @Story("Проверка полей формы")
    @Description("Тест проверяет корректность отображения полей 'Номер телефона' и 'Сумма'")
    @Severity(SeverityLevel.BLOCKER)
    public void testFieldCheck() {
        try {
           // driver.get(url);
           // close();

            Allure.step("Проверка поля 'Номер телефона'", () -> {
                String phoneLabel = driver.findElement(By.xpath(phoneNumber)).getText();
                Allure.addAttachment("Поле 'Номер телефона'",
                        phoneLabel.contains("Номер телефона") ? "Поле отображается корректно" : "Ошибка в отображении поля");
                assert phoneLabel.contains("Номер телефона") : "Неверная надпись поля 'Номер телефона'";
            });

            Allure.step("Проверка поля 'Сумма'", () -> {
                String sumLabel = driver.findElement(By.xpath(summa)).getText();
                Allure.addAttachment("Поле 'Сумма'",
                        sumLabel.contains("Сумма") ? "Поле отображается корректно" : "Ошибка в отображении поля");
                assert sumLabel.contains("Сумма") : "Неверная надпись поля 'Сумма'";
            });

        } catch (Exception e) {
            Allure.addAttachment("Ошибка", new ByteArrayInputStream(
                    ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)));
            throw e;
        }
    }

    @Test
    @Story("Проверка процесса оплаты")
    @Description("Тест проверяет заполнение формы и отображение всплывающего окна")
    @Severity(SeverityLevel.CRITICAL)
    public void testPaymentProcess() {
        try {
            driver.get(url);
            close();

            Allure.step("Заполнение номера телефона", () -> {
                WebElement phone = driver.findElement(By.xpath(phoneNumber));
                phone.click();
                phone.sendKeys(number);
            });

            Allure.step("Заполнение суммы", () -> {
                WebElement sum = driver.findElement(By.xpath(summa));
                sum.click();
                sum.sendKeys(prise);
            });

            Allure.step("Нажатие кнопки 'Продолжить'", () -> {
                driver.findElement(By.xpath(continueButton)).click();
            });

            Allure.step("Проверка всплывающего окна", () -> {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("/html/body/app-root/div/div")));

                WebElement amount = popup.findElement(By.xpath(summaRec));
                Allure.addAttachment("Проверка суммы",
                        amount.isDisplayed() ? "Сумма отображается корректно" : "Ошибка отображения суммы");
                assert amount.isDisplayed() : "Сумма не отображается во всплывающем окне";

                // Добавьте другие проверки для всплывающего окна
            });

        } catch (Exception e) {
            Allure.addAttachment("Ошибка", new ByteArrayInputStream(
                    ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)));
            throw e;
        }
    }
    @AfterMethod
    public void afterTest(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            Allure.addAttachment("Скриншот при ошибке",
                    new ByteArrayInputStream(
                            ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)));
        }
    }



    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}