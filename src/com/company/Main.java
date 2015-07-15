package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static long countinv = 0;

    public static void log(Object args) {
        System.out.println(args.toString());
    }

    public static void test_mergesort(int[] args){
        Main.countinv=0;
        int[] i = mergesort(args);
        log("The number of inversions is "+countinv);
    }


    public static int[] merge(int[] a, int[] b) {
        //log("Begin Merge");
        int n = a.length + b.length;
        //log("The length of the array is " + n);
        int[] merge = new int[n];
        int i = 0;
        int j = 0;
        for (int k = 0; k < n; k++) {
            if (i < a.length && j < b.length) {
                if (a[i] <= b[j]) {
                    merge[k] = a[i];
                    i++;
                } else {
                    merge[k] = b[j];
                    j++;
                    Main.countinv += a.length - i;
                }
            } else {
                if (j < b.length) {
                    merge[k] = b[j];
                    j++;
                } else {
                    merge[k] = a[i];
                    i++;
                }
            }
            //log("The value of i is " + i + " and the value of j is " + j);
            //log(merge[k]);
        }
        return merge;
    }

    public static int[] mergesort(int[] args) {
        int l = args.length;
        //log("the length is "+l);
        //log("the halfway is "+(l-1)/2);
        if (l > 1) {
            int[] a = Arrays.copyOfRange(args, 0, (l - 1) / 2 + 1);
            int[] b = Arrays.copyOfRange(args, (l - 1) / 2 + 1, l);
            args = merge(mergesort(a), mergesort(b));
        }


        //System.out.println(Arrays.toString(a));
        //System.out.println(Arrays.toString(b));
        return args;
    }

    public static void main(String[] args) {
        // write your code here
        System.out.println("Begin Code");

        //String[] arr = integers.toArray(new String[integers.size()]);

        int[] a = new int[]{1, 3, 5, 7};
        int[] b = new int[]{2, 4, 6, 8, 10, 12};
        int[] aa = new int[]{1};
        int[] bb = new int[]{2};
        int[] aaa = new int[]{7, 3, 1, 5};
        int[] testcase = new int[]{1, 3, 5, 2, 4, 6};
        //int[] test = merge(bb, aa);
        /*
        int[] testcaseforum = new int[] { 9, 12, 3, 1, 6, 8, 2, 5, 14, 13, 11, 7, 10, 4, 0 };
        int[] testms = mergesort(testcaseforum);
        log(Main.countinv);
        Main.countinv = 0;

        int[] testms2 = mergesort(b);
        log(Main.countinv);
        Main.countinv = 0;
        int[] testms3 = mergesort(testcase);
        */

        int[] arr = data();
        int[] testcaseprogressive1 = Arrays.copyOfRange(arr, 0, 10000);
        int[] testcaseprogressive2 = Arrays.copyOfRange(arr, 0, 20000);
        int[] testcaseprogressive3 = Arrays.copyOfRange(arr, 0, 30000);
        int[] testcaseprogressive4 = Arrays.copyOfRange(arr, 0, 40000);
        int[] testcaseprogressive5 = Arrays.copyOfRange(arr, 0, 50000);
        int[] testcaseprogressive6 = Arrays.copyOfRange(arr, 0, 60000);
        int[] testcaseprogressive7 = Arrays.copyOfRange(arr, 0, 70000);
        int[] testcaseprogressive8 = Arrays.copyOfRange(arr, 0, 80000);
        int[] testcaseprogressive9 = Arrays.copyOfRange(arr, 0, 90000);
        int[] testcaseprogressive10 = Arrays.copyOfRange(arr, 0, 100000);
        test_mergesort(testcaseprogressive1);
        test_mergesort(testcaseprogressive2);
        test_mergesort(testcaseprogressive3);
        test_mergesort(testcaseprogressive4);
        test_mergesort(testcaseprogressive5);
        test_mergesort(testcaseprogressive6);
        test_mergesort(testcaseprogressive7);
        test_mergesort(testcaseprogressive8);
        test_mergesort(testcaseprogressive9);
        test_mergesort(testcaseprogressive10);

        //\log(Arrays.toString(arr));
        //log(arr[3]);
        //log(arr[3]+1);
        //int[] sortdata = mergesort(testcaseprogressive);
        //System.out.println(Arrays.toString(sortdata));
        //log("The number of inversions is " + Main.countinv + ".");
    }

    public static int[] data() {

        System.out.println("Reading File from Java code");
        //Name of the file
        String fileName = "/Users/Kristin/Desktop/IntegerArray.txt";
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
