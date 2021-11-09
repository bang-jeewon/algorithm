/**
 * 유기농 배추 - dfs/bfs
 * https://www.acmicpc.net/problem/1012
 */
package study15;

import java.util.Scanner;

public class Baekjoon1012_v2 {
	
	static int width, height, m, count;
	static int[][] map;
	static boolean[][] visited;
	
	static int dx[] = {0, -1, 0, 1};
	static int dy[] = {-1, 0, 1, 0};
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		StringBuilder sb = new StringBuilder(); // testcase마다 답을 저장하기 위해소
		
		for(int i = 0; i < n; i++) {
			width = scan.nextInt();
			height = scan.nextInt();
			m = scan.nextInt();
			map = new int[height][width];
			visited = new boolean[height][width];
			count = 0;
			
			for(int j = 0; j < m; j++) {
				int x = scan.nextInt();
				int y = scan.nextInt();
				map[y][x] = 1;
			}
			
			for(int j = 0; j < height; j++) {
				for(int k = 0; k < width; k++) {
					if(map[j][k] == 1 && !visited[j][k]) {
						dfs(j, k);
						count++;
					}
				}
			}
			sb.append(count + "\n");
		}
		scan.close();
		System.out.println(sb);
	}
	
	public static void dfs(int j, int k) {
		visited[j][k] = true;
		for(int i = 0; i < 4; i++) {
			int nx = k + dx[i];
			int ny = j + dy[i];
			
			if(nx >= 0 && ny >= 0 && nx < width && ny < height) {
				if(map[ny][nx] == 1 && !visited[ny][nx]) {
					dfs(ny, nx);
				}
			}
		}
	}

}
