package com.cybernetic;

import java.util.*;

public class AlgorithmAnalysis {
    public static void main(String[] args) {
        // Declare empty arrays of varying sizes
        int[] test100 = new int[100];
        int[] test500 = new int[500];
        int[] test1000 = new int[1000];
        int[] test10000 = new int[10000];
        int[] test100000 = new int[100000];

        // Use the fillArray and shuffleArray methods to fill and randomly shuffle the arrays
        fillArray(test100);
        shuffleArray(test100);
        fillArray(test500);
        shuffleArray(test500);
        fillArray(test1000);
        shuffleArray(test1000);
        fillArray(test10000);
        shuffleArray(test10000);
        fillArray(test100000);
        shuffleArray(test100000);

        // An array to hold the time it took for each round of testing
        long[] timeArray = new long[10];

        // Run the algorithmTest method for each algorithm, for each array, and reset the time array before each new call
        algorithmTest(test100, 1, "bubble sort", timeArray);
        System.out.println();

        Arrays.fill(timeArray, 0);
        algorithmTest(test500, 1, "bubble sort", timeArray);
        System.out.println();

        Arrays.fill(timeArray, 0);
        algorithmTest(test1000, 1, "bubble sort", timeArray);
        System.out.println();

        Arrays.fill(timeArray, 0);
        algorithmTest(test10000, 1, "bubble sort", timeArray);
        System.out.println();

        Arrays.fill(timeArray, 0);
        algorithmTest(test100000, 1, "bubble sort", timeArray);
        System.out.println();

        // Shuffle the array again, so that it's unsorted before testing the next sorting algorithm
        shuffleArray(test100);
        shuffleArray(test500);
        shuffleArray(test1000);
        shuffleArray(test10000);
        shuffleArray(test100000);

        Arrays.fill(timeArray, 0);
        algorithmTest(test100, 1, "insertion sort", timeArray);
        System.out.println();

        Arrays.fill(timeArray, 0);
        algorithmTest(test500, 1, "insertion sort", timeArray);
        System.out.println();

        Arrays.fill(timeArray, 0);
        algorithmTest(test1000, 1, "insertion sort", timeArray);
        System.out.println();

        Arrays.fill(timeArray, 0);
        algorithmTest(test10000, 1, "insertion sort", timeArray);
        System.out.println();

        Arrays.fill(timeArray, 0);
        algorithmTest(test100000, 1, "insertion sort", timeArray);
        System.out.println();

        // Shuffle the array again, so that it's unsorted before testing the next sorting algorithm
        shuffleArray(test100);
        shuffleArray(test500);
        shuffleArray(test1000);
        shuffleArray(test10000);
        shuffleArray(test100000);

        Arrays.fill(timeArray, 0);
        algorithmTest(test100, 1, "selection sort", timeArray);
        System.out.println();

        Arrays.fill(timeArray, 0);
        algorithmTest(test500, 1, "selection sort", timeArray);
        System.out.println();

        Arrays.fill(timeArray, 0);
        algorithmTest(test1000, 1, "selection sort", timeArray);
        System.out.println();

        Arrays.fill(timeArray, 0);
        algorithmTest(test10000, 1, "selection sort", timeArray);
        System.out.println();

        Arrays.fill(timeArray, 0);
        algorithmTest(test100000, 1, "selection sort", timeArray);
        System.out.println();

        // Shuffle the array again, so that it's unsorted before testing the next sorting algorithm
        shuffleArray(test100);
        shuffleArray(test500);
        shuffleArray(test1000);
        shuffleArray(test10000);
        shuffleArray(test100000);

        Arrays.fill(timeArray, 0);
        algorithmTest(test100, 1, "merge sort", timeArray);
        System.out.println();

        Arrays.fill(timeArray, 0);
        algorithmTest(test500, 1, "merge sort", timeArray);
        System.out.println();

        Arrays.fill(timeArray, 0);
        algorithmTest(test1000, 1, "merge sort", timeArray);
        System.out.println();

        Arrays.fill(timeArray, 0);
        algorithmTest(test10000, 1, "merge sort", timeArray);
        System.out.println();

        Arrays.fill(timeArray, 0);
        algorithmTest(test100000, 1, "merge sort", timeArray);
        System.out.println();

        Arrays.fill(timeArray, 0);
        algorithmTest(test100, 1, "linear search", timeArray);
        System.out.println();

        Arrays.fill(timeArray, 0);
        algorithmTest(test500, 1, "linear search", timeArray);
        System.out.println();

        Arrays.fill(timeArray, 0);
        algorithmTest(test1000, 1, "linear search", timeArray);
        System.out.println();

        Arrays.fill(timeArray, 0);
        algorithmTest(test10000, 1, "linear search", timeArray);
        System.out.println();

        Arrays.fill(timeArray, 0);
        algorithmTest(test100000, 1, "linear search", timeArray);
        System.out.println();

        Arrays.fill(timeArray, 0);
        algorithmTest(test100, 1, "binary search", timeArray);
        System.out.println();

        Arrays.fill(timeArray, 0);
        algorithmTest(test500, 1, "binary search", timeArray);
        System.out.println();

        Arrays.fill(timeArray, 0);
        algorithmTest(test1000, 1, "binary search", timeArray);
        System.out.println();

        Arrays.fill(timeArray, 0);
        algorithmTest(test10000, 1, "binary search", timeArray);
        System.out.println();

        Arrays.fill(timeArray, 0);
        algorithmTest(test100000, 1, "binary search", timeArray);
        System.out.println();

    }

    /**
     * This method fills an array with integers in ascending order from zero
     * @param arr - the array to be filled
     */
    public static void fillArray(int[] arr) {
        int x = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = x;
            x++;
        }
    }

    /**
     * This method randomly swaps every element in an array
     * @param arr - the array to be shuffled
     */
    public static void shuffleArray(int[] arr) {
        Random rnd = new Random();
        for (int i = 0; i < arr.length; i++) {
            int rndIndexToSwap = rnd.nextInt(arr.length);
            int temp = arr[rndIndexToSwap];
            arr[rndIndexToSwap] = arr[i];
            arr[i] = temp;
        }
    }

    /**
     * This method is a bubble sort
     * @param arr the array to be sorted
     */
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr.length - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
    }

    /**
     * This method is an insertion sort
     * @param arr the array to be sorted
     */
    public static void insertionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    /**
     * This method is a selection sort
     * @param arr the array to be sorted
     */
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++)
                if (arr[j] < arr[min])
                    min = j;

            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }

    /**
     * This method is a merge sort
     * @param arr the array to be sorted
     * @param n the length of the array
     */
    public static void mergeSort(int[] arr, int n) {
        if (n < 2)
            return;

        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++)
            l[i] = arr[i];

        for( int i = mid; i < n; i++)
            r[i - mid] = arr[i];

        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(arr, l, r, mid, n - mid);
    }

    /**
     * This method is the merge portion of the merge sort
     * @param arr - the oringal array
     * @param l - the left array
     * @param r - the right array
     * @param left - the left array's end
     * @param right - the right array's end
     */
    public static void merge(int[] arr, int[] l, int[] r, int left, int right) {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                arr[k++] = l[i++];
            }
            else
                arr[k++] = r[j++];
        }
        while (i < left)
            arr[k++] = l[i++];
        while (j < right)
            arr[k++] = r[j++];
    }

    /**
     * This method is a linear search
     * @param arr - the array to be searched
     * @param x - the search value
     * @return - the index of x, or -1 if x is not found
     */
    public static int linearSearch(int[] arr, int x) {
        for(int i = 0; i < arr.length; i++) {
            if (arr[i] == x)
                return i;
        }
        return -1;
    }

    /**
     * This method is a binary search
     * @param arr - the array to be searched
     * @param l - the left end of the array
     * @param r - the right end of the array
     * @param x - the search value
     * @return the index of x, or -1 if x is not found
     */
    public static int binarySearch(int[] arr, int l, int r, int x) {
        int mid = l + (r - l) / 2;
        if (r >= l && l <= arr.length - 1) {
            if (arr[mid] == x)
                return mid;
            if (arr[mid] > x)
                return binarySearch(arr, l, mid - 1, x);
            if (arr[mid] < x)
                return binarySearch(arr, mid + 1, r, x);
        }
        return -1;
    }

    /**
     * This method runs 10 tests for a given algorithm, printing the fastest, slowest, and average time
     * @param arr - the array the test is to be done on
     * @param testRuns - the number of the current round of testing
     * @param alg - the name of the algorithm to be tested
     * @param testTimes - the array that holds the times for all 10 tests
     */
    public static void algorithmTest(int[] arr, int testRuns, String alg, long[] testTimes) {
        long startTime = 0, endTime = 0;

        // Display the results once the 10th round of testing is compeleted
        if (testRuns  > 10) {
            long fastest = testTimes[0];
            long slowest = testTimes[0];
            long avg = 0;

            // Find the fasted time
            for (int i = 0; i < testTimes.length; i++) {
                if (testTimes[i] < fastest)
                    fastest = testTimes[i];
            }

            // Find the slowest time
            for (int i = 0; i < testTimes.length; i++) {
                if (testTimes[i] > slowest)
                    slowest = testTimes[i];
            }

            // Find the average
            long sum = 0;
            for (int i = 0; i < testTimes.length; i++) {
                sum += testTimes[i];
                avg = sum / testTimes.length;
            }

            // Print the results
            System.out.println("Algorithm analysis results for " + alg + " on array of size " + arr.length + ":");
            System.out.println("Fastest time: " + fastest + " nanoseconds");
            System.out.println("Slowest time: " + slowest + " nanoseconds");
            System.out.println("Average time: " + avg + " nanoseconds");
        }

        else {
            Random rnd = new Random(); // To provide random search values for the search algorithms

            // Run the chosen algorithm, keeping track of the start and end times
            switch (alg) {
                case "bubble sort":
                    startTime = System.nanoTime();
                    bubbleSort(arr);
                    endTime = System.nanoTime();
                    break;
                case "insertion sort":
                    startTime = System.nanoTime();
                    insertionSort(arr);
                    endTime = System.nanoTime();
                    break;
                case "selection sort":
                    startTime = System.nanoTime();
                    selectionSort(arr);
                    endTime = System.nanoTime();
                    break;
                case "merge sort":
                    startTime = System.nanoTime();
                    mergeSort(arr, arr.length);
                    endTime = System.nanoTime();
                    break;
                case "linear search":
                    startTime = System.nanoTime();
                    linearSearch(arr, rnd.nextInt(arr.length));
                    endTime = System.nanoTime();
                    break;
                case "binary search":
                    startTime = System.nanoTime();
                    binarySearch(arr, 0, arr.length -1, rnd.nextInt(arr.length));
                    endTime = System.nanoTime();
                    break;
            }

            // Calculate the time it took for the test and add it to the testTimes array before incrementing testRuns and running the test again
            testTimes[testRuns - 1] = endTime - startTime;
            testRuns++;
            algorithmTest(arr, testRuns, alg, testTimes);
        }

    }

}
