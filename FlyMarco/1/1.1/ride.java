/*
ID: marco_l4
LANG: JAVA
PROG:ride
*/
import java.io.*;
import java.util.*;

class ride {
	public static void main (String [] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("ride.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
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
