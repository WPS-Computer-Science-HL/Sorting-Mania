import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.Arrays;

public class SortingShenanigans {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static final String[] colors = new String[]{
        ANSI_BLACK, ANSI_PURPLE, ANSI_BLUE, ANSI_CYAN,
        ANSI_GREEN, ANSI_YELLOW, ANSI_RED, 
    };

    public static final String[] sorts = new String[] {
        "Bogo Sort", "Bubble Sort", "Selection Sort", "Insertion Sort",
        "Quick Sort", "Merge Sort", "Heap Sort"
    };
    public static void main(String[] args) {
        //UI GOES HERE


        ArrayList<Integer> items = new ArrayList<Integer>();
        Scanner in = new Scanner(System.in);
        String input = "";
        int inputStage = 0;

        String selectedSort = "None";
        int totalElements = 0;
        int totalRuns = 0;

        long start;
        long end;
        long totalTime = 0;
        
        while (true) {
            if (inputStage == 0 || inputStage == 1) {
                sysClear();
                for (int i=0; i < sorts.length; i++) {
                    System.out.println("["+colors[Arrays.asList(sorts).indexOf(sorts[i])]+(i+1)+ANSI_RESET+"] " + sorts[i]);
                }

                System.out.println();

                if (inputStage == 0) {
                    System.out.println("Which sort would you like to analyze? [1-7] " + ANSI_PURPLE);
                }
                else {
                    System.out.println(ANSI_RED+"Invalid input"+ANSI_RESET+".");
                    System.out.println("Which sort would you like to analyze? [1-7] " + ANSI_PURPLE);
                }
                
                input = in.nextLine();

                if (input.matches("[1-7]")) {
                    inputStage = 2;
                    selectedSort = sorts[Integer.parseInt(input)-1];
                }
                else {
                    inputStage = 1;
                }

            }
            else if (inputStage == 2 || inputStage == 3) {
                sysClear();
                System.out.println("Selected Sort: " + colors[Arrays.asList(sorts).indexOf(selectedSort)] + selectedSort + ANSI_RESET);
                System.out.println();

                if (inputStage == 3) {
                    System.out.println(ANSI_RED+"Invalid input"+ANSI_RESET+".");
                }
                System.out.println("How many elements would you like to generate? " + ANSI_PURPLE);
                input = in.nextLine();

                if (input.matches("[0-9]+")) {
                    totalElements = Integer.parseInt(input);
                    inputStage = 4;
                }
                else {
                    inputStage = 3;
                }
            }
            else if (inputStage == 4 || inputStage == 5) {
                sysClear();
                System.out.println("Selected Sort: " + colors[Arrays.asList(sorts).indexOf(selectedSort)] + selectedSort + ANSI_RESET);
                System.out.println("Total Elements: " + ANSI_WHITE + totalElements + ANSI_RESET);
                System.out.println();

                if (inputStage == 5) {
                    System.out.println(ANSI_RED+"Invalid input"+ANSI_RESET+".");
                }
                System.out.println("How many test runs would you like to conduct? " + ANSI_PURPLE);
                input = in.nextLine();

                if (input.matches("[0-9]+")) {
                    totalRuns = Integer.parseInt(input);
                    inputStage = 6;
                }
                else {
                    inputStage = 5;
                }
            }
            else if (inputStage == 6) {
                System.out.println(ANSI_RESET+"Generating Elements...");
                items.clear();
                for (int i=0; i<totalElements; i++) {
                    items.add(i);
                }

                for (int i=0; i<totalRuns; i++) {
                    // Shuffle items
                    Collections.shuffle(items);
                    start = System.currentTimeMillis();
                    System.out.println(colors[Arrays.asList(sorts).indexOf(selectedSort)] + selectedSort + ANSI_RESET + " run ["+colors[Arrays.asList(sorts).indexOf(selectedSort)]+(i+1)+ANSI_RESET+"]");
                    System.out.println(">   Sorting...");

                    switch (selectedSort) {
                        case "Bogo Sort":
                            bogoSort(items);
                            break;
                        case "Bubble Sort":
                            bubbleSort(items);
                            break;
                        case "Selection Sort":
                            selectionSort(items);
                            break;
                        case "Insertion Sort":
                            insertionSort(items);
                            break;
                        case "Quick Sort":
                            quickSort(items);
                            break;
                        case "Merge Sort":
                            mergeSort(items);
                            break;
                        case "Heap Sort":
                            heapSort(items);
                            break;
                    }

                    end = System.currentTimeMillis();
                    totalTime += end-start;
                    System.out.println(">   Sorting time: " + (end-start) + "ms");
                }
                
                System.out.println();
                System.out.println("All sort runs completed.");
                System.out.println(
                    "Average sort time for " + colors[Arrays.asList(sorts).indexOf(selectedSort)] + totalElements + ANSI_RESET + " elements: " + 
                    (int)(totalTime/totalRuns) + "ms"
                    );
                
                System.out.println( 
                    "Average sort time per element: " + ((double)(totalTime/totalRuns)/totalElements) + "ms"
                );

                System.out.println();
                System.out.println("Press " + ANSI_PURPLE + "ENTER" + ANSI_RESET + " to restart program.");
                input = in.nextLine();
                input = "";
                inputStage = 0;
                
            }
        }
        
    }

    public static void sysClear() {
        System.out.print("\033[H\033[2J" + "\u001B[0m");  
        System.out.flush();
    }

    // TEST -b change made here

    private static ArrayList<Integer> createUnsortedArray(int arraySize, int lowerBound, int upperBound) {
        //CREATE THE UNSORTED ARRAYS FOR TESTS
        return null;
    }

    public static void complexityAnalysis(String sortChoice, int arraySize, int testRuns) {
        //TEST RUNS HERE
    }

    public static boolean bogoSort(ArrayList<Integer> sortMe) {
        return false;
    }

    public static boolean bubbleSort(ArrayList<Integer> sortMe) {

        int temp;
        for (int i = 0; i < sortMe.size()-1; i++) 
            for (int j = 0; j < sortMe.size()-i-1; j++) 
                if (sortMe.get(j) > sortMe.get(j+1)) 
                { 
                    temp = sortMe.get(j); 
                    sortMe.set(j, sortMe.get(j+1));
                    sortMe.set(j+1, temp);
                } 
        
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
