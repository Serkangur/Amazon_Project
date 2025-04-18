package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {
    //Webdriver yönetmek ve tarayıcıları yapılandırmak için kullanılır.
    public static WebDriver driver;


    private Driver() {
    }

    public static WebDriver getDriver() {
        //Yönetilen webdriver nesnesini döndüren bir method tanımlar

        if (driver == null) {
            try {
                String browser = ConfigReader.getProperty("browser");
                System.out.println("Browser: " + browser);

                switch (browser.toLowerCase().trim()) {
                    case "firefox":
                        WebDriverManager.firefoxdriver().setup();
                        driver = new FirefoxDriver();
                        break;
                    case "safari":
                        WebDriverManager.safaridriver().setup();
                        driver = new SafariDriver();
                        break;
                    case "edge":
                        WebDriverManager.edgedriver().setup();
                        driver = new EdgeDriver();
                        break;
                    default:
                        System.out.println("Chrome başlatılıyor...");
                        WebDriverManager.chromedriver().clearDriverCache().setup();
                        ChromeOptions options = new ChromeOptions();
                        options.addArguments("--remote-allow-origins=*");
                        options.addArguments("--disable-notifications");
                        driver = new ChromeDriver(options);
                }

                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
                System.out.println("Driver başarıyla başlatıldı!");
            } catch (Exception e) {
                System.out.println("Driver başlatılırken hata oluştu: " + e.getMessage());
                e.printStackTrace();
            }
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.close(); // WEbDriver kaptır ve sıfırlar
            driver = null;
        }
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit(); // Tüm pencereleri sıfırlar
            driver = null;
        }
    }
}