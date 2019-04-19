package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


class Main {

    public static void main(String args[])
    {
        int weight, numItems;
        ArrayList<Integer> values = new ArrayList<Integer>();
        ArrayList<Integer> weights = new ArrayList<Integer>();

        /// ============================================================================================================
        /// ======================================    read and input file   ============================================
        /// ============================================================================================================
        File myFile = new File("./resources/readin.txt");
        Scanner scnr = null;
        try {
            scnr = new Scanner(myFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        weight = Integer.parseInt(scnr.nextLine());
        numItems = Integer.parseInt(scnr.nextLine());


        for (int i = 0; i < numItems; i++) {
            if (scnr.hasNextInt()) {
                values.add(scnr.nextInt());
            } else {
                scnr.next();
            }
        }

        for (int i = 0; i < numItems; i++) {
            if (scnr.hasNextInt()) {
                weights.add(scnr.nextInt());
            } else {
                scnr.next();
            }
        }

        /// ============================================================================================================
        /// =======  read arrayList first then transform into arrays, so size does not have to be declared =============
        /// ============================================================================================================

        Integer[] valuesARR   = values.toArray( new Integer [values.size()]);
        Integer[] weightsARR  = weights.toArray(new Integer [values.size()]);

        System.out.println("VALUE OF THE KNAPSACK:");
        System.out.print("     /// " + solve(weight, numItems, weightsARR, valuesARR) + " /// ");
    }

    static int solve(int weight, int numItems, Integer weights[], Integer values[])
    {
        int fillArr[][] = new int[numItems + 1][weight + 1];

        /// ============================================================================================================
        /// ======= fill up new 2D array while putting in maximum values, so that the last will be returned ============
        /// ============================================================================================================
        for (int i = 0; i <= numItems; i++)
        {
            for (int j = 0; j <= weight; j++)
            {
                //base, insert zero
                if (i == 0 || j == 0) {
                    fillArr[i][j] = 0;
                }

                // return the maximum between the current and prev
                else if (weights[i - 1] <= j) {
                    fillArr[i][j] = findMaximum(values[i - 1] + fillArr[i - 1][j - weights[i - 1]], fillArr[i - 1][j]);
                }

                //else case
                else
                    fillArr[i][j] = fillArr[i - 1][j];
            }
        }

        /// ============================================================================================================
        /// ==== return the last value (the object at the two indexes that was filled with the max efficiency val) =====
        /// ============================================================================================================
        return fillArr[numItems][weight];
    }

    static Integer findMaximum(int i1, int i2) {
        if (i1 > i2) {
            return i1;
        }

        else {
            return i2;
        }
    }
}