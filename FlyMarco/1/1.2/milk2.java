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
		BufferedReader f = new BufferedReader(new FileReader("milk2.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));

		int N = Integer.parseInt(f.readLine());
		int[] temp = new int[4];
		int[] result = new int[2];
		for (int i = 0; i < N; i++) {
			String item = f.readLine();
			int start = Integer.parseInt(item.split(" ")[0]);
			int end = Integer.parseInt(item.split(" ")[1]);
			if (i == 0) {
				result[0] = end - start;
				temp[0] = start;
				temp[1] = end;
			}
			getResult(result, temp, start, end);
		}
		out.println(result[0] + " " + result[1]);
		
		out.close();
	}

	static void getResult(int[] res, int[] temp, int start, int end) {
		if ((start > temp[1] || end < temp[0]) && end - start >= res[0]) {
			if (start > temp[1]) {
				temp[2] = temp[1];
				temp[3] = start;
				res[1] = Math.max(res[1], temp[3] - temp[2]);
			} else if (end < temp[0]) {
				temp[2] = end;
				temp[3] = temp[0];
				res[1] = Math.max(res[1], temp[3] - temp[2]);
			}
			res[0] = end - start;
			temp[0] = start;
			temp[1] = end;
		} else if (start <= temp[1] || end >= temp[0]) {
			temp[0] = Math.min(temp[0], start);
			temp[1] = Math.max(temp[1], end);
			res[0] = temp[1] - temp[0];
		}
	}
}
