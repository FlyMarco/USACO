/*
ID: marco_l4
LANG: JAVA
PROG:friday
*/
import java.io.*;
import java.util.*;

class friday {
    
    public static void main (String [] args) throws IOException {
        test();    
    }
    
    static void test() throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("friday.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
        int nums = Integer.parseInt(f.readLine());
        int[] res = new int[7];
        for (int i = 0; i < nums; i++) {
            for (int j = 0; j < 12 ;j++) {
                res[getDay(i + 1, j + 1, isLeapYear(1900 + i))]++;
            }
        }
        out.println(res[6] + " " + res[0] + " " + res[1] + " " + res[2] + " " + res[3] + " " + res[4] + " " + res[5]);
        out.close();
    }
    
    static int getDay(int n, int m, boolean isLeap) {
        int startDay = getStartDayOfYear(n);
        
        int month2 = isLeap ? 29 : 28;
        switch (m) {
            case 1 :
                return (13 - 1 + startDay ) % 7;
            case 2 :
                return (31 + 13 - 1 + startDay) % 7;
            case 3 :
                return (31 + month2 + 13 - 1 + startDay)% 7;
            case 4 :
                return (31 * 2 + month2 + 13 - 1 + startDay) % 7;
            case 5 :
                return (31 * 2 + month2 + 30 + 13 - 1 + startDay) % 7;
            case 6 :
                return (31 * 3 + month2 + 30 + 13 - 1 + startDay) % 7;
            case 7 :
                return (31 * 3 + month2 + 30 * 2 + 13 - 1 + startDay) % 7;
            case 8 :
                return (31 * 4 + month2 + 30 * 2 + 13 - 1 + startDay) % 7;
            case 9 :
                return (31 * 5 + month2 + 30 * 2 + 13 - 1 + startDay) % 7;
            case 10 :
                return (31 * 5 + month2 + 30 * 3 + 13 - 1 + startDay) % 7;
            case 11 :
                return (31 * 6 + month2 + 30 * 3 + 13 - 1 + startDay) % 7;
            case 12 :
                return (31 * 6 + month2 + 30 * 4 + 13 - 1 + startDay) % 7;
            default :
                return 0;
        }     
    }
    
    static int getStartDayOfYear(int n) {
        int leap = getLeapNums(n - 1);
        int day = 365 * (n - 1 - leap) + 366 * leap;
        return day % 7 + 1;     
    }
    
    static int getLeapNums(int n) {
        int out = 0;
        for (int i = 0; i < n; i++) {
            if (isLeapYear(1900 + i))
                out++;
        }
        return out;
    }
    
    static boolean isLeapYear(int in) {
        return (in % 100 != 0 && in % 4 == 0) || (in % 100 == 0 && in % 400 == 0);
    }
}