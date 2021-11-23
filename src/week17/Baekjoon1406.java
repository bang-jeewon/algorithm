/**
 * 에디터 - 스택
 * https://www.acmicpc.net/problem/1406
 */
package study17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baekjoon1406 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		
		int n = Integer.parseInt(br.readLine());
		
		Stack<String> left = new Stack<String>();
		Stack<String> right = new Stack<String>();
		
		String[] inputs = input.split("");
		for(int i = 0; i < inputs.length; i++) {
			left.push(inputs[i]);
		}
		
		for(int i = 0; i < n; i++) {
			String cmd = br.readLine();
			char c = cmd.charAt(0);
			
			if(c == 'L' && !left.isEmpty()) { //커서가 맨 앞이면 무시
				right.push(left.pop());
			}else if(c == 'D' && !right.isEmpty()) { //커서가 맨 뒤면 무시
				left.push(right.pop());
			}else if(c == 'B' && !left.isEmpty()) {
				left.pop();
			}else if(c == 'P') {
				left.push(String.valueOf(cmd.charAt(2)));
			}
		}
		
		while(!left.isEmpty()) {
			right.push(left.pop());
		}
		
		StringBuilder sb = new StringBuilder();
		while(!right.isEmpty()) {
			sb.append(right.pop());
		}
		System.out.println(sb);
	}

}
