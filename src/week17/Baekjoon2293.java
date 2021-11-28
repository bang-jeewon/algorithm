/**
 * ����1 - dp
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
		
		//���� ��ġ
		int[] coin = new int[n + 1];
		for(int i = 1; i <= n; i++) {
			coin[i] = scan.nextInt();
		}
//		System.out.println(Arrays.toString(coin));  [0, 1, 2, 5]
		
		//k���� ���� �� �ִ� ����� ��
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



/* coin[1] = 1�϶� => 1��¥�� �������� j���� ����� �ִ� ����� ��
 * dp[0] = 1
 * dp[1] = dp[1] + dp[1-1] = 1
 * dp[2] = dp[2] + dp[2-1] = 1
 * dp[3] = dp[3] + dp[3-1] = 1 ...��� 1
 * 
 * coin[2] = 2�϶� => 2���ڸ� �������� j���� ���� �� �ִ� ����� �� �߰���
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
 * coin[3] = 5�϶� => 5��¥�� �������� j���� ���� �� �ִ� ����� �� �߰���
 * dp[5] = dp[5] + dp[5-5] = 4
 * dp[6] = dp[6] + dp[6-5] = 5
 * dp[7] = dp[7] + dp[7-5] = 6
 * dp[8] = dp[8] + dp[8-5] = 7
 * dp[9] = dp[9] + dp[9-5] = 8
 * dp[10] = dp[10] + dp[10-5] = 10
 * 
 */



/*
	���� ���� : dp[j] = dp[j] + dp[j-coin[i]]
	coin[i]������ 1~k���� ���� �� �ִ� ����� ���� �����ؼ� ��´�.
	
	ex) coin[2] = 2,
	4���� ���ϴ� ���
	dp[4] = dp[4] + dp[4-2] = dp[4] + dp[2]
	���� 2���� ���ϴ� ��쿡�� 2���� ����Ͽ� ���ϴ� ��츦 ���Ѵ�.
	2������ 4���� 2���� �ϳ� �� �߰��ϴ� ����ۿ� ����.
*/