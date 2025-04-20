package com.dsa.bitmanipulation;

public class BitManipulationProblems {

    public static boolean isPowerOfTwo(int n) {
        if(n <= 0) {
            return false;
        }
        else if(n == 1) {
            return true;
        } else {
            while(n > 1) {
                if(n%2 != 0 || (n != 2 && (n/2)%2 != 0)) {
                    return false;
                }
                n = n/2;
            }
            return true;
        }
    }
}
