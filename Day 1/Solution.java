// Java Regex Problem
// https://www.hackerrank.com/challenges/java-regex/problem?isFullScreen=true
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner ipAddress = new Scanner(System.in);
        
        while(ipAddress.hasNext()) {
            String Ip = ipAddress.next();
            System.out.println(Ip.matches(new MyRegex().pattern));
        }
    }
}

class MyRegex{
    String pattern = "^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
}