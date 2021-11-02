/**
 * 백준 - 잃어버린 괄호
 * https://www.acmicpc.net/problem/1541
 * https://st-lab.tistory.com/148
 */
package week14;

import java.util.Scanner;

public class Baekjoon1541 {

    public static void main(String[] args) {
    	
    	Scanner scan = new Scanner(System.in);
    	
    	int sum = Integer.MAX_VALUE;
    	String[] substraction = scan.nextLine().split("-");
    	
    	for(int i = 0; i < substraction.length; i++) {
    		int temp = 0;
    		
    		String[] addition = substraction[i].split("\\+");
    		
    		for(int j = 0; j < addition.length; j++) {
    			temp += Integer.parseInt(addition[j]);
    		}
    		
    		if(sum == Integer.MAX_VALUE) {
    			sum = temp;
    		}else {
    			sum -= temp;
    		}
    	}
    	System.out.println(sum);

    }

}
