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

    public static void partition(int[] args, String choose,int l,int r) {

        int p;
        int i;
        int temp;
        //log("left is "+l+" and r is "+r);
        switch (choose) {
            case "first":
                if (r-l > 1) {
                    Main.countcomparison += r-l-1;
                    p = args[l];
                    i = l+1;
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
                    //Partition on the left
                    partition(args, "first", 0, i-2);
                    //Partition on the right
                    partition(args ,"first", i, r);

                }
                break;
        }
        //return args;
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

        log("Testing Partition on an array");
        System.out.println("Before Partition: " + Arrays.toString(testcase));
        partition(testcase, "first",0,testcase.length);
        log("After partition: " + Arrays.toString(testcase));

        log("");

        log("Testing Partition on an array of length = 2");
        System.out.println("Before Partition: " + Arrays.toString(testcase2));
        partition(testcase2, "first", 0, testcase2.length);
        log("After partition: " + Arrays.toString(testcase2));
        log("");

        log("Testing Partition on an array of length = 1");
        System.out.println("Before Partition: " + Arrays.toString(testcase3));
        partition(testcase3, "first", 0, testcase3.length);
        log("After partition: " + Arrays.toString(testcase3));
        log("");

        Main.countcomparison = 0;
        log("Testing Partition on an array from forum");
        System.out.println("Before Partition: " + Arrays.toString(testcaseforum));
        partition(testcaseforum, "first", 0, testcaseforum.length);
        log("After partition: " + Arrays.toString(testcaseforum));
        log("Pivot on first element comparisons: "+Main.countcomparison);
        log("");

        log("Testing Partition on an array from forum");
        System.out.println("Before Partition: " + Arrays.toString(testcaseforum2));
        partition(testcaseforum2, "first", 0, testcaseforum2.length);
        log("After partition: " + Arrays.toString(testcaseforum2));
        log("");

        /*
        myArray tc = new myArray();
        tc.arr = testcase;
        tc.index = 0;

        log("Testing Partition on an array with a class");
        System.out.println("Before Partition: " + Arrays.toString(testcase));
        myArray postc = partition2(tc, "first");
        log("After partition: " + Arrays.toString(postc.arr));
        log("");
*/
        //int[] arr = data();
        //System.out.println(Arrays.toString(arr));

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
