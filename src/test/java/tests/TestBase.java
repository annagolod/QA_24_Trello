package tests;

import manager.ApplicationManager;
import models.UserDTO;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

    static ApplicationManager app = new ApplicationManager();
    UserDTO user = new UserDTO("tretam0810@gmail.com","Trello54321#");

    @BeforeSuite
    public void setUp(){
        app.init();
    }

    @AfterSuite
    public void tearDown(){
        //app.stop();
    }

}
