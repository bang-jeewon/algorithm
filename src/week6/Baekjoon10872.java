/**
 * 재귀함수 - 팩토리얼
 */
package week6;

import java.util.Scanner;

public class Baekjoon10872 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int number = scan.nextInt();
		
		System.out.println(factorial(number));
	}
	
	public static int factorial(int number) {
		if(number <= 1) {
			return 1;
		}else {
			return factorial(number - 1)*number;
		}
	}
	
}
