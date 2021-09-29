/**
 * 다익스트라 - 배달
 */
package study8;

import java.util.Arrays;

public class Programmers12978 {

	public static void main(String[] args) {
		int n = 5; //마을의 개수
		int[][] road = {{1,2,1}, {2,3,3}, {5,2,2}, {1,4,2}, {5,3,1}, {5,4,2}};
		int k = 3; //3시간 이하
		
//		int n = 6; //마을의 개수
//		int[][] road = {{1,2,1}, {1,3,2}, {2,3,2}, {3,4,3}, {3,5,2}, {3,5,3}, {5,6,1}};
//		int k = 4; //4시간 이하
		
		System.out.println(solution(n, road, k));
	}
	
	public static int solution(int n, int[][] road, int k) {
		int answer = 0;
		int[][] order = new int[n][n];
//		System.out.println(Arrays.deepToString(order));
		
		for(int i = 0; i < road.length; i++) {
			int a = road[i][0] - 1; // a = 0 1 4 0 4 4
			int b = road[i][1] - 1; // b = 1 2 1 3 2 3
			
//			if(order[a][b] != 0) {
//				order[a][b] = road[i][2] < order[a][b] ? road[i][2] : order[a][b];
//				order[b][a] = road[i][2] < order[b][a] ? road[i][2] : order[b][a];
//			}else {
				order[a][b] = road[i][2];
				order[b][a] = road[i][2];
//			}
		}
//		System.out.println(Arrays.deepToString(order)); // [[0, 1, 0, 2, 0], [1, 0, 3, 0, 2], [0, 3, 0, 0, 1], [2, 0, 0, 0, 2], [0, 2, 1, 2, 0]]
		
		int distance[] = new int[n]; // 각각 노드까지 최단거리가 저장됨
		boolean visited[] = new boolean[n]; // 노드 방문
		
		for(int i = 0; i < n; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
//		System.out.println(Integer.MAX_VALUE); // 2147483647
//		System.out.println(Arrays.toString(distance)); // [2147483647, 2147483647, 2147483647, 2147483647, 2147483647]
		
		distance[0] = 0;
		visited[0] = true;
		
		for(int i = 0; i < n; i++) {
			if(!visited[i] && order[0][i] != 0) { //방문한적이 없고, order가 0이 아닐경우
				distance[i] = order[0][i];
			}
		}
//		System.out.println(Arrays.toString(distance)); // [0, 1, 2147483647, 2, 2147483647]
//		System.out.println(Arrays.toString(visited)); // [true, false, false, false, false]
		
		for(int a = 0; a < n-1; a++) {
			int min_distance = Integer.MAX_VALUE; // 2147483647
			int min_index = 0;
			
			//최솟값 찾기
			for(int i = 0; i < n; i++) {
				if(!visited[i] && min_distance > distance[i]) { //방문한적이 없고, (0, 1, 2)일 경우
					min_distance = distance[i];
					min_index = i;
				}
			}
//			System.out.println(min_distance); // 1 2 3 4
//			System.out.println(min_index); // 1 3 4 2
			
			visited[min_index] = true;
			for(int i = 0; i < n; i++) {
				if(!visited[i] && order[min_index][i] != 0) {
					if(distance[i] > distance[min_index] + order[min_index][i]) {
						distance[i] = distance[min_index] + order[min_index][i];
					}
				}
			}
		}
		
		for(int i = 0; i < distance.length; i++) {
			if(distance[i] <= k) {
				answer++;
			}
		}
		
		return answer;
	}

}
