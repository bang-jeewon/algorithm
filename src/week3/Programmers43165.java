/**
 * DFS - Ÿ�� �ѹ�
 */
package week3;

public class Programmers43165 {
	
	public static void main(String[] args) {
		int[] numbers = {1, 1, 1, 1, 1};
		int target = 3;
		System.out.println(solution(numbers, target));
	}
	
	//dfsŽ�� - ��� ����� �� Ȯ��
	public static int solution(int[] numbers, int target) {
		//dfs() �޼ҵ� ȣ�� �� �� ����
		int answer = dfs(numbers, target, 0, 0);
		return answer;
	}

	//�迭 ��Ұ� �ϳ��� ���, �迭 �ε����� ���̶�� ������ �� �ִ�. �� ���̿� ���� ��� Ž���ؾ� �Ѵ�.
	private static int dfs(int[] numbers, int target, int sum, int i) {
		//������ �������� ����� ��
		//if(0 == 5)
		if(i == numbers.length) {
			//�����(sum)�� target�� ���ٸ� 1��, �ƴ϶�� 0�� �����ϴ� 
			//if(0 == 3)
			if(sum == target) {
				return 1;
			//else(0 != 3)
			}else {
				return 0;
			}
		}
		
		int result = 0;
		//result = result + dfs({1,1,1,1,1}, 3, 0+1, 0+1); => sum�� 1, i�� 1���� �Ѱ���
		//result = result + dfs({1,1,1,1,1}, 3, 1+1, 1+1); => sum�� 2, i�� 2���� �Ѱ���
		//result = result + dfs({1,1,1,1,1}, 3, 2+1, 2+1); => sum�� 3, i�� 3���� �Ѱ���
		//result = result + dfs({1,1,1,1,1}, 3, 3+1, 3+1); => sum�� 4, i�� 4���� �Ѱ���
		//result = result + dfs({1,1,1,1,1}, 3, 4+1, 4+1); => sum�� 5, i�� 5���� �Ѱ��� => sum(5) != target(3) sum�� target�� ����ġ�ϹǷ� return 0;
		result += dfs(numbers, target, sum+numbers[i], i+1); // + ����  => ���ȣ��
		//result = result + dfs({1,1,1,1,1}, 3, 0-1, 0+1); => sum�� -1, i�� 1���� �Ѱ���
		//result = result + dfs({1,1,1,1,1}, 3, -1-1, 1+1); => sum�� -2, i�� 2���� �Ѱ���
		//result = result + dfs({1,1,1,1,1}, 3, -2-1, 2+1); => sum�� -3, i�� 3���� �Ѱ���
		//result = result + dfs({1,1,1,1,1}, 3, -3-1, 3+1); => sum�� -4, i�� 4���� �Ѱ���
		//result = result + dfs({1,1,1,1,1}, 3, -4-1, 4+1); => sum�� -5, i�� 5���� �Ѱ��� => sum(-5) != target(3) sum�� target�� ����ġ�ϹǷ� return 0;
		result += dfs(numbers, target, sum-numbers[i], i+1); // - ����  => ���ȣ��
		return result;
	}
	
}
