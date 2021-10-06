package week9;

import java.util.Arrays;

public class Programmers42862 {

	public static void main(String[] args) {
		int n = 5;
		int[] lost = {2, 4};
		int[] reserve = {1, 3, 5};
		
		System.out.println(solution(n, lost, reserve));
	}
	
	public static int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
//        System.out.println(answer); //3
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
//        System.out.println(Arrays.toString(lost)); //[2, 4]
//        System.out.println(Arrays.toString(reserve)); //[1, 3, 5]
        
        for(int i = 0; i < lost.length; i++) {
        	for(int j = 0; j < reserve.length; j++) {
        		if(lost[i] == reserve[j]) { //�Ҿ���� �л��� ���� ü���� ��������
        			answer++;
        			lost[i] = -1;
        			reserve[j] = -1;
        			break;
        		}
        	}
        }
//        System.out.println(answer); //3
//        System.out.println(Arrays.toString(lost)); //[2, 4]
//        System.out.println(Arrays.toString(reserve)); //[1, 3, 5]
        
        for(int i = 0; i < lost.length; i++) {
        	for(int j = 0; j < reserve.length; j++) {
        		
        		if(lost[i] == -1) continue;
        		if(reserve[j] == -1) continue;
        		
        		if((lost[i]-1 == reserve[j]) || (lost[i]+1 == reserve[j])) { //�翷��ȣ ģ���� ������ ���� ���
        			answer++;
        			reserve[j] = -1;
        			break;
        		}
        	}
        }
//        System.out.println(answer); //5
//        System.out.println(Arrays.toString(lost)); //[2, 4]
//        System.out.println(Arrays.toString(reserve)); //[-1, -1, 5]
        
        return answer;
    }

}
