/**
 * 동전0 - 그리디
 * https://www.acmicpc.net/problem/11047
 */
package study16;

import java.util.Scanner;

public class Baekjoon11047 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int k = scan.nextInt();
		
		int[] units = new int[n];
		for(int i = 0; i < n; i++) {
			units[i] = scan.nextInt();
		}
		
		int cnt = 0;
		for(int i = n- 1; i >= 0; i--) {
			if(k >= units[i]) {
				cnt += (k / units[i]);
				k = k % units[i];
			}
		}
		System.out.println(cnt);
		scan.close();
	}

}
