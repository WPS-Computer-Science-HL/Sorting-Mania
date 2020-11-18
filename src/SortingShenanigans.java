import java.util.ArrayList;
import java.util.Scanner;
public class SortingShenanigans {

    public static void main(String[] args) {
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
        return false;
    }

    public static boolean insertionSort(ArrayList<Integer> sortMe) {
        return false;
    }

    public static boolean quickSort(ArrayList<Integer> sortMe) {
        return false;
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

    public static boolean heapSort(ArrayList<Integer> sortMe) {
        return false;
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
