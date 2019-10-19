import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] array = new int[1];
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

        long startTime = System.nanoTime();
        int[] quickSorted_array = quickSort.quickSort(array,0,array.length-1);
        long estimatedTime = System.nanoTime() - startTime;

        System.out.println("QuickSort 걸린 시간 : " + estimatedTime/1000000000.0 + " milli seconds");
        startTime = System.nanoTime();
        int[] randomQuickSorted_array = quickSort.quickSort_withRandom(array,0,array.length-1);
        estimatedTime = System.nanoTime() - startTime;

        System.out.println("Randomly QuickSort걸린 시간 : " + estimatedTime/1000000000.0 + " milli seconds");

        fileWrite(quickSorted_array,false);
        fileWrite(randomQuickSorted_array,true);

    }

    public static void fileWrite(int[] sorted_array, boolean isRandom){

        String file_name = "";
        if(isRandom) file_name = "data6_quickRandom.txt";
        else file_name = "data6_quick.txt";

        File file = new File(file_name);
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
