/**
 * DFS, BFS - DFS와 BFS
 */
package week3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baekjoon1260 {
	
	public static int[][] arr; //2차원 배열. 인접행렬.
	public static boolean[] visited; //노드 방문 여부 visited
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int node = scan.nextInt();  //node수
		int line = scan.nextInt();  //간선 수
		int start = scan.nextInt(); //시작할 node
		
		arr = new int[node+1][node+1];
		visited = new boolean[node+1];
		
		for(int i = 1; i <= line; i++) {
			int a = scan.nextInt();
			int b = scan.nextInt();
			//인접행렬 : 노드와 간선의 관계도를 이차원 배열로 표현한 것. 시간복잡도를 줄일 수 있다는 장점이 있음.
			arr[a][b] = 1;
			arr[b][a] = 1;
		}
		
		//visited는 왜 여기서 생성하는거지?? 왜 두번씩 생성하는거지??
		visited = new boolean[node+1];
		dfs(start);
		System.out.println();
		
		visited = new boolean[node+1];
		bfs(start);
		
		scan.close();
	}
	
	private static void dfs(int start) {
		visited[start] = true; //처음 시작하는 노드는 방문한거니까, true로 초기화해줌
		System.out.print(start + " ");
		
		if(start == arr.length) {
			return;
		}
		
		for(int i = 1; i < arr.length; i++) {
			//start노드와 비교했을 때 연결되어있고 && 방문하지 않은 노드일 경우, 
			if(arr[start][i] == 1 && visited[i] == false) {
				//그 노드번호(i)를 dfs에 다시 넣어줘서 인접행렬 끝까지 i노드와 연결되어 있는 노드를 다시 탐색하여 sysout(i + " ")으로 출력될 수 있도록 구현 => 재귀호출
				dfs(i);
			}
		}
	}
	
	private static void bfs(int start) {
		Queue<Integer> que = new LinkedList<Integer>();
		que.add(start);
		
		visited[start] = true; //처음 시작하는 노드는 방문한거니까, true로 초기화해줌
		System.out.print(start + " ");
		
		while(!que.isEmpty()) {
//			int temp = que.peek();
			int temp = que.poll();
			for(int i = 1; i < arr.length; i++) {
				if(arr[start][i] == 1 && visited[i] == false) {  //여기를 확인 안해줬음!!
					que.add(i);
					visited[i] = true; //방문했다고 도장찍고
					System.out.print(i + " "); //i노드값 출력될 수 있도록 구현
				}
			}
		}
	}

}
