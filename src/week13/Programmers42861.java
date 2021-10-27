/**
 * �� �����ϱ� - Ž���(ũ�罺Į �˰���, MST(�ּ� ���� Ʈ��))
 */
package week13;

import java.util.Arrays;

public class Programmers42861 {
	
	//�� ����� �θ�
	static int[] parent;
	
	// x�� ���� ������ �θ� ã�´�. => ����� ��忡�� ���� �ֻ��� ����ȣ�� ã�ư��� ���� ??
	public static int findSet(int x) {
		if(parent[x] == x) {
			return x;
		}else {
			return findSet(parent[x]);
		}
	}
	
	// x�� y�� ���� �������� ��ģ��.
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
		
		// ��� ������ �������� ����
		Arrays.sort(costs, (o1, o2) -> Integer.compare(o1[2], o2[2])); // �������� ����
		
		for(int i = 0; i < n; i++) {
			parent[i] = i;
		}
		
		for(int i = 0; i < costs.length; i++) {
			// ����Ŭ�� �������� �ʴ� ��쿡�� ������ �����Ѵ�(���� ��븸 ����ϵ��� �ϰ���)
			if(findSet(costs[i][0]) != findSet(costs[i][1])) {
//				System.out.println("���õ� ����");
//				System.out.println(Arrays.toString(costs[i]));
				
				union(costs[i][0], costs[i][1]);
				final_cost += costs[i][2];
				
//				System.out.println("�� ��尡 ����Ű�� �ִ� �θ�");
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

/* ũ�罺Į �˰���(kruskal)
 * 	���� ���� ������� ��� ��带 �����ϱ� ���ؼ� ����ϴ� �˰���
 * 	1. �־��� ����ġ�� ������������ �����Ѵ�.
 * 	2. �׸��� ���� ����ġ���� ������ ����(union)�ϸ鼭 �׷����� ��������.
 * 	3. ������ ���� �� ������ �̹� ����Ǿ��ִٸ� ���ܽ����־�� �Ѵٴ� ���̴�.
 */
