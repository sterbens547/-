package mts1;

import Mts.MtsPaymentPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.bouncycastle.asn1.x500.style.RFC4519Style.c;

public class MtsPaymentTests {
    private WebDriver driver;
    private MtsPaymentPage paymentPage;
    private final String PHONE_NUMBER = "297777777";
    private final String PAYMENT_AMOUNT = "10";
    public WebDriverWait wait;

    @BeforeClass
    public void setup() {
        // Настройка драйвера
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Инициализация страницы
        driver.get("https://www.mts.by");
        paymentPage = new MtsPaymentPage(driver);


    }


    @Test
    public void testEmptyFieldsLabels() {
        paymentPage.openPaymentPage();
       close();

        // Проверка для каждого варианта оплаты
        paymentPage.checkEmptyFieldsLabels("Услуги связи", new String[]{"Номер телефона", "Сумма"});
        paymentPage.checkEmptyFieldsLabels("Домашний интернет", new String[]{"Лицевой счёт", "Сумма"});
        paymentPage.checkEmptyFieldsLabels("Рассрочка", new String[]{"Номер договора", "Сумма"});
        paymentPage.checkEmptyFieldsLabels("Задолженность", new String[]{"Номер телефона", "Сумма"});
    }


    @Test
    public void testMobilePaymentProcess() {
        paymentPage.openPaymentPage();
        close();
        paymentPage.selectMobileServices();

        // Заполнение формы
        paymentPage.enterPhoneNumber(PHONE_NUMBER);
        paymentPage.enterAmount(PAYMENT_AMOUNT);
        paymentPage.clickContinue();

        // Проверка данных в окне подтверждения
        paymentPage.checkDisplayedAmount(PAYMENT_AMOUNT);
        paymentPage.checkDisplayedPhone(PHONE_NUMBER);
        paymentPage.checkPayButtonAmount(PAYMENT_AMOUNT);

        // Проверка полей для карты
        paymentPage.checkCardFieldsLabels(new String[]{
                "Номер карты", "Срок действия", "Имя владельца", "CVC/CVV"
        });

        // Проверка иконок платежных систем
        paymentPage.checkPaymentSystemIcons();
    }
    public void close() {
        try {
            WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[6]/main/div/div[2]/div/div[2]/button[2]")));
            closeButton.click();
        } catch (Exception e) {
            System.out.println("окна нет");
        }
    }


            @AfterClass
            public void tearDown () {
                if (driver != null) {
                    driver.quit();
                }
            }
        }