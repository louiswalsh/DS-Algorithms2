package com.company;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        // =======================================================================
        // initialize variables & setup - keeping hashing coefficients consistent.
        // =======================================================================

        int[] randoms = new int[4];
        Random rnd    = new Random();

        System.out.print("Using the coefficients of: ");
        for (int i = 0; i < randoms.length; i++) {
            randoms[i] = rnd.nextInt(255);
            System.out.print(randoms[i] + " ");
        }
        System.out.println("");

        int prime10s = 23, prime100s = 211, prime1000s = 2003, prime2000s = 4001, prime5000s = 10007;
        double a, b, c, average;

        // ======================================================================================
        // calculate average linked list size for a 10-element list and print to gather the data.
        // ======================================================================================

        List<IPAddress> a10 = new ArrayList<>();
        List<IPAddress> b10 = new ArrayList<>();
        List<IPAddress> c10 = new ArrayList<>();

        fillUp(a10, 10);
        fillUp(b10, 10);
        fillUp(c10, 10);

        fillHashVals(a10, randoms, prime10s);
        fillHashVals(b10, randoms, prime10s);
        fillHashVals(c10, randoms, prime10s);

        removeDuplicates(a10);
        removeDuplicates(b10);
        removeDuplicates(c10);

        a = getHashEfficiency(a10, prime10s);
        b = getHashEfficiency(b10, prime10s);
        c = getHashEfficiency(c10, prime10s);
        average = (a + b + c) / 3;

        DecimalFormat df = new DecimalFormat("#.##");
        average = Double.valueOf(df.format(average));
        System.out.println("The average Linked List size of a 10-element list is " + average);

        // ======================================================================================
        // calculate average linked list size for a 100-element list and print to gather the data.
        // ======================================================================================

        List<IPAddress> a100 = new ArrayList<>();
        List<IPAddress> b100 = new ArrayList<>();
        List<IPAddress> c100 = new ArrayList<>();

        fillUp(a100, 100);
        fillUp(b100, 100);
        fillUp(c100, 100);

        fillHashVals(a100, randoms, prime100s);
        fillHashVals(b100, randoms, prime100s);
        fillHashVals(c100, randoms, prime100s);

        removeDuplicates(a100);
        removeDuplicates(b100);
        removeDuplicates(c100);

        a = getHashEfficiency(a100, prime100s);
        b = getHashEfficiency(b100, prime100s);
        c = getHashEfficiency(c100, prime100s);
        average = (a + b + c) / 3;

        average = Double.valueOf(df.format(average));
        System.out.println("The average Linked List size of a 100-element list is " + average);

        // ======================================================================================
        // calculate average linked list size for a 1000-element list and print to gather the data.
        // ======================================================================================

        List<IPAddress> a1000 = new ArrayList<>();
        List<IPAddress> b1000 = new ArrayList<>();
        List<IPAddress> c1000 = new ArrayList<>();

        fillUp(a1000, 1000);
        fillUp(b1000, 1000);
        fillUp(c1000, 1000);

        fillHashVals(a1000, randoms, prime1000s);
        fillHashVals(b1000, randoms, prime1000s);
        fillHashVals(c1000, randoms, prime1000s);

        removeDuplicates(a1000);
        removeDuplicates(b1000);
        removeDuplicates(c1000);

        a = getHashEfficiency(a1000, prime1000s);
        b = getHashEfficiency(b1000, prime1000s);
        c = getHashEfficiency(c1000, prime1000s);
        average = (a + b + c) / 3;

        average = Double.valueOf(df.format(average));
        System.out.println("The average Linked List size of a 1000-element list is " + average);

        // ======================================================================================
        // calculate average linked list size for a 2000-element list and print to gather the data.
        // ======================================================================================

        List<IPAddress> a2000 = new ArrayList<>();
        List<IPAddress> b2000 = new ArrayList<>();
        List<IPAddress> c2000 = new ArrayList<>();

        fillUp(a2000, 2000);
        fillUp(b2000, 2000);
        fillUp(c2000, 2000);

        fillHashVals(a2000, randoms, prime2000s);
        fillHashVals(b2000, randoms, prime2000s);
        fillHashVals(c2000, randoms, prime2000s);

        removeDuplicates(a2000);
        removeDuplicates(b2000);
        removeDuplicates(c2000);

        a = getHashEfficiency(a2000, prime2000s);
        b = getHashEfficiency(b2000, prime2000s);
        c = getHashEfficiency(c2000, prime2000s);
        average = (a + b + c) / 3;

        average = Double.valueOf(df.format(average));
        System.out.println("The average Linked List size of a 2000-element list is " + average);



        // ======================================================================================
        // calculate average linked list size for a 2000-element list and print to gather the data.
        // ======================================================================================

        List<IPAddress> a5000 = new ArrayList<>();
        List<IPAddress> b5000 = new ArrayList<>();
        List<IPAddress> c5000 = new ArrayList<>();

        fillUp(a5000, 5000);
        fillUp(b5000, 5000);
        fillUp(c5000, 5000);

        fillHashVals(a5000, randoms, prime5000s);
        fillHashVals(b5000, randoms, prime5000s);
        fillHashVals(c5000, randoms, prime2000s);

        removeDuplicates(a5000);
        removeDuplicates(b5000);
        removeDuplicates(c5000);

        a = getHashEfficiency(a5000, prime5000s);
        b = getHashEfficiency(b5000, prime5000s);
        c = getHashEfficiency(c5000, prime5000s);
        average = (a + b + c) / 3;

        average = Double.valueOf(df.format(average));
        System.out.print("The average Linked List size of a 5000-element list is " + average);



        }



    public static void fillUp(List<IPAddress> n, int size) {

        // =======================================================================================================================
        // this function creates four random numbers 1 < x < 255 and constructs them as the four values for the IP Address object.
        // =======================================================================================================================

        Random rnd = new Random();
        int w, x, y, z;
        for (int i = 0; i < size; i++) {
            w = rnd.nextInt(254) + 1;
            x = rnd.nextInt(254) + 1;
            y = rnd.nextInt(254) + 1;
            z = rnd.nextInt(254) + 1;
            n.add(new IPAddress(w, x, y, z));
        }
    }

    public static void fillHashVals (List<IPAddress> n, int[] randoms, int prime) {

        // ===========================================================================================================
        // this function gives every IP Address object a hash value by using the algorithm explained in class and
        // keeping a constant a, b, c, d (in the array) so that all numbers are given the same hashing value function.
        // ===========================================================================================================

        int counter;
        int w, x, y, z;

        for (int i = 0; i < n.size(); i++) {
            w = n.get(i).getInt1() * randoms[0];
            x = n.get(i).getInt2() * randoms[1];
            y = n.get(i).getInt3() * randoms[2];
            z = n.get(i).getInt4() * randoms[3];
            counter = (w + x + y + z) % prime;
            n.get(i).setHashValue(counter);
        }
    }

    public static double getHashEfficiency(List<IPAddress> n, int prime) {

        // ====================================================================================================================
        // this function uses each IP Address's hash value to put them into an array of linked lists, using Java built in LL's
        // then, this function calculates the average size of all linked lists in the array that are NOT null.
        // ====================================================================================================================

        LinkedList<IPAddress>[] ll = new LinkedList[prime];

        int temp;
        double counterMean = 0.00;
        double counterElem = 0.00;

        for (int i = 0; i < n.size(); i++) {
            temp = n.get(i).getHashValue();
            if (ll[temp] == null) {
                ll[temp] = new LinkedList<IPAddress>();
            }
            ll[temp].add(n.get(i));
        }

        for (int i = 0; i < prime; i++) {
            if (ll[i] != null) {
                counterMean += ll[i].size();
                counterElem++;
            }
        }

        counterMean = counterMean / counterElem;

        return counterMean;
    }

    public static void removeDuplicates(List<IPAddress> n) {

        for (int i = 0; i < n.size(); i++) {
            for (int j = 1; j < n.size(); j++) {
                if (n.get(i).getIP().equals(n.get(j).getIP())) {
                    n.remove(j);
                }
            }
        }

    }


}
