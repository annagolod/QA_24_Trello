package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HelperProfile extends HelperBase{
    public HelperProfile(WebDriver driver) {
        super(driver);
    }

    By btnAccount = By.xpath("//button[@data-testid='header-member-menu-button']");
    By btnManageAccount = By.xpath("//a[@data-testid='manage-account-link']");
    By btnProfilePhoto = By.xpath("//div[@data-test-selector='profile-hover-info']");
    //By btnAddProfilePhoto = By.xpath("//span[text() = 'Добавить фото профиля']");
    By btnAddProfilePhoto = By.xpath("//span[text() = 'Add profile photo']");
    By btnChangeProfilePhoto = By.xpath("//button[@data-testid='change-avatar']");
    By btnUpLoadPhoto = By.xpath("//input[@id='image-input']");
    By btnUpLoad = By.xpath("//button[@type = 'submit']");
    By popUpAvatarAdded_Removed = By.xpath("//span[@class='css-oxh4dz']");
    By imgWithText = By.xpath("//img[@id='drag-zone-image']");
    By btnCancelAddChangeProfilePhoto = By.xpath("//span[text() = 'Cancel']");
    By btnRemoveAvatarPhoto = By.xpath("//button[@data-testid = 'remove-avatar']");

    public void changeAvatar(String filePath){
        clickBaseWait(btnAccount, 3);
        clickBaseWait(btnManageAccount,3);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        for(String s: tabs){
            System.out.println("-->" + s);
        }
        driver.switchTo().window(tabs.get(1));
        clickBase(btnProfilePhoto);
        clickBase(btnChangeProfilePhoto);

        File file = new File(filePath);
        String path = file.getAbsolutePath();
        WebElement element = driver.findElement(btnUpLoadPhoto);
        element.sendKeys(path);
        clickBaseWait(btnUpLoad, 5);
    }

    public void addAvatarPhoto(String filePath){
        clickBaseWait(btnAccount, 3);
        clickBaseWait(btnManageAccount,3);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        for(String s: tabs){
            System.out.println("-->" + s);
        }
        driver.switchTo().window(tabs.get(1));
        clickBase(btnProfilePhoto);
        clickBase(btnAddProfilePhoto);

        File file = new File(filePath);
        String path = file.getAbsolutePath();
        WebElement element = driver.findElement(btnUpLoadPhoto);
        element.sendKeys(path);
        clickBaseWait(btnUpLoad, 5);
    }

    public boolean isElementPresent_popUpAvatarAdded(int time){
        return  textToBePresentInElement(popUpAvatarAdded_Removed, "Avatar added", time);
    }

    public boolean isElementPresent_popUpAvatarRemoved(int time){
        return  textToBePresentInElement(popUpAvatarAdded_Removed, "Avatar removed", time);
    }

    public boolean isTextToBePresentInAttribute_format_invalid(String attribute, String text, int time){
        return textToBePresentInAttribute(imgWithText,attribute,text,time);
    }

    public void clickCancel() {
        clickBaseWait(btnCancelAddChangeProfilePhoto, 5);
    }
}
