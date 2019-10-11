import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] array;
        try{
            //파일 객체 생성
            File file = new File("data06.txt");
            //입력 스트림 생성
            FileReader filereader = new FileReader(file);
            //입력 버퍼 생성
            BufferedReader bufReader = new BufferedReader(filereader);
            String line = "";
            String[] strArray = bufReader.readLine().split(",");
            array = Arrays.asList(strArray).stream().mapToInt(x-> Integer.parseInt(x)).toArray();
            bufReader.close();
        }catch (FileNotFoundException e) {
            // TODO: handle exception
        }catch(IOException e){
            System.out.println(e);
        }

        QuickSort quickSort = new QuickSort();
//        array = quickSort.quickSort(array,p,r);
//        rdSotredArray = quickSort.randomizedPartition(array.p,r);

//        fileWrite(array,false);
//        fileWrite(rdSotredArray,true);

    }

    public static void fileWrite(int[] sorted_array, boolean isRandom){

        String file_name = "";
        if(isRandom) file_name = "data6_quickRandom.txt";
        else file_name = "data6_quick.txt";

        File file = new File("test1.txt");
        FileWriter writer = null;
        BufferedWriter bWriter = null;

        try {
            writer = new FileWriter(file, true);
            bWriter = new BufferedWriter(writer);

            bWriter.write(Arrays.toString(sorted_array));
            bWriter.flush();

        } catch(IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(bWriter != null) bWriter.close();
                if(writer != null) writer.close();
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
    }
}
