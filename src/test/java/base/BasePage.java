package base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class BasePage {
    protected WebDriver driver;


    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    //Finds and returns a WebElement using the provided locator.
    public WebElement find(By locator){
        return driver.findElement(locator);
    }

    //Retrieves the current page URL.
    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    //Clicks on a WebElement using the provided locator.
    public  void clickToWebElement (By locator){
        find(locator).click();
    }
    //Inputs the given text into a text field located by the provided locator.
    public void inputTextMethod(String input,By locator) {
        find(locator).sendKeys(input);
    }


    // Retrieves the text from a WebElement.
    //If the text is longer than 28 characters, trims the last 28 characters.
    // This is used to match product names in the cart.
    public String getTextMethod(By locator) {
        String text = find(locator).getText();
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
