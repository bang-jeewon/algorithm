/**
 * 완전탐색 - 소수찾기
 */
package week2;

import java.util.HashSet;
import java.util.Set;

public class Programmers42839 {

	static Set<String> sum = new HashSet<>();
	static boolean[] visit;
	
	public static int solution(String numbers) {
        int answer = 0;
        int n = numbers.length();
        int[] num = new int[n];
        
        for(int i=0; i<num.length; i++ ) {
        	char number = numbers.charAt(i);
        	num[i] = number - '0';
        	sum.add(Integer.toString(num[i]));
        }

        for(int i=0; i<n; i++) {
        	visit = new boolean[n];
        	visit[i] = true;
        	add(num, i, Integer.toString(num[i]));
        }
        
        for(String a : sum) {
        	answer += cal(a);
        }
        
        return answer;
    }
	
	public static void add(int[] num, int index, String number) {
		if(num.length == index) {
			return;
		}else {
			for(int i=0; i<num.length; i++) {
				if(i != index && visit[i] == false) {
					visit[i] = true;
					String n = number + Integer.toString(num[i]);
					if(n.charAt(0) != '0') {
						sum.add(n);
						add(num, i, n);
						visit[i] = false;
					}
				}
			}
		}
	}
	
	public static int cal(String s){
		int n = Integer.parseInt(s);
		
        if(n == 0) return 0;
        if(n == 1) return 0;
        
        for(int i=2; i<=Math.sqrt(n); i++){
            if(n % i == 0) return 0;
        }
        
        return 1;
            
    }
}

