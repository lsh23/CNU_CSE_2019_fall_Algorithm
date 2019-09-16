import java.util.Arrays;

public class Insertion_sort {

    public static <T extends Number> T[] sort (T[] array){
        //Insertion sort;
        for ( int i = 1; i < array.length ; i++){
            T key = array[i];
            for(int j = i-1 ; j >=0 ; j--){
                while( j >= 0 && array[j].doubleValue() > key.doubleValue()) {
                    T tmp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = tmp;
                    j = j - 1;
                }
                array[j+1]=key;
                break;
            }
        }
        return array;
    }

    public static void main(String[] args) {
//        Integer[] integers = { 1, 34, 6, 5, 2};
//        Integer[] integers = { 1, 2, 6, 5, 34};
        Integer[] integers = { 34, 1, 6, 5, 2};
//        Double[] doubles = { 1.0, 2.0,3.0 , 54.0, 34.0};
        Integer[] sorted = Insertion_sort.sort(integers);
        System.out.println(Arrays.toString(sorted));

    }
}
