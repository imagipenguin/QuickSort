package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static long countcomparison = 0;

    public static void log(Object args) {
        System.out.println(args.toString());
    }

    public static void partition(int[] args, String choose, int l, int r) {
        int p;
        int i;
        int temp;
        int mid;
        //log("left is "+l+" and r is "+r);


        if (r - l > 1) {
            //log("Partition called, not base case.");
            Main.countcomparison += r - l - 1;
            switch (choose) {
                case "first":
                    p = args[l];
                    break;
                case "last":
                    p = args[r - 1];
                    args[r - 1] = args[l];
                    args[l] = p;
                    break;
                case "mot":
                    //find the middle
                    if (((r - l) & 1) == 0) {
                        mid = l + ((r - l) / 2);
                    } else {
                        mid = l + (r - l - 1) / 2;
                    }
                    if (args[l] > args[mid]) {
                        if (args[mid] > args[r-1]) {
                            p=args[mid];
                            args[mid]=args[l];
                            args[l]=p;
                        } else if (args[l] > args[r-1]) {
                            p=args[r-1];
                            args[r-1]=args[l];
                            args[l]=p;
                        } else {
                            p=args[l];
                        }
                    } else {
                        if (args[l] > args[r-1]) {
                            p=args[l];
                        } else if (args[mid] > args[r-1]) {
                            p=args[r-1];
                            args[r-1]=args[l];
                            args[l]=p;
                        } else {
                            p=args[mid];
                            args[mid]=args[l];
                            args[l]=p;
                        }
                    }
                    break;
                default:
                    p = args[l];
                    break;
            }
            i = l + 1;
            for (int j = i; j < r; j++) {
                if (args[j] < p) {
                    temp = args[j];
                    args[j] = args[i];
                    args[i] = temp;
                    i++;
                }
            }
            temp = args[i - 1];
            args[i - 1] = args[l];
            args[l] = temp;

            //log("The index i is " + i + ", l is " + l + " and r is " + r + ".");
            //System.out.println(Arrays.toString(args));
            //Partition on the left
            partition(args, "first", l, i - 1);
            //Partition on the right
            partition(args, "first", i, r);
        }

    }

    public static void main(String[] args) {
        // write your code here
        System.out.println("Begin Code");

        //String[] arr = integers.toArray(new String[integers.size()]);


        int[] testcase = new int[]{3, 8, 2, 5, 1, 4, 7, 6};
        int[] testcase2 = new int[]{2, 1};
        int[] testcase3 = new int[]{1};
        int[] testcaseforum = new int[]{7, 5, 1, 4, 8, 3, 10, 2, 6, 9};
        int[] testcaseforum2 = new int[]{8, 10, 1, 9, 7, 2, 6, 3, 5, 4};
        /*
        t1:
        first element, 24
        last element, 23
        median element 20
        t2:
        first element, 21
        last element, 20
        median element, 19
        */

        /*
        Main.countcomparison = 0;
        log("Testing Partition on an array");
        System.out.println("Before Partition: " + Arrays.toString(testcase));
        partition(testcase, "first", 0, testcase.length);
        log("After partition: " + Arrays.toString(testcase));
        log("Comparisons, pivot on the first element: " + Main.countcomparison);
        log("");

        Main.countcomparison = 0;
        log("Testing Partition on an array of length = 2");
        System.out.println("Before Partition: " + Arrays.toString(testcase2));
        partition(testcase2, "first", 0, testcase2.length);
        log("After partition: " + Arrays.toString(testcase2));
        log("Comparisons, pivot on the first element: " + Main.countcomparison);
        log("");

        Main.countcomparison = 0;
        log("Testing Partition on an array of length = 1");
        System.out.println("Before Partition: " + Arrays.toString(testcase3));
        partition(testcase3, "first", 0, testcase3.length);
        log("After partition: " + Arrays.toString(testcase3));
        log("Comparisons, pivot on the first element: " + Main.countcomparison);
        log("");

        Main.countcomparison = 0;
        log("Testing Partition on an array from forum");
        System.out.println("Before Partition: " + Arrays.toString(testcaseforum));
        partition(testcaseforum, "first", 0, testcaseforum.length);
        log("After partition: " + Arrays.toString(testcaseforum));
        log("Pivot on first element comparisons: " + Main.countcomparison);
        log("");

        Main.countcomparison = 0;
        log("Testing Partition on an array from forum");
        System.out.println("Before Partition: " + Arrays.toString(testcaseforum2));
        partition(testcaseforum2, "first", 0, testcaseforum2.length);
        log("After partition: " + Arrays.toString(testcaseforum2));
        log("Comparisons, pivot on the first element: " + Main.countcomparison);
        log("");
        */

        /*
        testcase = new int[]{3, 8, 2, 5, 1, 4, 7, 6};
        testcase2 = new int[]{2, 1};
        testcase3 = new int[]{1};
        testcaseforum = new int[]{7, 5, 1, 4, 8, 3, 10, 2, 6, 9};
        testcaseforum2 = new int[]{8, 10, 1, 9, 7, 2, 6, 3, 5, 4};


        Main.countcomparison = 0;
        log("Testing Partition on an array");
        System.out.println("Before Partition: " + Arrays.toString(testcase));
        partition(testcase, "last", 0, testcase.length);
        log("After partition: " + Arrays.toString(testcase));
        log("Comparisons, pivot on the last element: " + Main.countcomparison);
        log("");

        Main.countcomparison = 0;
        log("Testing Partition on an array of length = 2");
        System.out.println("Before Partition: " + Arrays.toString(testcase2));
        partition(testcase2, "last", 0, testcase2.length);
        log("After partition: " + Arrays.toString(testcase2));
        log("Comparisons, pivot on the last element: " + Main.countcomparison);
        log("");

        Main.countcomparison = 0;
        log("Testing Partition on an array of length = 1");
        System.out.println("Before Partition: " + Arrays.toString(testcase3));
        partition(testcase3, "last", 0, testcase3.length);
        log("After partition: " + Arrays.toString(testcase3));
        log("Comparisons, pivot on the last element: " + Main.countcomparison);
        log("");

        Main.countcomparison = 0;
        log("Testing Partition on an array from forum");
        System.out.println("Before Partition: " + Arrays.toString(testcaseforum));
        partition(testcaseforum, "last", 0, testcaseforum.length);
        log("After partition: " + Arrays.toString(testcaseforum));
        log("Pivot on last element comparisons: " + Main.countcomparison);
        log("");

        Main.countcomparison = 0;
        log("Testing Partition on an array from forum");
        System.out.println("Before Partition: " + Arrays.toString(testcaseforum2));
        partition(testcaseforum2, "last", 0, testcaseforum2.length);
        log("After partition: " + Arrays.toString(testcaseforum2));
        log("Comparisons, pivot on the last element: " + Main.countcomparison);
        log("");
        */

        testcase = new int[]{3, 8, 2, 5, 1, 4, 7, 6};
        testcase2 = new int[]{2, 1};
        testcase3 = new int[]{1};
        testcaseforum = new int[]{7, 5, 1, 4, 8, 3, 10, 2, 6, 9};
        testcaseforum2 = new int[]{8, 10, 1, 9, 7, 2, 6, 3, 5, 4};


        Main.countcomparison = 0;
        log("Testing Partition on an array");
        System.out.println("Before Partition: " + Arrays.toString(testcase));
        partition(testcase, "mot", 0, testcase.length);
        log("After partition: " + Arrays.toString(testcase));
        log("Comparisons, pivot on the mot element: " + Main.countcomparison);
        log("");

        Main.countcomparison = 0;
        log("Testing Partition on an array of length = 2");
        System.out.println("Before Partition: " + Arrays.toString(testcase2));
        partition(testcase2, "mot", 0, testcase2.length);
        log("After partition: " + Arrays.toString(testcase2));
        log("Comparisons, pivot on the mot element: " + Main.countcomparison);
        log("");

        Main.countcomparison = 0;
        log("Testing Partition on an array of length = 1");
        System.out.println("Before Partition: " + Arrays.toString(testcase3));
        partition(testcase3, "mot", 0, testcase3.length);
        log("After partition: " + Arrays.toString(testcase3));
        log("Comparisons, pivot on the mot element: " + Main.countcomparison);
        log("");

        Main.countcomparison = 0;
        log("Testing Partition on an array from forum");
        System.out.println("Before Partition: " + Arrays.toString(testcaseforum));
        partition(testcaseforum, "mot", 0, testcaseforum.length);
        log("After partition: " + Arrays.toString(testcaseforum));
        log("Pivot on mot element comparisons: " + Main.countcomparison);
        log("");

        Main.countcomparison = 0;
        log("Testing Partition on an array from forum");
        System.out.println("Before Partition: " + Arrays.toString(testcaseforum2));
        partition(testcaseforum2, "mot", 0, testcaseforum2.length);
        log("After partition: " + Arrays.toString(testcaseforum2));
        log("Comparisons, pivot on the mot element: " + Main.countcomparison);
        log("");



        /*
        Main.countcomparison = 0;
        int[] arr = data();
        System.out.println(Arrays.toString(arr));
        log("Comparisons, pivot on the first element: "+Main.countcomparison);
        log("");
        */


        log("End of Code");
    }

    public static int[] data() {

        System.out.println("Reading File from Java code");
        //Name of the file
        String fileName = "/Users/Kristin/Desktop/QuickSort.txt";
        ArrayList<String> integers = new ArrayList<String>();
        ArrayList<Integer> ints = new ArrayList<Integer>();
        try {

            //Create object of FileReader
            FileReader inputFile = new FileReader(fileName);

            //Instantiate the BufferedReader Class
            BufferedReader bufferReader = new BufferedReader(inputFile);

            //Variable to hold the one line data
            String line;

            // Read file line by line and print on the console
            while ((line = bufferReader.readLine()) != null) {
                ints.add(Integer.parseInt(line));
            }
            //Close the buffer reader
            bufferReader.close();
        } catch (Exception e) {
            System.out.println("Error while reading file line by line:" + e.getMessage());
        }
        int[] arr = ints.stream().mapToInt(i -> i).toArray();

        return arr;
    }


}
