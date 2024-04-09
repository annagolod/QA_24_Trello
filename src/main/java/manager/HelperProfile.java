package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperProfile extends HelperBase{
    public HelperProfile(WebDriver driver) {
        super(driver);
    }

    By btnAccount = By.xpath("//button[@data-testid='header-member-menu-button']");
    By btnManageAccount = By.xpath("//a[@data-testid='manage-account-link']");

    public void changeAvatar(){
        clickBaseWait(btnAccount, 3);
        clickBaseWait(btnManageAccount,3);

    }
}
