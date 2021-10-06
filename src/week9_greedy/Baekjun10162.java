package week9;

import java.util.Scanner;

public class Baekjun10162 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int t = scan.nextInt();
		int a = 0;
		int b = 0;
		int c = 0;
		
		if(t%10 == 0) {
			if(t >= 300) {
				a = t/300;
				t = t%300;
			}

			if(t >= 60) {
				b = t/60;
				t = t%60;
			}
			
			c = t/10;
			
			System.out.println(a + " " + b + " " + c);
		}else {
			System.out.println(-1);
		}
	}

}
