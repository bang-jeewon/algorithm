package week14;

import java.util.Arrays;

public class Programmers42747 {

    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};

        System.out.println(solution(citations));
    }

    public static int solution(int[] citations){

        int n = citations.length;
        int answer = 0;
        
        Arrays.sort(citations);

        for(int i = n-1; i >= 0; i--) {
        	if(citations[i] > answer) {
        		answer++;
        	}else {
        		break;
        	}
        }

        return answer;
    }

}
