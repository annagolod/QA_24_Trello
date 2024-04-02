package manager;

import models.BoardDTO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperBoards extends HelperBase {

    public HelperBoards(WebDriver driver) {
        super(driver);
    }

    By btnCreateNewBoard = By.cssSelector("li[data-testid='create-board-tile']");
    By inputBoardTitle = By.cssSelector("input[data-testid='create-board-title-input']");
    By btnCreateSubmit = By.cssSelector("button[data-testid='create-board-submit-button']");
    By boardTitle = By.cssSelector("h1[data-testid='board-name-display']");
    By btnBoards = By.cssSelector("a[data-testid='open-boards-link']");
    By btnCloseCreateBoardForm = By.cssSelector("button[data-testid='popover-close']");
    //===============================
    By btnDots = By.cssSelector("button[aria-label='Меню']");
    By btnCloseBoard = By.cssSelector("a[class='board-menu-navigation-item-link board-menu-navigation-item-link-v2 js-close-board']");
    By btnCloseSubmit = By.cssSelector("input[value='Закрыть']");
    By btnDeleteBoard = By.cssSelector("button[data-testid='close-board-delete-board-button']");
    By btnDeleteConfirm = By.cssSelector("button[data-testid='close-board-delete-board-confirm-button']");

    public void createNewBoard(BoardDTO boardDTO) {
        clickBase(btnCreateNewBoard);
        typeBase(inputBoardTitle, boardDTO.getBoardTitle());
        clickBase(btnCreateSubmit);
    }

    public boolean isTextInElementEquals_boardTitle(String text) {
    return isTextInElementEquals(boardTitle, text);
    }

    public void clickBtnBoard(){
        clickBase(btnBoards);
    }

    public void clickBtnCloseCreateForm(){
        clickBase(btnCloseCreateBoardForm);
    }
    public boolean isElementPresent_inputBoardTitle(){
        return isElementPresent(inputBoardTitle);
    }

    public boolean isElementPresent_boardTitle() {
        return isElementPresent(boardTitle);
    }

    public void deleteBoard(BoardDTO boardDTO){
        clickBoardTitle(boardDTO.getBoardTitle());
        clickBase(btnDots);
        clickBase(btnCloseBoard);
        clickBase(btnCloseSubmit);
        clickBase(btnDeleteBoard);
        clickBase(btnDeleteConfirm);
    }

    private void clickBoardTitle(String boardTitle) {
        String xPathBoardTitle = "//div[@title='" + boardTitle + "']";
        clickBase(By.xpath(xPathBoardTitle));
    }
}
