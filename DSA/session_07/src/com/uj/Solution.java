package com.uj;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number::");
        int n = sc.nextInt();
        //r=4
        //c=r
        //wb=n-r
        for(int r=1;r<=n;r++){
            for(int wb = 1;wb<=n-r;wb++){
                System.out.print(" ");
            }
            for(int  c = 1;c<=r;c++){
                System.out.print(c);
            }
            System.out.println();
        }
    }
}