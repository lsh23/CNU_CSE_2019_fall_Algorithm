import java.util.List;
import java.util.Random;

public class QuickSort {

    public int partition(int[] array, int p , int r){
        int x = array[r];
        int i = p-1;
        for(int j = p ;j < r ; j++){
            if(array[j]<x){
                i++;
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
            }
        }
        i++;
        int tmp = array[i];
        array[i] = array[r];
        array[r] = tmp;
        return i;
    }

    public int randomizedPartition(int[] array, int p, int r){
        return 0;
    }

    public int[] quickSort(int[] array, int p , int r){
        if(p<r){
            int q = partition(array,p,r);
            quickSort(array,p,q-1);
            quickSort(array,q+1,r);
        }
        return array;
    }

    public int[] quickSort_withRandom(int[] array, int p , int r){
        return array;
    }

}
