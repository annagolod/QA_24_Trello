import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Selectors {
WebDriver driver;
    @Test
    public void startTrello(){
driver = new ChromeDriver();
driver.get("https://trello.com");
    }
}
