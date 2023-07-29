/*
Solution to Mountain Array problem:
Find peak -> Distribute the array in two section with **peak as end** and **peak as start**
-> Using binary search find the index of target elements -> Return the greatest index.
 */
public class MountainArray {

    public static void main(String[] arg) {
        int[] mountainArray = {1, 2, 3, 4, 7, 3, 2, 1};
        int target = 2;
        int peak = findPeak(mountainArray);
        int index1 = binarySearch(mountainArray, target, 0, peak, false);
        int index2 = binarySearch(mountainArray, target, peak, mountainArray.length - 1, true);
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

    private static int binarySearch(int[] arr, int target, int start, int end, boolean desc) {

        if(!desc){
            while(start<end){
                int mid = start + (end-start)/2;
                if(arr[mid]==target){
                    return mid;
                }
                else if(arr[mid]<target){
                    start = mid+1;
                }
                else end = mid;
            }
        }
        else{
            while(start<end){
                int mid = start + (end-start)/2;
                if(arr[mid]==target){
                    return mid;
                }
                else if(arr[mid]>target){
                    start = mid+1;
                }
                else end = mid;
            }
        }
        return -1;
    }
}
