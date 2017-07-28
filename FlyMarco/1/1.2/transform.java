/*
ID: marco_l4
LANG: JAVA
PROG: transform
 */
import java.io.*;
import java.util.*;

class transform {
	public static void main(String[] args) throws IOException {
		test();
	}
	static void test() throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("transform.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));

		int N = Integer.parseInt(f.readLine());

		char[][] in = new char[N][N], result = new char[N][N];
		
		for (int i = 0; i < 2 * N; i++) {
			String temp = f.readLine();
			if (i < N) {
				in[i] = Arrays.copyOf(temp.toCharArray(), N);
			} else {
				result[i - N] = Arrays.copyOf(temp.toCharArray(), N);
			}
		}
			
		out.println(getResult(in, result, N));

		out.close();
	}
	
	static int getResult(char[][] in, char[][] out, int n) {
		
		return compareByOne(in, out, n) ? 1 : compareByTwo(in, out, n) ? 2 : compareByThree(in, out, n) ? 3 :
			compareByFour(in, out, n) ? 4 : compareByFive(in, out, n) ? 5 : compareBySix(in, out, n) ? 6 : 7;
	}
	
	static boolean compareByOne(char[][] in, char[][] out, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (in[i][j] != out[j][n - 1 - i ]) return false; 
			}
		}
		return true;
	}
	
	static boolean compareByTwo(char[][] in, char[][] out, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (in[i][j] != out[n - 1 - i][n - 1 - j]) return false; 
			}
		}
		return true;
	}
	
	static boolean compareByThree(char[][] in, char[][] out, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (in[i][j] != out[n - 1 - j][i]) return false; 
			}
		}
		return true;
	}
	
	static boolean compareByFour(char[][] in, char[][] out, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (in[i][j] != out[i][n - 1 - j]) return false; 
			}
		}
		return true;
	}
	
	static boolean compareByFive(char[][] in, char[][] out, int n) {			
		return compareByFourAndOne(in, out, n) || compareByFourAndTwo(in, out, n) || compareByFourAndThree(in, out, n);
	}
	
	static boolean compareBySix(char[][] in, char[][] out, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (in[i][j] != out[i][j]) return false; 
			}
		}
		return true;
	}

	static boolean compareByFourAndOne(char[][]in, char[][] out, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (in[i][j] != out[n - 1 - j][n - 1 - i]) return false; 
			}
		}
		return true;
	}
	
	static boolean compareByFourAndTwo(char[][]in, char[][] out, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (in[i][j] != out[n - 1 - i][j]) return false; 
			}
		}
		return true;
	}
	
	static boolean compareByFourAndThree(char[][]in, char[][] out, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (in[i][j] != out[j][i]) return false; 
			}
		}
		return true;
	}
}
