package tests;

import models.BoardDTO;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.Random;

public class BoardsTests extends TestBase{

    @BeforeClass
    public void loginWithData(){
        app.getHelperUser().login(user.getEmail(), user.getPassword());
    }

    @Test
    public void createNewBoardPositiveTest(Method method){
        int i = new Random().nextInt(1000);
        BoardDTO boardDTO = BoardDTO.builder()
                .boardTitle("qa24_" + i)
                .build();
        //String boardTitle = "qa24_" + i;
        logger.info("start test " + method.getName() + " board title--> " + boardDTO.getBoardTitle());
        app.getHelperBoards().createNewBoard(boardDTO);
        Assert.assertTrue(app.getHelperBoards().isTextInElementEquals_boardTitle(boardDTO.getBoardTitle()));
    }
    @Test
    public void createNewBoardNegativeTest_EmptyBoardTitle(){
        BoardDTO boardDTO = BoardDTO.builder()
                .boardTitle("  ")
                .build();
        app.getHelperBoards().createNewBoard(boardDTO);
        Assert.assertTrue(app.getHelperBoards().isElementPresent_inputBoardTitle());
    }
    @Test
    public void deleteBoardPositiveTest(Method method){
        int i = new Random().nextInt(1000);
        BoardDTO boardDTO = BoardDTO.builder()
                .boardTitle("qa24_" + i)
                .build();
        logger.info("start test " + method.getName() + " board title--> " + boardDTO.getBoardTitle());
        app.getHelperBoards().createNewBoard(boardDTO);
        app.getHelperBoards().clickBtnBoard();
        app.getHelperBoards().deleteBoard(boardDTO);

    }

@AfterMethod
    public void afterTest(){
       if(app.getHelperBoards().isElementPresent_boardTitle())
           app.getHelperBoards().clickBtnBoard();
       if(app.getHelperBoards().isElementPresent_inputBoardTitle())
           app.getHelperBoards().clickBtnCloseCreateForm();
}

}
