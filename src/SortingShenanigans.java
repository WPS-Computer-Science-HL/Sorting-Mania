import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
public class SortingShenanigans {

    public static void main(String[] args) throws Exception{
        //UI GOES HERE

        // TEST A change made
        Random rand = new Random();
        ArrayList<Integer> test = new ArrayList<Integer>();
        for(int i = 0; i < 10; i++) {
            test.add(rand.nextInt(10));
        }
        heapSort(test);
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
        return false;
    }

    public static boolean insertionSort(ArrayList<Integer> sortMe) {
        return false;
    }

    public static boolean quickSort(ArrayList<Integer> sortMe) {
        return false;
    }

    public static boolean mergeSort(ArrayList<Integer> sortMe) {
        return false;
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
            heapify(heap, 0, heap.size() - i - 1);
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
