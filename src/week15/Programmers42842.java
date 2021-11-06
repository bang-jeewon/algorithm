/**
 * 완전탐색, 약수 - 카펫
 * https://programmers.co.kr/learn/courses/30/lessons/42842
 */
package study15;

import java.util.ArrayList;

public class Programmers42842 {

	public static void main(String[] args) {
//		int brown = 10;
//		int yellow = 2;
//		
		int brown = 8;
		int yellow = 1;
//		
//		int brown = 24;
//		int yellow = 24;
		
		int[] answer = solution(brown, yellow);
		for(int a : answer) {
			System.out.println(a);
		}
	}
	
	public static int[] solution(int brown, int yellow) {
		int[] answer = new int[2];  //int[] 로 하면 내림차순 정렬이 안된다고?
		
		ArrayList<Integer> as = new ArrayList<>();
		
		int a = brown + yellow;
		for(int i = 1; i <= a; i++) {
			if((a % i) == 0) {
				as.add(i);
			}
		}
		
		if(as.size() % 2 == 0) {
			for(int i = 1; i <= (as.size() - 1) / 2; i++) {
				if(as.get(as.size() - 1 - i) * 2 + (as.get(i) - 2) * 2 == brown) {
					answer[0] = as.get(as.size() - 1 - i);
					answer[1] = as.get(i);
					break;
				}
			}
		}else {
			for(int i = 1; i <= (as.size() - 1) / 2; i++) {
				if(as.get(as.size() - 1 - i) * 2 + (as.get(i) - 2) * 2 == brown) {
					answer[0] = as.get(as.size() - 1 - i);
					answer[1] = as.get(i);
				}
			}
		}
		
		return answer;
	}

}
