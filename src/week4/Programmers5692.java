/**
 * 진법변환 - 팩토리얼 진법
 */
package week4;

import java.util.Scanner;

public class Programmers5692 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int sum = 0;
		while(true) {
			int number = scan.nextInt();
			if(number == 0) {
				break;
			}
			sum = value(number);
			System.out.println(sum);
		}
	}
	
	public static int factorial(int i) {
		if(i <= 1) {
			return i; //처음 1의 자리일 경우 그냥 1 곱해야 하므로, 바로 반환
		}else {
			return factorial(i - 1)*i; //i가 2일 경우, 앞서 구한 1!에 2를 곱한 값. => 2!을 반환
		}
	}
	
	public static int value(int number) {
		int sum = 0; //팩토리얼 값
		int i = 1; //1의 자리
		int digit = (int)(Math.log10(number)+1); //number의 자릿수
		int temp = 0; //맨 끝자리 숫자
		
        while(i <= digit) {
	        temp = number%10; //맨 끝자리 숫자를  temp에 임시 저장
	        number = number/10; //맨 끝자리를 제외한 몫 부분을 새로 number에 저장
	        sum += temp * factorial(i); //맨 끝자리와 팩토리얼을 곱한 값을 계속 더해서 sum에 저장
	        i++;
	        if(i > digit) {
	        	break;
	        }
        }
        return sum;
    }

}
