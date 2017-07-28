/*
ID: marco_l4
LANG: JAVA
PROG:gift1
*/
import java.io.*;
import java.util.*;

class gift1 {
	public static void main (String [] args) throws IOException {
		test();
	}
	static void test() throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("gift1.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));

		HashMap<String, Integer> startMoney = new HashMap<>();
		HashMap<String, Integer> finalMoney = new HashMap<>();

		int nums = Integer.parseInt(f.readLine());

		String[] people = new String[nums];

		String name;
		for (int i = 0; i < nums; i++) {
			name = f.readLine();
			people[i] = name;
			startMoney.put(name, 0);
			finalMoney.put(name, 0);
		}

		for (int i = 0; i < nums; i++) {
			name = f.readLine();
			String mp = f.readLine();
			int money = Integer.parseInt((mp.split(" "))[0]);
			int n = Integer.parseInt((mp.split(" "))[1]);
			startMoney.put(name, money);
			finalMoney.put(name, finalMoney.get(name) + (n == 0 ? money : money % n));
			for (int j = 0; j < n; j++) {
				String p = f.readLine();
				finalMoney.put(p, finalMoney.get(p) + money / n);
			}
		}

		for (String p : people) {
			out.println(p + " " + (finalMoney.get(p) - startMoney.get(p)));
		}

		out.close();
	}
}
