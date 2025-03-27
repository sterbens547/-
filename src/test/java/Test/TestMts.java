package Test;

import Mts.PegeMts;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestMts extends PegeMts {

    @Test
    public void testFieldСheck () {
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
    public void testContinur () {

        driver.get(url);
        close();
        WebElement phone = driver.findElement(By.xpath(phoneNumber));
        phone.click();
        phone.sendKeys(number);
        WebElement sum = driver.findElement(By.xpath(summa));
        sum.click();
        sum.sendKeys(prise);
        driver.findElement(By.xpath(continueButton)).click();
        WebElement popup = driver.findElement(By.xpath("/html/body/app-root/div/div"));
        String confirmPhone = popup.findElement(By.xpath(phoneRec)).getText();
        String confirmSum = popup.findElement(By.xpath(buttonSum)).getText();
        System.out.println(confirmPhone.equals("Оплата: Услуги связи" +
                "Номер:375297777777") ? "✓ Номер верный" : "✗ Номер неверный");
        System.out.println(confirmSum.contains(prise) ? "✓ Сумма верна" : "✗ Сумма неверна");

        System.out.println("Проверка подтверждения:");
        System.out.println(confirmPhone.equals("297777777") ? "✓ Номер верный" : "✗ Номер неверный");
        System.out.println(confirmSum.contains("10 руб.") ? "✓ Сумма верна" : "✗ Сумма неверна");

    }

    @AfterEach
    public void tearDown () {
        if (driver != null) {
            driver.quit();
        }
    }

}
