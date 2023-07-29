/*
Rotated Array Binary Search: Here the array is rotated by having a particular pivot.
*/


public class RotatedArrayBinarySearch {
    public static void main(String[] args){
        int[] arr = {4,5,8,9,0,1,2};
        int target = 2;
        int peak = findPeak(arr);
        System.out.println(peak);
        int index1 = binarySearch(arr, target, 0, peak);
        int index2 = binarySearch(arr, target, peak+1, arr.length - 1);
        if(index2==-1){
            if(index1==-1) System.out.println("Target Element not found");
            else System.out.println("Target element at: "+index1);
        }
        else System.out.println("Target element at: "+index2);
    }

    private static int findPeak(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if ((arr[mid] > arr[mid + 1]) && (arr[mid] > arr[mid - 1])) {
                return mid;
            } else if (arr[mid] < arr[mid + 1]) {
                start = mid + 1;
            } else end = mid;
        }
        return -1;
    }

    private static int binarySearch(int[] arr, int target, int start, int end) {
            while(start<=end){
                int mid = start + (end-start)/2;
                if(arr[mid]==target){
                    return mid;
                }
                else if(arr[mid]<target){
                    start = mid+1;
                }
                else end = mid-1;
            }
        return -1;
    }
}
