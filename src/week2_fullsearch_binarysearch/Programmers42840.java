/**
 * 완전탐색 - 모의고사
 */
package week2;

import java.util.ArrayList;

public class Programmers42840 {

	public static int[] solution(int[] answers) {
		
		int[][] supoza = {{1,2,3,4,5}, {2,1,2,3,2,4,2,5}, {3,3,1,1,2,2,4,4,5,5}};

		int[] cnt = new int[3];
		for(int i = 0; i < cnt.length; i++) {
			for(int j = 0; j < answers.length; j++) {
				if(supoza[i][j%supoza[i].length] == answers[j]) {
					cnt[i]++;
				}
			}
		}
		
		int max = Math.max(cnt[0], Math.max(cnt[1], cnt[2]));
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < cnt.length; i++) {
			if(max == cnt[i]) {
				list.add(i + 1);
			}
		}
		
		int[] answer = list.stream().mapToInt(Integer::intValue).toArray(); //ArrayList를 array배열로 바꿔주기!!

		return answer;
	}

}
