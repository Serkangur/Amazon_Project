package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    // Singleton Driver ile kurucu method
    public BasePage() {
        this.driver = Driver.getDriver(); // Singleton driver çağrısı
        PageFactory.initElements(driver, this); // Elementleri initialize et
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Dinamik bekleme
    }

    // Eğer ekstra esneklik gerekiyorsa bu versiyonu da tutabilirsin:
    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }


    public WebElement find(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    public void clickToWebElement(By locator){
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    public void inputTextMethod(String input,By locator){
        WebElement element= find(locator);
        element.clear();
        element.sendKeys(input);
    }

    public WebElement waitElement(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public String getTextMethod(By locator) {
        String text = waitElement(locator).getText();
        if (text.length() > 28) {
            text = text.substring(0, text.length() - 28);
        }
        return text;
    }


    //Pauses execution for the specified time.
    public static void delay(int millisecond){
        try {
            Thread.sleep(millisecond);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
