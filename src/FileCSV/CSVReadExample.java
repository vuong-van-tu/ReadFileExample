package FileCSV;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReadExample {
    private static final String COMMA_DELIMITER = ",";

    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            String line;
            br = new BufferedReader(new FileReader("D:\\java\\TaoMoi\\contries.csv"));
            while ((line = br.readLine())!=null){
                    printCountry(parseCsvLine(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (br!=null){
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static List<String> parseCsvLine(String str){
        List<String> list = new ArrayList<>();
        if (str!=null){
            String [] splitData = str.split(COMMA_DELIMITER);
            for (int i = 0; i < splitData.length; i++) {
                list.add(splitData[i]);
            }
        }
        return list;
    }
    public static void printCountry(List<String> list){
        System.out.println("Country [ " +
                "id = " + list.get(0)+
                ", code = " + list.get(1)+
                ", name = " + list.get(2)
                +                   " ]");
    }
}
