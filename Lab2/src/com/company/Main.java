package com.company;

// CREATED BY LOUIS WALSH
// CSC 222 @ WAKE FOREST UNIVERSITY
// LAB #3, APRIL 6, 2018

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();


        /// ============================================================================================================
        /// ======================================    read and input file   ============================================
        /// ============================================================================================================
        File myFile = new File("./resources/filearray.txt");
        Scanner scnr = null;
        try {
            scnr = new Scanner(myFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        /// ============================================================================================================
        /// ================================   initialize adjacency matrix   ===========================================
        /// ============================================================================================================
        System.out.println("Reading adjacency matrix from file " + myFile.getPath() + ".");
        while (scnr.hasNextLine()) {
            Scanner columns = new Scanner(scnr.nextLine());
            ArrayList inpCol = new ArrayList();

            while (columns.hasNextInt()) {
                inpCol.add(columns.nextInt());
            }
            graph.add(inpCol);
        }

        /// ============================================================================================================
        /// ================================    error handling: negative numbers   =====================================
        /// ============================================================================================================
        for (int i = 0; i < graph.size(); i++) {
            for (int j = 0; j < graph.get(0).size(); j++) {
                if (graph.get(i).get(j) < 0) {
                    System.out.println("Negative number detected, exiting program.");
                    System.exit(0);
                }
            }
        }

        /// ============================================================================================================
        /// ======================================    find # of vertices    ============================================
        /// ============================================================================================================
        final int vertices = graph.size();
        System.out.println("           Graph initialized with " + vertices + " vertices.");




        DijkstraClass dC = new DijkstraClass();
        dC.solve(graph, 0);


    }
}


class DijkstraClass {

    int v;


    /// ============================================================================================================
    /// ============================    find min function, use every iteration    ==================================
    /// ============================================================================================================

    public int findMinimum (ArrayList<Integer> d, ArrayList<Boolean> path) {
        int minimum = Integer.MAX_VALUE;
        int index = -1;

        for(int i = 0; i < v; i++)
            if (!path.get(i) && d.get(i) <= minimum) {
                minimum = d.get(i);
                index = i;
            }

        return index;
    }



    /// ============================================================================================================
    /// =====================    solve, find minimum and use that vtx for next iteration    ========================
    /// ============================================================================================================
    public void solve( ArrayList<ArrayList<Integer>> graph, int vtx ) {

        v = graph.size();
        ArrayList<Integer> tracker = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            tracker.add(i, -1);
        }


        ArrayList<Integer> output = new ArrayList<Integer>();
        ArrayList<Boolean> path   = new ArrayList<Boolean>();

        for (int i = 0; i < v; i++){
            output.add(i, Integer.MAX_VALUE);
            path.add(i, false);
        }

        output.set(0, 0);

        for (int i = 0; i < v - 1; i++) {

            int min = findMinimum(output, path);
            path.set(min, true);

            for (int j = 0; j < v; j++) {

                if ( graph.get(min).get(j) != 0 && output.get(min) != Integer.MAX_VALUE && !path.get(j) &&  output.get(min) + graph.get(min).get(j) < output.get(j)) {
                    output.set(j, (output.get(min) + graph.get(min).get(j)));
                    tracker.set(j, min);
                }
            }
        }
        printPath(tracker, v, graph);
        print(output, v);

    }

    /// ============================================================================================================
    /// ======================================    simple print fxn      ============================================
    /// ============================================================================================================

    //FIXME: make the total path at the end
    public void print(ArrayList<Integer> output, int V) {

        System.out.println("");
        System.out.println("=========================================================================");
        System.out.println("");
        System.out.println("        WEIGHTS");

        System.out.println("Vertex          Distance");
        for (int i =0; i < v; i++) {
            System.out.println("  " + i + "                " + output.get(i));
        }
    }

    public void printPath(ArrayList<Integer> output, int V, ArrayList<ArrayList<Integer>> graph) {

        System.out.println("");
        System.out.println("=========================================================================");
        System.out.println("");
        System.out.println("      TOTAL PATH");
        System.out.println(" Edge          Distance");
        for(int i = 1; i < V; i++) {
            System.out.println(output.get(i) + " -> " + i + "          // " + graph.get(i).get(output.get(i)));
        }
    }
}








