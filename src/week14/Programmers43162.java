/**
 * 프로그래머스 - 네트워크
 * https://programmers.co.kr/learn/courses/30/lessons/43162
 * https://velog.io/@ajufresh/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EB%84%A4%ED%8A%B8%EC%9B%8C%ED%81%AC-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4-Java
 */
package week14;

public class Programmers43162 {

    public static void main(String[] args) {
        int n = 3;
        int[][] computers = {{1,1,0}, {1,1,0}, {0,0,1}};

        System.out.println(solution(n, computers));
    }

    public static int solution(int n, int[][] computers){
        int answer = 0;
        boolean[] visited = new boolean[n];
        
        for(int i = 0; i < n; i++) {
        	if(!visited[i]) {
        		dfs(computers, i, visited);
        		answer++;
        	}
        }
        return answer;
    }
    
    public static boolean[] dfs(int[][] computers, int i, boolean[] visited) {
    	visited[i] = true;
    	
    	for(int j = 0; j < computers.length; j++) {
    		if(i != j && computers[i][j] == 1 && visited[j] == false) {
    			visited = dfs(computers, j, visited);
    		}
    	}
    	return visited;
    }

}
