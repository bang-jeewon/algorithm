/**
 * 단어 변환 - dfs/bfs
 * https://programmers.co.kr/learn/courses/30/lessons/43163
 * https://url.kr/uyei3p
 */
package study16;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Node{
	String word;
	int cnt;
	
	Node(String word, int cnt){
		this.word = word;
		this.cnt = cnt;
	}
}

public class Programmers43163_v2 {
	
	public static void main(String[] args) {
		String begin = "hit";
		String target = "cog";
		
//		String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
		String[] words = {"hot", "dot", "dog", "lot", "log"};
		
		System.out.println(solution(begin, target, words));
	}
	
	public static int solution(String begin, String target, String[] words) {
		
		Queue<Node> que = new LinkedList<>();
		boolean[] visited = new boolean[words.length];
		
		que.offer(new Node(begin, 0));
		
		while(!que.isEmpty()) {
			Node node = que.poll();
			
			if(node.word.equals(target)) {
				return node.cnt;
			}
			
			for(int i = 0; i < words.length; i++) {
				if(visited[i]) {
					continue;
				}
				if(changeable(node.word, words[i])) {
					que.offer(new Node(words[i], node.cnt + 1));
					visited[i] = true;
				}
			}
		}
		return 0;
	}
	
	public static boolean changeable(String from, String to) {
		int diff = 0;
		
		for(int i = 0; i < to.length(); i++) {
			if(from.charAt(i) != to.charAt(i)) {
				diff++;
			}
		}
		
		if(diff == 1) {
			return true;
		}
		return false;
	}

}
