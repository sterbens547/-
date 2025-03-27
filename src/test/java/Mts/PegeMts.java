package Mts;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PegeMts {
    public WebDriver driver;
    public WebDriverWait wait;
    public String url = "https://www.mts.by/";
    public String payLink = "//*[@id='pay-section']/div/div/div[2]/section/div/div[1]/div[1]/div[2]/button";
    public String mobileServices = "//*[@id='pay-section']/div/div/div[2]/section/div/div[1]/div[1]/div[2]/ul/li[1]/p";
    public String phoneNumber = "//*[@id='connection-phone']";
    public String summa = "//*[@id='connection-sum']";
    public String summaRec = "/html/body/app-root/div/div/div/app-payment-container/section/div/div/div[1]/div[1]/span";
    public String buttonSum = "/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/button";
    public String phoneRec = "/html/body/app-root/div/div/div/app-payment-container/section/div/div/div[1]/div[1]/span";
    public String continueButton = "//*[@id='pay-connection']/button";
    public String number = "297777777";
    public String prise = "10";
    public String visa ="/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[2]/div/div/img[1]";
    public String master = "/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[2]/div/div/img[2]";
    public String bel = "/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[2]/div/div/img[3]";
    public String mir = "/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[2]/div/div/div/img[2]";
    public String card = "/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[1]/app-input/div/div/div[1]";
    public String date = "/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[2]/div[1]/app-input/div/div/div[1]/input";
    public String cvc = "/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[2]/div[3]/app-input/div/div/div[1]";
    public String nameCard = "/html/body/app-root/div/div/div/app-payment-container/section/div/app-card-page/div/div[1]/app-card-input/form/div[1]/div[3]/app-input/div/div/div[1]/input";


    @BeforeEach
    public void setUp () {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().window().maximize();
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
