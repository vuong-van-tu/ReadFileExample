package ReadAndWriteFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteFile {
    public List<Integer> readFile(String filePath){
        List<Integer> numbers = new ArrayList<>();
        try {
            File file = new File(filePath);
            FileReader fileReader=new FileReader(file);

            if (!file.exists()){
                throw new FileNotFoundException();
            }

            BufferedReader br = new BufferedReader(fileReader);
            String line = "";
            while ((line= br.readLine())!=null){
                numbers.add(Integer.parseInt(line));
            }
            br.close();
        } catch (Exception e) {
            System.err.println("File không tồn tại or nội dung có lỗi!");
        }
        return numbers;
    }
    public void writeFile(String filePath,int max){
        try {
            FileWriter writer = new FileWriter(filePath,true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write("Gia tri luon nhat : "+max);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static int findMax(List<Integer> numbers){
        int max = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i)>max){
                max=numbers.get(i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
        List<Integer> numbers = readAndWriteFile.readFile("D:\\ReadFile\\readfile.txt");
        System.out.println(numbers);
        int maxValue = findMax(numbers);
        readAndWriteFile.writeFile("D:\\ReadFile\\writefile.txt",maxValue);
    }
}
