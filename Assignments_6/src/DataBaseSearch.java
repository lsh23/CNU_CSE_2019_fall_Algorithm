public class DataBaseSearch {
    

    public static int twoSameLengthArrayMedianSearch(int [] a , int [] b){

        int len_array = a.length-1;
        int start = 0;
        int end = len_array;

        int mid_a = (start+end) / 2 ;
        int mid_b = end - mid_a;

        while(start<end){

            mid_a = (start+end) / 2;
            mid_b = len_array - mid_a;

            if (a[mid_a] < b[mid_b]){
                start = mid_a + 1;
            }
            else{
                end = mid_a;
            }
        }

        return Math.min(a[mid_a],b[mid_b]);
    }
}
