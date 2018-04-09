import java.util.*;

public class TicTacToe {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String[] outputs = new String[5];
		
		for(int z=0;z<5;z++){
			char[] input = sc.nextLine().toCharArray();
			
			char[][] g = new char[3][3];
			
			int k=0;
			
			for(int i=0;i<3;i++){
				for(int j=0;j<3;j++){
					g[i][j] = input[k++];
				}
			}
			
			int xmove = 0;
			int omove = 0;
			
			for(int i=0;i<3;i++){
				int x = 0;
				int o = 0;
				for(int j=0;j<3;j++){
					if(g[i][j]=='X') x++;
					if(g[i][j]=='O') o++;
				}
				if(x==2 && o==0){
					for(int j=0;j<3;j++){
						if(g[i][j]=='B'){
							xmove = (i*3)+j+1;
						}
					}
				}
				if(o==2 && x==0){
					for(int j=0;j<3;j++){
						if(g[i][j]=='B'){
							omove = (i*3)+j+1;
						}
					}
				}
			}
			
			for(int i=0;i<3;i++){
				int x = 0;
				int o = 0;
				for(int j=0;j<3;j++){
					if(g[j][i]=='X') x++;
					if(g[j][i]=='O') o++;
				}
				if(x==2 && o==0){
					for(int j=0;j<3;j++){
						if(g[j][i]=='B'){
							xmove = (j*3)+i+1;
						}
					}
				}
				if(o==2 && x==0){
					for(int j=0;j<3;j++){
						if(g[j][i]=='B'){
							omove = (j*3)+i+1;
						}
					}
				}
			}
			
			int x=0;
			int o=0;
			
			for(int i=0;i<3;i++){
				
				if(g[i][i]=='X') x++;
				if(g[i][i]=='O') o++;
			}
			if(x==2&&o==0){
				for(int i=0;i<3;i++){
					if(g[i][i]=='B') xmove = (3*i)+i+1;
				}
			}
			if(x==0&&o==2){
				for(int i=0;i<3;i++){
					
					if(g[i][i]=='B') omove = (3*i)+i+1;
				}
			}
			
			x=0;
			o=0;
			for(int i=0;i<3;i++){
				
				if(g[i][2-i]=='X') x++;
				if(g[i][2-i]=='O') o++;
			}
			if(x==2&&o==0){
				for(int i=0;i<3;i++){
					
					if(g[i][2-i]=='B') xmove = (3*i)+(3-i);
				}
			}
			if(x==0&&o==2){
				for(int i=0;i<3;i++){
					
					if(g[i][2-i]=='B') omove = (3*i)+(3-i);
				}
			}
			
			String output = "";
			
			if(xmove==0&&omove==0){
				output+="NONE";
			}
			if(omove!=0){
				output+="O " + omove + " ";
			}
			if(xmove!=0){
				output+="X " + xmove;
			}
			outputs[z] = output;
		}
		
		sc.close();
		
		for(String s : outputs){
			System.out.println(s);
		}
	}
		
	
}
