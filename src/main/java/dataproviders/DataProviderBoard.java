package dataproviders;

import models.BoardDTO;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class DataProviderBoard {
    @DataProvider
    public Iterator<Object[]> DP_createNewBoardPositiveTest(){
        List<Object[]> list = new ArrayList<>();
        int i = new Random().nextInt(1000);
        list.add(new Object[]{BoardDTO.builder().boardTitle("DP_QA24_" + i).build()});
//        list.add(new Object[]{BoardDTO.builder().boardTitle("DP_QA24_2").build()});
//        list.add(new Object[]{BoardDTO.builder().boardTitle("DP_QA24_3").build()});
        return list.iterator();

    }

    @DataProvider
    public Iterator<Object[]> DPFile_createNewBoardPositiveTest() {
        List<Object[]> list = new ArrayList<>();
        String path = "src/test/resources/Board_titles.csv";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(path)));
            String line = reader.readLine();
            while(line != null){
                String[] splitArray = line.split(",");
                list.add(new BoardDTO[]{BoardDTO.builder().boardTitle(splitArray[0]).build()});
                line = reader.readLine();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return list.iterator();
    }

}
