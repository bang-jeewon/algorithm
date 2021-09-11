/**
 * 진법변환 - 진법변환
 */
package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2745 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        String n = stk.nextToken();
        int b = Integer.parseInt(stk.nextToken());
		
		System.out.println(conversion(n, b));
		
	}
	
	public static int conversion(String n, int b) {
		
		char[] digits = n.toCharArray(); //숫자 자릿값 배열
		
		int number = 0;
		
		for(int i = 0; i < n.length(); i++) {
			if(digits[i] >= 'A') {
				number = number * b + (digits[i] - 'A' + 10);
			}else {
				number = number * b + (digits[i] - '0');
			}
		}
		return number;
		
	}

}
