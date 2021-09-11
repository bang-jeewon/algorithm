/**
 * 재귀함수 - 이진수 변환
 */
package week6;

import java.util.Scanner;

public class Baekjoon10829 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int number = scan.nextInt();
		
		System.out.println(binary(number));
	}
	
	public static int binary(int number) {
		int answer;
		
		answer = Integer.parseInt(Integer.toBinaryString(number));
		
		return answer;
	}

}
