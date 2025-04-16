package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utilities.ConfigReader;
import utilities.Driver;


import java.time.Duration;

public class BaseTest {

    protected String baseUrl="https://www.amazon.com.tr/";
    protected String amazon_title="Amazon.com.tr: Elektronik, bilgisayar, akıllı telefon, kitap, oyuncak, yapı market, ev, mutfak, oyun konsolları ürünleri ve daha fazlası için internet alışveriş sitesi";

    @Before
    public void setUp(){
        Driver.getDriver().get(ConfigReader.getProperty("urlAmazon"));
    }

    @After
    public void tearDown(){
        Driver.quitDriver();
    }

}
