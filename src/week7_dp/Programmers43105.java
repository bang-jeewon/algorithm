/**
 * 동적계획법 - 정수삼각형
 */
package week7;

public class Programmers43105 {

	public static void main(String[] args) {
		int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
		System.out.println(solution(triangle));
	}
	
	public static int solution(int[][] triangle) {
		
		for(int i = 1; i < triangle.length; i++) {
			triangle[i][0] += triangle[i-1][0];
			
			triangle[i][i] += triangle[i-1][i-1];
			
			for(int j = 1; j< i; j++) {
				triangle[i][j] += Math.max(triangle[i-1][j-1], triangle[i-1][j]);
			}
		}
		
		int answer = 0;
		for(int i = 0; i < triangle[triangle.length-1].length; i++) {
			answer = Math.max(triangle[triangle.length-1][i], answer);
		}
		return answer;
		
	}

}
