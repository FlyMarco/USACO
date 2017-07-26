/*
ID: marco_l4
LANG: JAVA
PROG:ride
*/
import java.io.*;
import java.util.*;

class ride {
  public static void main (String [] args) throws IOException {
    // Use BufferedReader rather than RandomAccessFile; it's much faster
    BufferedReader f = new BufferedReader(new FileReader("ride.in"));
                                                  // input file name goes above
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
    // Use StringTokenizer vs. readLine/split -- lots faster
						  // Get line, break into tokens
  //   int i1 = Integer.parseInt(st.nextToken());    // first integer
  //   int i2 = Integer.parseInt(st.nextToken());    // second integer
  //   out.println(i1+i2);                           // output result
  //   out.close();                                  // close the output file
    String in1 = f.readLine();
    String in2 = f.readLine();

    if ((charToInt(in1) % 47) == (charToInt(in2) % 47)) {
      out.println("GO");
    } else {
      out.println("STAY");
    }
    out.close();
  }

    static int charToInt(String in) {
      int out = 1;
      for (char c : in.toCharArray()) {
        out = out * (c - 'A' + 1);
      }
      return out;
    }
}
