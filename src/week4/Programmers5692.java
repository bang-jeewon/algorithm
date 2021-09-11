/**
 * ������ȯ - ���丮�� ����
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
			return i; //ó�� 1�� �ڸ��� ��� �׳� 1 ���ؾ� �ϹǷ�, �ٷ� ��ȯ
		}else {
			return factorial(i - 1)*i; //i�� 2�� ���, �ռ� ���� 1!�� 2�� ���� ��. => 2!�� ��ȯ
		}
	}
	
	public static int value(int number) {
		int sum = 0; //���丮�� ��
		int i = 1; //1�� �ڸ�
		int digit = (int)(Math.log10(number)+1); //number�� �ڸ���
		int temp = 0; //�� ���ڸ� ����
		
        while(i <= digit) {
	        temp = number%10; //�� ���ڸ� ���ڸ�  temp�� �ӽ� ����
	        number = number/10; //�� ���ڸ��� ������ �� �κ��� ���� number�� ����
	        sum += temp * factorial(i); //�� ���ڸ��� ���丮���� ���� ���� ��� ���ؼ� sum�� ����
	        i++;
	        if(i > digit) {
	        	break;
	        }
        }
        return sum;
    }

}
