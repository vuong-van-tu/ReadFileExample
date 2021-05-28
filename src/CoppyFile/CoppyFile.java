package CoppyFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CoppyFile{
    public List<String> readFile(String filePath){
        List<String> list = new ArrayList<>();
        try {
            File file = new File(filePath);
            FileReader fileReader=new FileReader(file);

            if (!file.exists()){
                throw new FileNotFoundException();
            }

            BufferedReader br = new BufferedReader(fileReader);
            String line;
            while ((line = br.readLine())!=null){
                list.add(line);
            }
            br.close();
        } catch (Exception e) {
            System.err.println("File không tồn tại or nội dung có lỗi!");
        }
        return list;
    }
    public void writeFile(String filePath, List<String> list){
        File file = new File(filePath);
        try {

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            for (String element: list) {
                bufferedWriter.write(element);
                bufferedWriter.newLine();
            }
            bufferedWriter.write("Danh sach copy : "+list);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        CoppyFile coppyFile = new CoppyFile();
        List<String> list = coppyFile.readFile("D:\\ReadFile\\readfile.txt");
        coppyFile.writeFile("D:\\ReadFile\\writefilelist.txt",list);
    }
}
