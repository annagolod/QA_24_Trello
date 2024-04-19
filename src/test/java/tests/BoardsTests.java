package tests;

import dataproviders.DataProviderBoard;
import helpers.RetryAnalyzer;
import manager.TestNGListener;
import models.BoardDTO;
import org.openqa.selenium.TimeoutException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.Random;

@Listeners(TestNGListener.class)

public class BoardsTests extends TestBase {

//    @BeforeClass(alwaysRun = true)
//    public void loginWithData(){
//        app.getHelperUser().login(user.getEmail(), user.getPassword());
//    }

    @Test(dataProvider = "DP_createNewBoardPositiveTest", dataProviderClass = DataProviderBoard.class)
    public void createNewBoardPositiveTest(Method method, BoardDTO boardDTO) {
//        int i = new Random().nextInt(1000);
//        BoardDTO boardDTO = BoardDTO.builder()
//                .boardTitle("qa24_" + i)
//                .build();
        //String boardTitle = "qa24_" + i;
        logger.info("start test " + method.getName() + " board title--> " + boardDTO.getBoardTitle());
        app.getHelperBoards().createNewBoard(boardDTO);
        Assert.assertTrue(app.getHelperBoards().isTextInElementEquals_boardTitle(boardDTO.getBoardTitle()));

    }

    @Test(expectedExceptions = TimeoutException.class)
    public void createNewBoardNegativeTest_EmptyBoardTitle() {
        BoardDTO boardDTO = BoardDTO.builder()
                .boardTitle("  ")
                .build();
        app.getHelperBoards().createNewBoard(boardDTO);
        Assert.assertTrue(app.getHelperBoards().isElementPresent_inputBoardTitle());

    }

    @Test(groups = {"smoke"})//(retryAnalyzer = RetryAnalyzer.class)
    public void deleteBoardPositiveTest(Method method) {
        int i = new Random().nextInt(1000);
        BoardDTO boardDTO = BoardDTO.builder()
                .boardTitle("qa24_" + i)
                .build();
        logger.info("start test " + method.getName() + " board title--> " + boardDTO.getBoardTitle());
        app.getHelperBoards().createNewBoard(boardDTO);
        app.getHelperBoards().pause(5);
        app.getHelperBoards().clickBtnBoard();
        //app.getHelperBoards().pause(5);
        app.getHelperBoards().deleteBoard(boardDTO);
        Assert.assertTrue(app.getHelperBoards().textToBePresentInElement_BoardDeleted("Board deleted.", 5));

    }

    @AfterMethod(alwaysRun = true)
    public void afterTest() {
        if (app.getHelperBoards().isElementPresent_boardTitle())
            app.getHelperBoards().clickBtnBoard();
        if (app.getHelperBoards().isElementPresent_inputBoardTitle())
            app.getHelperBoards().clickBtnCloseCreateForm();
    }

}
