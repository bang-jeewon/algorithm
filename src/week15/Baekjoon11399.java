/**
 * ATM - Å½¿å¹ý
 * https://www.acmicpc.net/problem/11399
 */
package study15;

import java.util.Arrays;
import java.util.Scanner;

public class Baekjoon11399 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
    	
    	int n = scan.nextInt();
    	
    	int[] time = new int[n];
    	for(int i = 0; i < n; i++) {
    		time[i] = scan.nextInt();
    	}
    	Arrays.sort(time);
    	
    	int[] answer = new int[n];
    	answer[0] = time[0];
    	for(int i = 1; i < answer.length; i++) {
    		answer[i] = answer[i - 1] + time[i];
    	}
    	
    	int sum = 0;
    	for(int a : answer) {
    		sum += a;
    	}
    	System.out.println(sum);
	}

}
