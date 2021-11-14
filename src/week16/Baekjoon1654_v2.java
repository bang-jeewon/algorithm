/**
 * 랜선 자르기 - 이분탐색
 * https://www.acmicpc.net/problem/1654
 */
package study16;

import java.util.Scanner;

public class Baekjoon1654_v2 {

	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int K = scan.nextInt();
        long N = scan.nextLong();
        
        long[] arr = new long[K];
        long max = 0;
        
        for (int i = 0; i < K; i++) {
            arr[i] = scan.nextLong();
            max = Math.max(max, arr[i]);
        }
        
        // 이분탐색
        long left = 1; //랜선길이는 자연수므로  최솟값 1로 세팅
        long right = max;
        
        while (left <= right) {
            long mid = (left + right) / 2;
            long sum = 0;
            
            for (int i = 0; i < K; i++) { // 자른 개수 합
                sum += (arr[i] / mid);
            }
            
            if (sum >= N) { //더 많은 랜선 나온 경우 더 크게 잘라줘야함
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            
        }
        System.out.println(right);
        scan.close();
    }

}
