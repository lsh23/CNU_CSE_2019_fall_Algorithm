public class BinarySearch {
    public static int binarySearch(int[] array, int n) {

        int end = array.length - 1;
        int start = 0;
        int middle;

        while (end > start) {
            middle = (start + end) / 2;
            if (array[middle] > n) {
                end = middle;
            } else if (array[middle] < n) {
                start = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }
}
