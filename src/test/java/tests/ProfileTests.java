package tests;

import manager.TestNGListener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestNGListener.class)

public class ProfileTests extends TestBase{

    @BeforeClass
    public void loginWithData(){
        app.getHelperUser().login(user.getEmail(), user.getPassword());
    }

    @Test
    public void changeAvatarPositiveTest(){
        app.getHelperProfile().changeAvatar();
    }

}
