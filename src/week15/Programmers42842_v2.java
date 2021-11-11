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
		int[] answer = new int[2];
		
		ArrayList<Integer> as = new ArrayList<>();
		
		int a = brown + yellow;
		for(int i = 1; i <= a; i++) {
			if((a % i) == 0) {
				as.add(i); // brown + yellow 값의 약수 구하기
			}
		}
		
		int len = as.size(); // 약수 총 개수
//		for(int i = 1; i <= (len - 1) / 2; i++) {
//			if(as.get(len - 1 - i) * 2 + (as.get(i) - 2) * 2 == brown) {
//				answer[0] = as.get(len - 1 - i);
//				answer[1] = as.get(i);
//				break;
//			}
//		}

		if(len % 2 == 0) {
			for(int i = len - 2; i > (len - 1) / 2; i--) {
				if(as.get(i) * 2 + (as.get(len - 1 - i) - 2) * 2 == brown) {
					answer[0] = as.get(i);
					answer[1] = as.get(len - 1 - i);
				}
			}
		}else {
			for(int i = len - 2; i >= (len - 1) / 2; i--) {
				if(as.get(i) * 2 + (as.get(len - 1 - i) - 2) * 2 == brown) {
					answer[0] = as.get(i);
					answer[1] = as.get(len - 1 - i);
				}
			}
		}
		
		return answer;
	}

}
