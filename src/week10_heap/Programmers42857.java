/**
 * 스택/큐 - 프린터
 */
package week10;

import java.util.Collections;
import java.util.PriorityQueue;

public class Programmers42857 {

	public static void main(String[] args) {
//		int[] priorities = {2, 1, 3, 2};
//		int location = 2;
		int[] priorities = {1, 1, 9, 1, 1, 1};
		int location = 0;
		
		System.out.println(solution(priorities, location));
	}
	
	public static int solution(int[] priorities, int location) {
		PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
		int answer = 0;
		
		for(int p : priorities) {
			q.add(p);
		}
//		System.out.println(q); //[3, 2, 2, 1] [9, 1, 1, 1, 1, 1]
//		System.out.println(q.peek()); //3 9
		
		while(!q.isEmpty()) {
			for(int i = 0; i < priorities.length; i++) {
				if(q.peek() == priorities[i]) {
					if(i == location) {
						answer++;
						return answer;
					}
					q.poll();
					answer++;
				}
			}
		}
        return -1;
    }

}
