/*
ID: marco_l4
LANG: JAVA
PROG: milk2
 */
import java.io.*;
import java.util.*;

class milk2 {
    
    public static void main(String[] args) throws IOException {
        test();
    }
    
    static void test() throws IOException {
        
        BufferedReader f = new BufferedReader(new FileReader("transform.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));
        
        int N = Integer.parseInt(f.readLine());
        int MAX = 1000000;
        int START = MAX + 1, END = -1;
        int[] step = new int[MAX + 1];
        
        for (int i = 0; i < N; i++) {
            String item = f.readLine();
            int start = Integer.parseInt(item.split(" ")[0]);
            int end = Integer.parseInt(item.split(" ")[1]);
            START = START > start ? start : START;
            END = END > end ? END : end;
            for (int j = start; j < end; j++) {
                step[j] = 1;
            }
        }
        
        int MAXEXIST = 0, MAXNO = 0, exist = 0, no = 0;
        
        for (int i = START; i < END; i++) {          
            if (step[i] == 1) {
                exist++;
                no = 0;
                MAXEXIST = MAXEXIST > exist ? MAXEXIST : exist;
            } else {
                exist = 0;
                no++;
                MAXNO = MAXNO > no ? MAXNO : no;
            }
        }
        out.println(MAXEXIST + " " + MAXNO);
        
        out.close();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}