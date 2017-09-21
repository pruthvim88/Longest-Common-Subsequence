import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class LCS{
	
	public static void main (String [] args) throws IOException{
		FileReader f = new FileReader("input.txt");
		BufferedReader br = new BufferedReader(f);
		String text1 ="";
		String text2 = "";
		text1 = br.readLine();
		text2 = br.readLine();
		char[] A = text1.toCharArray();
		char[] B = text2.toCharArray();
		PrintWriter pw = new PrintWriter("output.txt");
		leastCommonSubsequence(A,B,pw);
		br.close();
	    f.close();
	    pw.close();
	}
		
	public static void leastCommonSubsequence(char [] A, char [] B, PrintWriter pw) throws IOException{
		int [][] result = new int [A.length+1] [B.length+1];
		int [][] count = new int [A.length+1] [B.length+1];
		for (int j = 0; j <= B.length; j++ ){
			count [0][j] = 0;
		}
		for (int i = 1; i <= A.length; i++ ){
			count [i][0] = 0;
			for (int j = 1; j <= B.length; j++ ){
				if (A[i-1] == B [j-1]){
					count [i][j] = count [i-1] [j-1] + 1;
					result [i][j] = 0;
				}
				else if (count [i][j-1] >= count [i-1] [j]){
					count [i][j] = count [i] [j-1] ;
					result [i][j] = -1;
				}
				else {
					count [i][j] = count [i-1] [j] ;
					result [i][j] = 1;
				}
			}
		}
		int l = A.length;
		int m = B.length;
		String S="";
		while (l>0 & m>0){
			if(result [l][m] == 0){
				S = A[l-1]+S;
				l = l-1;
				m = m-1;
			}
			else if(result [l][m] == 1){
				l = l-1;
			}
			else{
				m = m-1;
			}
		}
		pw.println(S.length());
		pw.println(S);
		
	}
}
