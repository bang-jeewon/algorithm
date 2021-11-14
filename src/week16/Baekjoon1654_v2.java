/**
 * ���� �ڸ��� - �̺�Ž��
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
        
        // �̺�Ž��
        long left = 1; //�������̴� �ڿ����Ƿ�  �ּڰ� 1�� ����
        long right = max;
        
        while (left <= right) {
            long mid = (left + right) / 2;
            long sum = 0;
            
            for (int i = 0; i < K; i++) { // �ڸ� ���� ��
                sum += (arr[i] / mid);
            }
            
            if (sum >= N) { //�� ���� ���� ���� ��� �� ũ�� �߶������
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            
        }
        System.out.println(right);
        scan.close();
    }

}
