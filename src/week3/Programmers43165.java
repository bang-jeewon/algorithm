/**
 * DFS - 타겟 넘버
 */
package week3;

public class Programmers43165 {
	
	public static void main(String[] args) {
		int[] numbers = {1, 1, 1, 1, 1};
		int target = 3;
		System.out.println(solution(numbers, target));
	}
	
	//dfs탐색 - 모든 경우의 수 확인
	public static int solution(int[] numbers, int target) {
		//dfs() 메소드 호출 및 값 전달
		int answer = dfs(numbers, target, 0, 0);
		return answer;
	}

	//배열 요소가 하나의 노드, 배열 인덱스가 깊이라고 생각할 수 있다. 각 깊이에 대해 모두 탐색해야 한다.
	private static int dfs(int[] numbers, int target, int sum, int i) {
		//마지막 정수까지 계산한 후
		//if(0 == 5)
		if(i == numbers.length) {
			//결과값(sum)이 target과 같다면 1을, 아니라면 0을 리턴하는 
			//if(0 == 3)
			if(sum == target) {
				return 1;
			//else(0 != 3)
			}else {
				return 0;
			}
		}
		
		int result = 0;
		//result = result + dfs({1,1,1,1,1}, 3, 0+1, 0+1); => sum에 1, i에 1값을 넘겨줌
		//result = result + dfs({1,1,1,1,1}, 3, 1+1, 1+1); => sum에 2, i에 2값을 넘겨줌
		//result = result + dfs({1,1,1,1,1}, 3, 2+1, 2+1); => sum에 3, i에 3값을 넘겨줌
		//result = result + dfs({1,1,1,1,1}, 3, 3+1, 3+1); => sum에 4, i에 4값을 넘겨줌
		//result = result + dfs({1,1,1,1,1}, 3, 4+1, 4+1); => sum에 5, i에 5값을 넘겨줌 => sum(5) != target(3) sum과 target이 불일치하므로 return 0;
		result += dfs(numbers, target, sum+numbers[i], i+1); // + 연산  => 재귀호출
		//result = result + dfs({1,1,1,1,1}, 3, 0-1, 0+1); => sum에 -1, i에 1값을 넘겨줌
		//result = result + dfs({1,1,1,1,1}, 3, -1-1, 1+1); => sum에 -2, i에 2값을 넘겨줌
		//result = result + dfs({1,1,1,1,1}, 3, -2-1, 2+1); => sum에 -3, i에 3값을 넘겨줌
		//result = result + dfs({1,1,1,1,1}, 3, -3-1, 3+1); => sum에 -4, i에 4값을 넘겨줌
		//result = result + dfs({1,1,1,1,1}, 3, -4-1, 4+1); => sum에 -5, i에 5값을 넘겨줌 => sum(-5) != target(3) sum과 target이 불일치하므로 return 0;
		result += dfs(numbers, target, sum-numbers[i], i+1); // - 연산  => 재귀호출
		return result;
	}
	
}
