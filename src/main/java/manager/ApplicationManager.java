package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.Path;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

    //WebDriver driver;
    EventFiringWebDriver driver;
    HelperUser helperUser;
    HelperBoards helperBoards;
    HelperProfile helperProfile;
    static String browser;
    public ApplicationManager(){
        browser = System.getProperty("browser", BrowserType.CHROME);
    }

    public void init() {
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--lang=en");
//        driver = new EventFiringWebDriver(new ChromeDriver());
        if(browser.equals(BrowserType.FIREFOX)){
            System.setProperty("webdriver.firefox.bin", "/Applications/Firefox.app/Contents/MacOS/firefox");
            driver = new EventFiringWebDriver(new FirefoxDriver());
            logger.info("testing starts on Firefox");
        }else{
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--lang=en");
            driver = new EventFiringWebDriver(new ChromeDriver());
        }
        driver.navigate().to(PropertiesReader.getProperty("url"));
        logger.info("Start testing--navigate to --> https://trello.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        helperUser = new HelperUser(driver);
        helperBoards = new HelperBoards(driver);
        driver.register(new WDListener());
        helperProfile = new HelperProfile(driver);
    }


    public void stop() {
        logger.info("Stop testing -- navigate to --> https://trello.com");
        driver.quit();
    }

    public HelperUser getHelperUser() {
        return helperUser;
    }

    public HelperBoards getHelperBoards() {
        return helperBoards;
    }

    public HelperProfile getHelperProfile() {
        return helperProfile;
    }
}



