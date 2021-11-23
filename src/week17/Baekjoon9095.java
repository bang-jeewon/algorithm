/**
 * 1,2,3 더하기 - DP(동적계획법)
 * https://www.acmicpc.net/problem/9095
 */
package study17;

import java.util.Scanner;

public class Baekjoon9095 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int T = scan.nextInt();
		
		int[] dp = new int[11];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		for(int i = 4; i <= 10; i++) {
			dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
		}
		
		for(int i = 0; i < T; i++) {
			int n = scan.nextInt();
			System.out.println(dp[n]);
		}
		scan.close();
	}

}
