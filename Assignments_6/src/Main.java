import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int [] a = null;
        int [] b = null;

        try {
            //파일 객체 생성
            File file = new File("data07_a.txt");
            //입력 스트림 생성
            FileReader filereader = new FileReader(file);
            //입력 버퍼 생성
            BufferedReader bufReader = new BufferedReader(filereader);
            String line = "";
            String[] strArray = bufReader.readLine().split(", ");
            a = Arrays.asList(strArray).stream().mapToInt(x -> Integer.parseInt(x)).toArray();
            bufReader.close();
        } catch (FileNotFoundException e) {
            // TODO: handle exception
        } catch (IOException e) {
            System.out.println(e);
        }

        try {
            //파일 객체 생성
            File file = new File("data07_b.txt");
            //입력 스트림 생성
            FileReader filereader = new FileReader(file);
            //입력 버퍼 생성
            BufferedReader bufReader = new BufferedReader(filereader);
            String line = "";
            String[] strArray = bufReader.readLine().split(", ");
            b = Arrays.asList(strArray).stream().mapToInt(x -> Integer.parseInt(x)).toArray();
            bufReader.close();
        } catch (FileNotFoundException e) {
            // TODO: handle exception
        } catch (IOException e) {
            System.out.println(e);
        }

        System.out.println(DataBaseSearch.twoSameLengthArrayMedianSearch(a,b));

    }



}
