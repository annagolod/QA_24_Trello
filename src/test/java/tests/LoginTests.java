package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends  TestBase {

    @Test
    public void loginPositiveTest(){
        String email = "tretam0810@gmail.com";
        String password = "Trello54321#";
        app.getHelperUser().login(email, password);
        Assert.assertTrue(app.getHelperUser().isElementPresent_btnAccount());
    }


}
