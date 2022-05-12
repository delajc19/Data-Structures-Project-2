/**
 * Joseph de la Viesca
 * CSC 201
 * Project 2, Question 1
 * 3/25/22
 */
package Question1;
/**
 * T(n) = 2T(n/2) + n
 * a = 2
 * b = 2
 * c = 1
 * Final theta bound: Theta(nlogn)
 */
public class Quicksort {
   
    public static void my_quicksort(int[] array){
        quicksort_helper(array, 0, array.length-1);
    }

    private static void quicksort_helper(int[] array, int low, int high){
        /*Recursively call quicksort_helper on the left and right partitions of 
        the sorted array until low >= high, at which point the low and high pointers
        have met and the function reaches its base case. */
        if (low < high){

            //Recursively call quicksort on every element to the left of the pivot
            quicksort_helper(array, low, partition(array, low, high) - 1);
            //Recursively call quicksort on every element to the right of the pivot
            quicksort_helper(array, partition(array, low, high) + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high){
        //Choose pivot value as the first element of the array
        int pivot = array[low]; 
        
        int k = high+1; //index of the smaller element in the array

        for(int i = high; i >= low+1; i--){
            /*If the element at the index of the current iteration <= the pivot, 
            swap it with the element at k and move k pointer to the left*/
            if(array[i] <= pivot){
                k--;
                swap(array, k, i);
            }
        }
        swap(array, k - 1, low);
        return(k - 1);
        
    }

    /* Swaps two elements of an array */
    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
