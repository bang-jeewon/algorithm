package week9;

import java.util.Arrays;

public class Programmers42885 {
	
	public static void main(String[] args) {
		int[] people = {70, 50, 80, 50};
		int limit = 100;
		
		System.out.println(solution(people, limit));
	}
	
	public static int solution(int[] people, int limit) {
		
		Arrays.sort(people);
//		System.out.println(Arrays.toString(people)); //[50, 50, 70, 80]
		
		int answer = 0;
		int min = 0;
		for(int i = people.length-1; i >= min; i--) {
			if(people[i] + people[min] > limit) {
				answer++;
			}else {
				min++;
				answer++;
			}
		}
        return answer;
        
    }
	
}
