/**
 * 동전1 - dp
 * https://www.acmicpc.net/problem/2293
 * https://hidelookit.tistory.com/131
 */
package study17;

import java.util.Scanner;

public class Baekjoon2293 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int k = scan.nextInt();
		
		//동전 가치
		int[] coin = new int[n + 1];
		for(int i = 1; i <= n; i++) {
			coin[i] = scan.nextInt();
		}
//		System.out.println(Arrays.toString(coin));  [0, 1, 2, 5]
		
		//k원을 만들 수 있는 경우의 수
		int[] dp = new int[k + 1];
		
		dp[0] = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = coin[i]; j <= k; j++) {
				dp[j] = dp[j] + dp[j - coin[i]];
			}
		}
//		System.out.println(Arrays.toString(dp));  [1, 1, 2, 2, 3, 4, 5, 6, 7, 8, 10]
		System.out.println(dp[k]);
	}

}



/* coin[1] = 1일때 => 1원짜리 동전으로 j원을 만들수 있는 경우의 수
 * dp[0] = 1
 * dp[1] = dp[1] + dp[1-1] = 1
 * dp[2] = dp[2] + dp[2-1] = 1
 * dp[3] = dp[3] + dp[3-1] = 1 ...계속 1
 * 
 * coin[2] = 2일때 => 2원자리 동전으로 j원을 만들 수 있는 경우의 수 추가됨
 * dp[2] = dp[2] + dp[2-2] = 2
 * dp[3] = dp[3] + dp[3-2] = 2
 * dp[4] = dp[4] + dp[4-2] = 3
 * dp[5] = dp[5] + dp[5-2] = 3
 * dp[6] = dp[6] + dp[6-2] = 4
 * dp[7] = dp[7] + dp[7-2] = 4
 * dp[8] = dp[8] + dp[8-2] = 5
 * dp[9] = dp[9] + dp[9-2] = 5
 * dp[10] = dp[10] + dp[10-2] = 6
 * 
 * coin[3] = 5일때 => 5원짜리 동전으로 j원을 만들 수 있는 경우의 수 추가됨
 * dp[5] = dp[5] + dp[5-5] = 4
 * dp[6] = dp[6] + dp[6-5] = 5
 * dp[7] = dp[7] + dp[7-5] = 6
 * dp[8] = dp[8] + dp[8-5] = 7
 * dp[9] = dp[9] + dp[9-5] = 8
 * dp[10] = dp[10] + dp[10-5] = 10
 * 
 */



/*
	동전 공식 : dp[j] = dp[j] + dp[j-coin[i]]
	coin[i]원으로 1~k까지 만들 수 있는 경우의 수를 누적해서 담는다.
	
	ex) coin[2] = 2,
	4원을 구하는 경우
	dp[4] = dp[4] + dp[4-2] = dp[4] + dp[2]
	기존 2원을 구하는 경우에서 2원을 사용하여 구하는 경우를 더한다.
	2원에서 4원은 2원을 하나 더 추가하는 방법밖에 없다.
*/