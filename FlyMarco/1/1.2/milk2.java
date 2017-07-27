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
		int[][] in = new int[N][2];
		for (int i = 0; i < N; i++) {
			String temp = f.readLine();
			in[i][0] = Integer.parseInt(temp.split(" ")[0]);
			in[i][1] = Integer.parseInt(temp.split(" ")[1]);
		}
		int[] result = getResult(N, in);
		out.println(result[0] + " " + result[1]);
		
		out.close();
	}

	static int[] getResult(int N, int[][] in) {
		
		int startExist = in[0][0], endExist = in[0][1], startNo = -1, endNo = -1;
		int[] res = new int[]{endExist - startExist,0};
		for (int i = 1; i < N; i++) {
			if ((in[i][0] > endExist || in[i][1] < startExist) ) {
				if (in[i][1] - in[i][0] > res[0]) {
					res[0] = in[i][1] - in[i][0];
					startExist = in[i][0];
					endExist = in[i][1];
				}
			} else if (in[i][0] <= endExist || in[i][1] >= startExist) {
				startExist = Math.min(startExist, in[i][0]);
				endExist = Math.max(endExist, in[i][1]);
				res[0] = endExist - startExist;
			}
			if (in[i][0] > endExist) {
				startNo = endExist;
				endNo = in[i][0];
				res[1] = Math.max(res[1], endNo - startNo);
			} else if (in[i][1] < startExist) {
				startNo = in[i][1];
				endNo = startExist;
				res[1] = Math.max(res[1], endNo - startNo);
			}
		}
		return res;
	}
}
