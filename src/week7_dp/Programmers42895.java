/**
 * ������ȹ��(DP) - N���� ǥ��
 */
package week7;

public class Programmers42895 {

	static int answer= -1;
	public static void main(String[] args) {
		int answer=solution(5,12);
		System.out.println(answer);
	}

	public static int solution(int N, int number) {
		logic(N,number,0,0);
		return answer;
	}
	//n=5/number=12/count=0/calc=0
	//55
	public static void logic(int n,int number,int count,int calc) {
		int nn=n;
		
		if(calc==number) {
			if(answer>count || answer == -1) {
				answer=count;
				return;
			}
		}
		
		//dfs�� ���� ��Ģ���� ���̸��� ����.
		//ex ) 2,11 �Է¹��� �� 2,count=1 �� �����ؼ� count=9 �� �� ���� ������ ���� ��
		// ������ 9�� �������� ��� 2�� ���� ���� ���� ���� �� ���� ������ �Ѿ
		//22�� �����Ͽ� ���� for������ ���� ��Ģ������ ������ ������ ��������
		// �ߺ��� ����  ��Ģ���� ����
		//5 dfs
		//5 => 55
		//55+5/5*5
		//5+5 i==1
		//5+55 i==2
		//5+555 i==3 5+55+55+5*555*
		for(int i=1;i<9-count;i++) {
			logic(n,number,count+i,nn+calc);
			logic(n,number,count+i,nn*calc);
			logic(n,number,count+i,nn-calc);
			logic(n,number,count+i,calc/nn);
			nn=nn*10+n;
		}
	}

}
