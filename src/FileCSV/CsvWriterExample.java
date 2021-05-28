package FileCSV;

import java.io.File;
import java.io.FileWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvWriterExample{
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final String FILE_HEADER = "id,code,name";

    public static void main(String[] args) {
        String fileName = "";

    }
    public static void writeCSV(String fileName){
        Country country1 = new Country(1,"US","Mỹ");
        Country country2 = new Country(2,"VN","Việt Nam");
        Country country3 = new Country(3,"China","Trung Quốc");

        List<Country> countryList = new ArrayList<>();
        countryList.add(country1);
        countryList.add(country2);
        countryList.add(country3);
        FileWriter fw = null;
        try {
            fw = new FileWriter(fileName);
            fw.append(FILE_HEADER);
            fw.append(NEW_LINE_SEPARATOR);
            for (Country country:countryList) {
                fw.append(String.valueOf(country.getId()));
                fw.append(NEW_LINE_SEPARATOR);
                fw.append(country.getCode());
                fw.append(NEW_LINE_SEPARATOR);
                fw.append(country.getName());
                fw.append(NEW_LINE_SEPARATOR);
            }
            System.out.println("Tạo CSV thành công :))");
        } catch (Exception e) {
            System.out.println("Error in CSVFileWrite!!!!");
            e.getStackTrace();
        }finally {
            try {
                fw.flush();
                fw.close();
            }catch (IOException e){
                System.out.println("Lỗi khi xả và đóng fileCSV");
                e.getStackTrace();
            }
        }
    }


}