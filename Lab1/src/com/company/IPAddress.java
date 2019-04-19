package com.company;


public class IPAddress {

    // ==============================================================================================================
    // this creates IPAddresses as objects, storing their four individual values of the address and their hash values
    // basic getter/setter functions for ease of use and implementation of hashing functions.
    // ==============================================================================================================

    private int int1;
    private int int2;
    private int int3;
    private int int4;
    private int hashValue;
    private String formal;

    public IPAddress(int a, int b, int c, int d) {
        int1 = a;
        int2 = b;
        int3 = c;
        int4 = d;
        formal = a + "." + b + "." + c + "." + d;
    }

    public void setHashValue (int hashValue) {
        this.hashValue = hashValue;
    }


    public int getHashValue() {
        return hashValue;
    }
    public String getIP() {
        return formal;
    }
    public int getInt1() {
        return int1;
    }
    public int getInt2() {
        return int2;
    }
    public int getInt3() {
        return int3;
    }
    public int getInt4() {
        return int4;
    }


}
