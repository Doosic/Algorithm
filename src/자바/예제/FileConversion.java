package 예제;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FileConversion {

    public void fileConversion(){
        findExampleFiles("asd");
    }

    public void findExampleFiles(String fileName) {
        try{
            FileInputStream inputStream = new FileInputStream(fileName);
        }catch (FileNotFoundException e){

        }

    }

}
