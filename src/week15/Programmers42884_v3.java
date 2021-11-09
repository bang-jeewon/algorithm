/**
 * Ž��� - �ܼ�ī�޶�
 * https://programmers.co.kr/learn/courses/30/lessons/42884
 * https://wellbell.tistory.com/77
 */
package study15;

import java.util.Arrays;

public class Programmers42884_v3 {

	public static void main(String[] args) {
		int[][] routes = {{-20, -15}, {-14, -5}, {-18, -13}, {-5, -3}};
		
		System.out.println(solution(routes));
	}
	
	public static int solution(int[][] routes) {
        // ������ ���� ������ �������� �������� ����
        Arrays.sort(routes, ((o1, o2) -> Integer.compare(o1[1], o2[1])));
//        System.out.println(Arrays.deepToString(routes));  // [[-20, -15], [-18, -13], [-14, -5], [-5, -3]]
        
        int answer = 0;
        int camera = -30000;

        for(int[] route: routes) {
            if(route[0] > camera) { // ������ ���� ������ ī�޶� ��ġ �������� �տ� ������
                camera = route[1]; // �ش� ������ ���� ������ ī�޶� ��ġ
                answer += 1;
            }
        }
        return answer;
    }

}
