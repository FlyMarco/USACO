/*
ID: marco_l4
LANG: JAVA
PROG: beads
 */
import java.io.*;
import java.util.*;

class beads {

    public static void main(String[] args) throws IOException {
        test();
    }
    
    static void test() throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("beads.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
        
        int N = Integer.parseInt(f.readLine());
        String in = f.readLine();
        
        int max = 0; 
        for (int i = 0; i < N; i++) {
            if (max < getMaxLength(in, i)) {
                max = getMaxLength(in, i);
            }
        }
        out.println(max);
        
        out.close();
    }
    
    static int getMaxLength(String in, int i) {
        int out = 2;
        int k = get(in, i), j = i;
        while (in.charAt(k) == 'w' && out < in.length()) {
            out++;
            k = getBefore(in, k);
        }
        while (in.charAt(j) == 'w' && out < in.length()) {
            out++;
            j = getAfter(in, j);
        }
        int n = j, m = k;
        while (true) {
            if (out >= in.length()) break;
            if (in.charAt(getAfter(in, n)) == in.charAt(j) || in.charAt(getAfter(in, n)) == 'w') {
                out++;
                n = getAfter(in, n);
            } else if (in.charAt(getBefore(in, m)) == in.charAt(k) || in.charAt(getBefore(in, m)) == 'w') {
                out++;
                m = getBefore(in, m);
            } else
                break;
        }
        return out; 
    }
    
    static int getAfter(String in, int i) {
        return (i + 1) % in.length();
    }
    
    static int getBefore(String in, int i) {
        return (i - 1 + in.length()) % in.length();
    }
    
    static int get(String in, int i) {
        return (i - 1 + in.length()) % in.length();
    }
}