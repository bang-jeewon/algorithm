/** 
 * Hash - 전화번호 목록
 */
package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Programmers42577 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int l = Integer.parseInt(br.readLine());
		String s = br.readLine();
		
		System.out.println(hashing(l, s));
	}
	
	public static long hashing(int l, String s) {
		int r = 31;
		int m = 1234567891;
		
		long hash = 0;
		for(int i = 0; i < l; i++) {
			hash += (s.charAt(i) - 'a' + 1) * (Math.pow(r, i)%m);
		}
		
		return hash % m;
	}

}
