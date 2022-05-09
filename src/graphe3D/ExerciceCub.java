package graphe3D;

import java.awt.Graphics;

public class ExerciceCub {

	public ExerciceCub() {
		// TODO Auto-generated constructor stub
	}
	public int[][] doubleToInt(double T[][]){
		int MT[][]= new int[10][4];
		for(int i = 0;i<T.length;i++) {
			for(int j = 0; j<T[i].length;j++) {
				MT[i][j] = (int) (T[i][j]*100);
			}
		}
		 return MT;
		
	}
	public void extraction(int T[][],int TX[],int TY[]) {
		for(int i = 0;i<10;i++) {
		  
			 TX[i] = T[i][0];
			 TY[i] = T[i][1];
			
		}
	}
	
	public void tracer(int TX[],int TY[],Graphics  g) {
		//A------->B
		g.drawLine(TX[0]+320,240-TY[0],TX[1]+320,240-TY[1]);
		//B------->C
		g.drawLine(TX[1]+320,240-TY[1],TX[2]+320,240-TY[2]);
		//C------->D
		g.drawLine(TX[2]+320,240-TY[2],TX[3]+320,240-TY[3]);
		//D------->A
		g.drawLine(TX[3]+320,240-TY[3],TX[0]+320,240-TY[0]);
		//E------->F
		g.drawLine(TX[4]+320,240-TY[4],TX[5]+320,240-TY[5]);
		//F------->G
		g.drawLine(TX[5]+320,240-TY[5],TX[6]+320,240-TY[6]);
		//E------->H
		g.drawLine(TX[4]+320,240-TY[4],TX[7]+320,240-TY[7]);
		//H------->I
		g.drawLine(TX[7]+320,240-TY[7],TX[8]+320,240-TY[8]);
		//I------->G
		g.drawLine(TX[8]+320,240-TY[8],TX[6]+320,240-TY[6]);
		//G------->K
		g.drawLine(TX[6]+320,240-TY[6],TX[9]+320,240-TY[9]);
		//K------->I
		g.drawLine(TX[9]+320,240-TY[9],TX[8]+320,240-TY[8]);
		//A------->E
		g.drawLine(TX[0]+320,240-TY[0],TX[4]+320,240-TY[4]);
		//B------->F
		g.drawLine(TX[1]+320,240-TY[1],TX[5]+320,240-TY[5]);
		//D------->H
		g.drawLine(TX[3]+320,240-TY[3],TX[7]+320,240-TY[7]);
		//C------->K
		g.drawLine(TX[2]+320,240-TY[2],TX[9]+320,240-TY[9]);
		
		
		g.drawString("A",TX[0]+320+6,240-TY[0]);
		g.drawString("B",TX[1]+320+6,240-TY[1]);
		g.drawString("C",TX[2]+320,240-TY[2]);
		g.drawString("D",TX[3]+320,240-TY[3]);
		g.drawString("E",TX[4]+320,240-TY[4]);
		g.drawString("F",TX[5]+320,240-TY[5]);
		g.drawString("G",TX[6]+320,240-TY[6]);
		g.drawString("H",TX[7]+320,240-TY[7]);
		g.drawString("I",TX[8]+320,240-TY[8]);
		g.drawString("K",TX[9]+320,240-TY[9]);
	}
}
