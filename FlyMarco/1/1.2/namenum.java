/*
ID: marco_l4
LANG: JAVA
PROG: namenum
 */
import java.io.*;
import java.util.*;

class namenum {
    
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("namenum.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("namenum.out")));

        String in = f.readLine();
        f.close();
        
        char[] TARGET = {'2','2','2','3','3','3','4','4','4','5','5','5','6','6','6',
                '7','0','7','7','8','8','8','9','9','9','0'};
        char[] key = new char[13];
        f = new BufferedReader(new FileReader("dict.txt"));
        String item = null;
        boolean isReturn = false;
        while((item = f.readLine()) != null) {
            if (item.length() == in.length()) {
                for (int i = 0; i < in.length(); i++)
                    key[i] = TARGET[item.charAt(i) - 'A'];
                if (cmp(key, in)) {
                    out.println(item);
                    isReturn = true;
                }
            }
        }
        if (!isReturn) out.println("NONE");

        out.close();
    }

    static boolean cmp(char[] key, String in) {
        for (int i = 0; i < in.length(); i++)
            if (in.charAt(i) != key[i])
                return false;
        return true;
    }
    
}
