import java.util.List;
import java.util.Random;

public class QuickSort {

    static Random random = new Random();

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
        int i = random.nextInt(r-p)+p;
        // i를 [p,r) 인 범위에서 랜덤적으로 선택
        int tmp = array[i];
        array[i] = array[r];
        array[r] = tmp;
        return partition(array,p,r);
    }

    public int[] quickSort(int[] array, int p , int r){
        if(p<r){
            int q = partition(array,p,r);
            quickSort(array,p,q-1);
            quickSort(array,q+1,r);
        }
        return array;
    }

    public int[] quickSort_withRandom(int[] array, int p , int r)
    {
        if(p<r){
            int q = randomizedPartition(array,p,r);
            quickSort_withRandom(array,p,q-1);
            quickSort_withRandom(array,q+1,r);
        }
        return array;
    }

}
