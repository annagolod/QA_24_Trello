package tests;

import manager.ApplicationManager;
import models.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {

    Logger logger = LoggerFactory.getLogger(TestBase.class);

    static ApplicationManager app = new ApplicationManager();
    UserDTO user = new UserDTO("tretam0810@gmail.com","Trello54321#");

    @BeforeSuite
    public void setUp(){
        logger.info("Login with email --> " + user.getEmail() + " password --> " + user.getPassword());
        app.init();
    }

    @AfterSuite
    public void tearDown(){
        app.stop();
    }

}
