/**
 * 섬 연결하기 - 탐욕법(크루스칼 알고리즘, MST(최소 신장 트리))
 */
package week13;

import java.util.Arrays;

public class Programmers42861 {
	
	//각 노드의 부모
	static int[] parent;
	
	// x가 속한 집합의 부모를 찾는다. => 연결된 노드에서 가장 최상위 노드번호를 찾아가는 과정 ??
	public static int findSet(int x) {
		if(parent[x] == x) {
			return x;
		}else {
			return findSet(parent[x]);
		}
	}
	
	// x와 y를 같은 집합으로 합친다.
	public static void union(int x, int y) {
		x = findSet(x);
		y = findSet(y);
		if(x > y) {
			parent[x] = y;
		}else {
			parent[y] = x;
		}
	}
	
	public static int solution(int n, int[][] costs) {
		
		parent = new int[n];
		
		int final_cost = 0;
		
		// 비용 순으로 오름차순 정렬
		Arrays.sort(costs, (o1, o2) -> Integer.compare(o1[2], o2[2])); // 오름차순 정렬
		
		for(int i = 0; i < n; i++) {
			parent[i] = i;
		}
		
		for(int i = 0; i < costs.length; i++) {
			// 사이클이 존재하지 않는 경우에만 간선을 선택한다(최종 비용만 고려하도록 하겠음)
			if(findSet(costs[i][0]) != findSet(costs[i][1])) {
//				System.out.println("선택된 간선");
//				System.out.println(Arrays.toString(costs[i]));
				
				union(costs[i][0], costs[i][1]);
				final_cost += costs[i][2];
				
//				System.out.println("각 노드가 가리키고 있는 부모");
//				System.out.println(Arrays.toString(parent) + "\n");
				
				continue;
			}
		}
		return final_cost;
		
	}

	public static void main(String[] args) {
		int n = 4;
		int[][] costs = {{0,1,1}, {0,2,2}, {1,2,5}, {1,3,1}, {2,3,8}};
		
		System.out.println(solution(n, costs));
	}
}

/* 크루스칼 알고리즘(kruskal)
 * 	가장 적은 비용으로 모든 노드를 연결하기 위해서 사용하는 알고리즘
 * 	1. 주어진 가중치를 오름차순으로 정렬한다.
 * 	2. 그리고 낮은 가중치부터 정점을 연결(union)하면서 그래프를 만들어나간다.
 * 	3. 주의할 점은 두 정점이 이미 연결되어있다면 제외시켜주어야 한다는 것이다.
 */
