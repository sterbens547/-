package Mts;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MtsPaymentPage {
    public  WebDriver driver;
    public  WebDriverWait wait;

   //оплатить
    @FindBy(xpath = "//*[@id='pay-section']/div/div/div[2]/section/div/div[1]/div[1]/div[2]/button")
    public WebElement payLink;
    // услуги связи
    @FindBy(xpath = "//*[@id='pay-section']/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[1]/p")
   public WebElement mobileServicesButton;
    //номер телефонв
    @FindBy(xpath = "//*[@id='pay-section']/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[2]/p")
    public WebElement phoneInput;
    //сумма
    @FindBy(xpath = "//*[@id='connection-sum']")
    public WebElement amountInput;
    //кнопка продолжить
    @FindBy(xpath = "//*[@id='pay-connection']/button")
    public WebElement continueButton;
    // итоговая сумма
    @FindBy(xpath = "/html/body/app-root/div/div/div/app-payment-container/section/div/div/div[1]/div[1]/span")
    public WebElement confirmationAmount;
    // номер
    @FindBy(xpath = "/html/body/app-root/div/div/div/app-payment-container/section/div/div/div[2]/span")
   public WebElement confirmationPhone;
    //кнопка оплаты
    @FindBy(xpath = "//button[contains(@class,'pay-button')]")
    public WebElement payButton;

    public MtsPaymentPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
        close();
    }

    public void openPaymentPage() {
        payLink.click();
        wait.until(ExpectedConditions.visibilityOf(mobileServicesButton));
    }


    public void selectMobileServices() {
        mobileServicesButton.click();
        wait.until(ExpectedConditions.visibilityOf(phoneInput));
    }

    public void enterPhoneNumber(String phone) {
        phoneInput.clear();
        phoneInput.sendKeys(phone);
    }


    public void enterAmount(String amount) {
        amountInput.clear();
        amountInput.sendKeys(amount);
    }


    public void clickContinue() {
        continueButton.click();
        wait.until(ExpectedConditions.visibilityOf(confirmationAmount));
    }


    public void checkDisplayedAmount(String expectedAmount) {
        String actualText = confirmationAmount.getText();
        assert actualText.contains(expectedAmount) :
                "Неверная сумма платежа. Ожидалось: " + expectedAmount + ", получено: " + actualText;
    }


    public void checkDisplayedPhone(String expectedPhone) {
        String actualPhone = confirmationPhone.getText();
        assert actualPhone.equals(expectedPhone) :
                "Неверный номер телефона. Ожидалось: " + expectedPhone + ", получено: " + actualPhone;
    }


    public void checkPayButtonAmount(String expectedAmount) {
        String buttonText = payButton.getText();
        assert buttonText.contains(expectedAmount) :
                "Сумма не совпадает.Ожидалось: " + expectedAmount + ", получено: " + buttonText;
    }


    public void checkCardFieldsLabels(String[] expectedLabels) {
        List<WebElement> labels = driver.findElements(
                By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]")
        );

        for (int i = 0; i < expectedLabels.length; i++) {
            String actualLabel = labels.get(i).getText();
            assert actualLabel.equals(expectedLabels[i]) :
                    "Неверная надпись поля. Ожидалось: " + expectedLabels[i] + ", получено: " + actualLabel;
        }
    }

    public void checkPaymentSystemIcons() {
        List<WebElement> icons = driver.findElements(
                By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[2]/div/div")
        );
        assert !icons.isEmpty() : "Иконки систем не найдены";
    }


    public void checkEmptyFieldsLabels(String optionName, String[] expectedLabels) {
        driver.findElement(By.xpath(String.format("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]", optionName))).click();

        List<WebElement> labels = driver.findElements(
                By.xpath("/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[1]")
        );

        for (int i = 0; i < expectedLabels.length; i++) {
            String actualLabel = labels.get(i).getText();
            assert actualLabel.equals(expectedLabels[i]) : String.format(
                    "Неверная надпись для поля в разделе '%s'. Ожидалось: '%s', получено: '%s'",
                    optionName, expectedLabels[i], actualLabel
            );
        }
    }
    public void close() {
        try {
            WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[6]/main/div/div[2]/div/div[2]/button[2]")));
            closeButton.click();
        } catch (Exception e) {
            System.out.println("окна нет");
        }
    }
}