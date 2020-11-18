import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
public class SortingShenanigans {

    public static void main(String[] args) throws Exception{
        //UI GOES HERE

        // TEST A change made
        
    }

    // TEST -b change made here

    private static ArrayList<Integer> createUnsortedArray(int arraySize, int lowerBound, int upperBound) {
        //CREATE THE UNSORTED ARRAYS FOR TESTS
        return null;
    }

    public static void complexityAnalysis(String sortChoice, int arraySize, int testRuns) {
        //TEST RUNS HERE
        System.out.println("New");
    }

    public static boolean bogoSort(ArrayList<Integer> sortMe) {
        return false;
    }

    public static boolean bubbleSort(ArrayList<Integer> sortMe) {
        return false;
    }

    public static boolean selectionSort(ArrayList<Integer> sortMe) {
        for(int i = 0; i < sortMe.size(); i++) {
            int min = sortMe.get(0+i);
            int ele = i;
            for(int a = 0; a < sortMe.size() - i; a++) {
                if(sortMe.get(i+a)<min){
                    min = sortMe.get(i+a);
                    ele = i+a;
                }
            }
            sortMe.remove(ele);
            sortMe.add(i, min);
        }
        return false;
    }

    public static boolean insertionSort(ArrayList<Integer> sortMe) {
        for(int i = 0; i < sortMe.size(); i++) {
            int c = sortMe.get(i);
            int p = i-1;
            while (p > -1 && sortMe.get(p)>c){
                sortMe.set(p+1, sortMe.get(p));
                p--; 
            }
            sortMe.set(p+1, c);
        }
        return false;
    }
    public static void quickSort(ArrayList<Integer> sortMe) {
		quickSort(sortMe, 0, sortMe.size() -1);
	}
    public static void quickSort(ArrayList<Integer> sortMe, int low, int high) {
        if (low < high+1) {
			int p = partition(sortMe, low, high);
			quickSort(sortMe, low, p-1);
			quickSort(sortMe, p+1, high);
		}
    }
    // moves all the values that are less than the pivot to the left and values greater than the pivot to the greater
    // returns the index of the pivot
    private static void swap(ArrayList<Integer> sortMe, int low, int high) {

        int temp = sortMe.get(low);
        sortMe.set(low, sortMe.get(high));
        sortMe.set(high, temp);		
    }
    
    public static int partition(ArrayList<Integer> sortMe, int low, int high){
        int split = low + 1;
		for (int i = split; i <= high; i++) {
			if (sortMe.get(i) < sortMe.get(low)) {
				swap(sortMe, i, split++);
			}
		}
		swap(sortMe, low, split-1);
		return split-1;

    }

    public static ArrayList<Integer> mergeSort(ArrayList<Integer> sortMe) {
        // IF LIST IS 1 ELEMENT LONG RETURN INPUT
        if (sortMe.size() == 1) return sortMe;

        // INITIALIZING
        ArrayList<Integer> leftArray = new ArrayList<Integer>();
        ArrayList<Integer> rightArray = new ArrayList<Integer>();
        ArrayList<Integer> sortedArray = new ArrayList<Integer>();
        int high = sortMe.size();

        // CREATE LEFT AND RIGHT ARRAYS
        for (int i = 0; i < high/2; i++) {
          leftArray.add(sortMe.get(i));
        }
        for (int i = high/2; i < high; i++) {
          rightArray.add(sortMe.get(i));
        }

        // MERGESORT BOTH ARRAYS
        leftArray = mergeSort(leftArray);
        rightArray = mergeSort(rightArray);

        // MERGES BOTH ARRAYS
        while (leftArray.isEmpty() && rightArray.isEmpty()) {
            if (leftArray.get(0) > rightArray.get(0)) {
                sortedArray.add(rightArray.get(0));
                rightArray.remove(0);
            } else {
                sortedArray.add(leftArray.get(0));
                leftArray.remove(0);
            }
        }
        while (leftArray.isEmpty()) {
            sortedArray.add(leftArray.get(0));
            leftArray.remove(0);
        }
        while (rightArray.isEmpty()) {
            sortedArray.add(rightArray.get(0));
            rightArray.remove(0);
        }

        // RETURN RESULT
        return sortedArray;
    }

    private static void swap(ArrayList<Integer> swapMe, int indexA, int indexB){
        int temp = swapMe.get(indexA);
        swapMe.set(indexA, swapMe.get(indexB));
        swapMe.set(indexB, temp);
    }

    private static void heapify(ArrayList<Integer> heap, int index, int heapCap) {
        int leftChildIndex = index * 2 + 1;
        int rightChildIndex = index * 2 + 2;
        int largest = index;
        
        if(leftChildIndex < heapCap && heap.get(leftChildIndex) > heap.get(largest)) {
            largest = leftChildIndex;
        } 

        if(rightChildIndex < heapCap && heap.get(rightChildIndex) > heap.get(largest)) {
            largest = rightChildIndex;
        } 

        if(largest != index) {
            swap(heap, largest, index);
        }
    }

    private static void heapify(ArrayList<Integer> heap, int heapCap) {
        int start = (heapCap / 2) - 1;

        for(int i = start; i >= 0; i--) {
            heapify(heap, i, heapCap);
        }
    }

    public static boolean heapSort(ArrayList<Integer> heap) throws Exception{
        heapify(heap, heap.size());
        for(int i = 0; i < heap.size(); i++) {
            swap(heap, 0, heap.size() - i - 1);
            heapify(heap, heap.size() - i - 1);
        }
        isSorted(heap);
        return true;
    }

    private static void isSorted(ArrayList<Integer> testMe) throws Exception{
        //VALIDATE IF ARRAYLIST IS SORTED
        for(int i = 1; i < testMe.size(); i++) {
            if(testMe.get(i-1) > testMe.get(i)) {
                throw new Exception("ArrayList unsorted, index i-1 > index i : " + testMe.get(i-1) + " > " + testMe.get(i));
            }
        }
    }

    // Modified Version

    private static int isUnsorted(ArrayList<Integer> testMe){
        //VALIDATE IF ARRAYLIST IS SORTED
        // Returns index of unsorted pair
        // If sorted, returns -1
        for(int i = 1; i < testMe.size(); i++) {
            if(testMe.get(i-1) > testMe.get(i)) {
                return i;
            }
        }
        return -1;
    }
}
