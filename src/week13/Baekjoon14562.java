/**
 * ÅÂ±Ç¿Õ - Àç±Í ??
 */
package week13;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Baekjoon14562 {

	public static BufferedReader br;
	public static BufferedWriter bw;
	public static StringTokenizer st;
	public static int res;

	public static void loop(int x, int y, int cnt) {
		if (x == y) {
			res = Math.min(res, cnt);
			return;
		} else {
			if (2 * x <= y + 3) {
				loop(2 * x, y + 3, cnt + 1);
			}
			if (x + 1 <= y) {
				loop(x + 1, y, cnt + 1);
			}
		}
	}

	public static void main(String[] args) throws IOException {

		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int C = Integer.parseInt(br.readLine());
		for (int i = 0; i < C; i++) {
			res = 999;
			st = new StringTokenizer(br.readLine(), " ");
			int S = Integer.parseInt(st.nextToken());
			int T = Integer.parseInt(st.nextToken());

			loop(S, T, 0);

			bw.write(res + "\n");
		}
		bw.close();
	}
	
}
