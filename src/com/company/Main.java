package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void log(Object args) {
        System.out.println(args.toString());
    }

    public static void test_mergesort(int[] args){

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


        // int[] arr = data();
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
