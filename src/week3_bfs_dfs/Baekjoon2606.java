/**
 * BFS - 바이러스
 */
package week3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon2606 {
	
	static int arr[][];       //그래프 배열
	static boolean visited[];  //방문 확인하는 배열
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int node = scan.nextInt(); //컴퓨터의 수
		int line = scan.nextInt(); //네트워크 상에 연결돼 있는 컴퓨터 쌍의 수. 즉 간선의 수
		
		arr = new int[node+1][node+1];   //각 컴퓨터간 연결 여부를 저장할 배열. 행렬?
		visited = new boolean[node+1]; //컴퓨터의 탐색 여부 확인
		
		for(int i = 1; i <= line; i++) { //그래프 구성. 인접행렬??
			int a = scan.nextInt();
			int b = scan.nextInt();
			arr[a][b] = 1; //컴퓨터 노드마다 연결
			arr[b][a] = 1; //컴퓨터 노드마다 연결
		}
		System.out.println(bfs(1)); //1번 컴퓨터에 연결된 모~~~든 컴퓨터(노드)의 개수를 찾으면 된다
		scan.close();
	}
	
	static int bfs(int start) { // BFS메소드
		
		Queue<Integer> que = new LinkedList<>();
		
		visited[start] = true;
		
		que.offer(start);
		
		int cnt = 0; //감염된 컴퓨터의 수
		while(!que.isEmpty()) {
			int x = que.poll(); //큐에서 첫번째 값을 반환하고 제거. 반환한 1을 변수 x에 담아줌
			
			for(int i = 1; i < arr.length; i++) { //차례대로 1번과 연결된 컴퓨터들을 찾아 cnt변수 증가
				//if(node[1][2] == 1 && check[2] !=1) => (1,2)행렬의 컴퓨터 바이러스~~~~~ => if 조건문 충족
				//if(node[1][1] == 1 && check[1] !=1) => node[1][1]이 1이 아니므로 해당없음. i증가
				//노드가 연결돼있고, 방문한 노드라면
				if(arr[x][i] == 1 && visited[i] !=true ) {
					que.offer(i); //que.offer(2); => 큐에 2를 넣어줌
					visited[i] = true; //방문했다고 true
					cnt++; //연결된 바이러스 걸리는 컴퓨터의 수
				}
			}
		}
		return cnt;
	}

}
