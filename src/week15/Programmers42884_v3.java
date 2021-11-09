/**
 * 탐욕법 - 단속카메라
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
        // 차량의 나간 지점을 기준으로 오름차순 정렬
        Arrays.sort(routes, ((o1, o2) -> Integer.compare(o1[1], o2[1])));
//        System.out.println(Arrays.deepToString(routes));  // [[-20, -15], [-18, -13], [-14, -5], [-5, -3]]
        
        int answer = 0;
        int camera = -30000;

        for(int[] route: routes) {
            if(route[0] > camera) { // 차량의 진입 지점이 카메라 설치 지점보다 앞에 있으면
                camera = route[1]; // 해당 차량의 나간 지점에 카메라 설치
                answer += 1;
            }
        }
        return answer;
    }

}
