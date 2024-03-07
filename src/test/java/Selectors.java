import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Selectors {
WebDriver driver;
    @Test
    public void startTrello(){
driver = new ChromeDriver();
driver.get("https://trello.com");
WebElement btnLogin = driver.findElement(By.xpath("//a[@data-uuid='MJFtCCgVhXrVl7v9HA7EH_login']"));
System.out.println("--> " + btnLogin.getText());

WebElement getTrelloForFree = driver.findElement(By.xpath("//*[text()='Get Trello for free']"));
System.out.println("--> " + getTrelloForFree.getAttribute("href"));

WebElement btnSignUp = driver.findElement(By.xpath("//form[@data-testid='ui-email-signup-form']/div/button"));
System.out.println("--> " + btnSignUp.getAttribute("aria-label"));




        driver.quit();
    }
}
