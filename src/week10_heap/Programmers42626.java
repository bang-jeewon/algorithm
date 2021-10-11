/**
 * 힙 - 더 맵게
 */
package week10;

import java.util.PriorityQueue;

public class Programmers42626 {

	public static void main(String[] args) {
		int[] scoville = {1, 2, 3, 9, 10, 12};
//		int[] scoville = {3};
		int k = 7;
		
		System.out.println(solution(scoville, k));
	}
	
	public static int solution(int[] scoville, int k) {
		PriorityQueue<Integer> q = new PriorityQueue<>();
		
		for(int s : scoville) {
			q.add(s);
		}
//		System.out.println(q); //[1, 2, 3, 9, 10, 12]
//		System.out.println(q.peek()); //1
		
//		q.add(11);
//		System.out.println(q); //[1, 2, 3, 9, 10, 12, 11]  -> 정렬 안됨
		
        int answer = 0;
        while(q.peek() < k) {
        	if(q.size() == 1){ // 우선순위 q에 값이 하나밖에 없을 경우, 스코빌 지수 식을 사용할 수 없다
        		return -1; 
        	}
        	answer++;
        	
			int q1 = q.poll();
			int q2 = q.poll();
				
			int qq = q1 + (q2 * 2);
			q.add(qq);
			System.out.println(q);
			/* [3, 5, 10, 12, 9]
			   [9, 12, 10, 13] */
		}
        return answer;
    }

}
