package graphe3D;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Line2D;

import javax.swing.JLabel;

public class Cub3D {

	public Cub3D() {
		// TODO Auto-generated constructor stub
	}
	//transformation en int et multiplier par 100
	public int[][] doubleToInt(double T[][]){
		int MT[][]= new int[8][4];
		for(int i = 0;i<T.length;i++) {
			for(int j = 0; j<T[i].length;j++) {
				MT[i][j] = (int) (T[i][j]*100);
			}
		}
		 return MT;
		
	}
	//roper 
	 public void reper(Graphics g) {
		 Graphics2D g2 = (Graphics2D) g;
		 g2.draw ((Shape) new Line2D.Double(0,240,640,240));
		g2.draw ((Shape) new Line2D.Double(320,0,320,480));
	 }
	
	public void extraction(int T[][],int TX[],int TY[]) {
		for(int i = 0;i<8;i++) {
		  
			 TX[i] = T[i][0];
			 TY[i] = T[i][1];
			
		}
	}
	
	//projection cavalier 
	public  double[][] projectionCavalier( double M[][]){
		 double T[][] ={{1,0,0,0},
					    {0,1,0,0},
					    {0.5*(Math.sqrt(2)/2),0.5*(Math.sqrt(2)/2),0,0},
					    {0,0,0,1}};
		
		 double MT[][] = null;
		try {
			MT = ProuduitMatriciel.produit(M, T);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return MT;
		
	}

	//ROTAION PARAPOR OU LAX Z
	public  double[][] translationXYZ( double M[][] ,int X,int Y,int Z){
		 double T[][] ={{1,0,0,0},
						{0,1,0,0},
						{0,0,1,0},
						{X,Y,Z,1}};
		 double MT[][] = null;
		try {
			MT = ProuduitMatriciel.produit(M, T);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return MT;
		
	}
	
	public  double[][] rotaionZ( double M[][]){
		 double R[][] ={{-1,0,0,0},
						{0,1,0,0},
						{0,0,-1,0},
						{0,0,0,1}};
		 double TI[][] =  {{1,0,0,0},
						{0,1,0,0},
						{0,0,1,0},
						{-200,0,0,1}}; 
		 double T[][] =   {{1,0,0,0},
						{0,1,0,0},
						{0,0,1,0},
						{200,0,0,1}};
		 double MTR[][] = null;
		 double TR[][] = null;
		 double TIT[][] = null;
		try {
			TR = ProuduitMatriciel.produit(TI,R);
			TIT = ProuduitMatriciel.produit(TR,T);
			MTR = ProuduitMatriciel.produit(M,TIT);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return MTR;
		
	}
	
	public   double[][] rotaionAxeQuelquan( double M[][], double xd, double yd,double xf,double yf,double angle) {
		double pi = angle*Math.PI;
		
		 double RY[][] ={{Math.cos(pi),0,(Math.sin(pi)),0},
						{0,1,0,0},
						{(-Math.sin(pi)),0,Math.cos(pi),0},
						{0,0,0,1}};
		
		
		
		 double RX[][] ={{1,0,0,0},
				 		{0,Math.cos(pi),(Math.sin(pi)),0},
				 		{0,(-Math.sin(pi)),Math.cos(pi),0},
				 		{0,0,0,1}};
		
		
		 double RZ[][] ={{Math.cos(pi),(Math.sin(pi)),0,0},
				 		{(-Math.sin(pi)),Math.cos(pi),0,0},
				 		{0,1,0,0},
				 		{0,0,0,1}};
		
		
		
	
		 double T[][] = {{1,0,0,0},
						{0,1,0,0},
						{0,0,1,0},
						{0,-yf,0,1}};
		 double TI[][] ={{1,0,0,0},
						 {0,1,0,0},
						 {0,0,1,0},
						 {0,yf,0,1}};
		 double MTR[][] = null;
		 double TR[][] = new double[4][4];
		 double TIT[][] = new double[8][4];
		 double TITI[][] =new double[8][4];
		 try {
			TR = ProuduitMatriciel.produit(T,RX);
			TITI=ProuduitMatriciel.produit(M,TR);
			TIT = ProuduitMatriciel.produit(TITI,TI);
			//MTR = ProuduitMatriciel.produit(M,TIT);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return TIT;
	}

	public double[][] projectionPerspective( double M[][], double dist) throws Exception{
		 double MTR[][] = new  double[8][4];
		 double T[][] ={{1,0,0,0},
						{0,1,0,0},
						{0,0,0,(-1/dist)},
						{0,0,0,1}};
			 double TR[][] = null;
			 double TIT[][] = null;
			TR = ProuduitMatriciel.produit(M,T);
			for (int i=0;i<8;i++) {
				for(int j =0;j<4;j++) {
					MTR[i][j] = TR[i][j]/TR[i][3];
				}
			}
		return MTR;
	}
	//projection perspective sur un plan qlq 
	public double[][] projectionPerspectivePlanQlq( double M[][],double a,double b,double c,
					double n1,double n2,double n3,double x0,double y0,double z0)
					throws Exception{
		 double MTR[][] = new  double[8][4];
		 double d0= n1*x0+n2*y0+n3*z0;
		 double d1= n1*a+n2*b+n3*c;
		 double T[][] ={{1+(a*n1)/d0,(b*n1)/d0,(c*n1)/d0,n1/d0},
						{(a*n2)/d0,	1+(b*n2)/d0,(c*n2)/d0,n2/d0},
						{(a*n3)/d0,	(b*n3)/d0,	1+(c*n3)/d0,n3/d0},
						{-a-(a*d1)/d0,-b-(b*d1)/d0,-c-(c*d1)/d0,-(d1/d0)}};
			 double TR[][] = null;
			 double TIT[][] = null;
			TR = ProuduitMatriciel.produit(M,T);
			for (int i=0;i<8;i++) {
				for(int j =0;j<4;j++) {
					MTR[i][j] = TR[i][j]/TR[i][3];
				}
			}
		return MTR;
	}
	public  double[][] symetriqueParapporAxe( double M[][],String axe,int x,int y) throws Exception {
		//Tx les coordonnes de x et tY les coordone de y
		 double MT[][] = null;
		if(axe.equals("xy")) {
			x = 0;
			y = 0;
			 double T[][] ={{1,0,0,0},
						{0,1,0,0},
						{0,0,-1,0},
						{0,0,0,1}};
			MT = ProuduitMatriciel.produit(M,T);
			return MT;
		}
		else if(axe.equals("xz")) {
			x = 0;
			y = 0;
			 double T[][] ={{1,0,0,0},
						{0,-1,0,0},
						{0,0,1,0},
						{0,0,0,1}};
			MT = ProuduitMatriciel.produit(M,T);
			return MT;
			
		}
		else if(axe.equals("yz")) {
			x = 0;
			y = 0;
			 double T[][] ={{-1,0,0,0},
						{0,1,0,0},
						{0,0,1,0},
						{0,0,0,1}};
			MT = ProuduitMatriciel.produit(M,T);
			return MT;
		}
		else if(axe.equals("ql")) {
			 double TT[][] =  {{1,0,0,0},
							{0,1,0,0},
							{0,0,1,0},
							{-x,-y,0,1}}; 
			 double TTI[][] = {{1,0,0,0},
							{0,1,0,0},
							{0,0,1,0},
							{x,y,0,1}}; 
			 int cx = 0,cy = 0;
			 
			 if(x != 0) {
				 cx = -1;
				 cy = 1;
			 }
			 if(y != 0) {
				 cx = 1;
				 cy = -1;
			 }
			 double T[][] =  {{cx,0,0,0},
							{0,cy,0,0},
							{0,0,1,0},
							{0,0,0,1}};
			 double P[][] = null ;
			 double PR[][] = null;
			 
			 P = ProuduitMatriciel.produit(TT,T);
			 PR = ProuduitMatriciel.produit(P,TTI);
 			MT = ProuduitMatriciel.produit(M,PR);
 			
			return MT;
			
		}
		//
		return null;
	}
	public  double[][] aligne(double a,double b ,double c,double a1,double b1 ,double c1) throws Exception{
		double A = Math.sqrt(a*a+b*b+c*c);
		double B = Math.sqrt(b*b+c*c);
		 double T[][] = {{(B/A),0,(a/A),0},
						{(-(a*b)/(A*B)),(c/B),(b/A),0},
						{(-(c*a)/(A*B)),(-b/B),(c/A),0},
						{0,0,0,1}};
		 
		 double A1 = Math.sqrt(a1*a1+b1*b1+c1*c1);
		 double B1 = Math.sqrt(b1*b1+c1*c1);
		 double TI[][] = {{(B1/A1),(-(a1*b1)/(A1*B1)),(-(c1*a1)/(A1*B1)),0},
						 {0,(c1/B1),(-b1/B1),0},
						 {(a1/A1),(b1/A1),(c1/A1),0},
						 {0,0,0,1}};
		
		 double M[][] = {{a,b,c,1}};
		 double M1[][] = {{a1,b1,c1,1}};
		 double MT[][] = null;	
		 double MT1[][] = null;
		 
		MT = ProuduitMatriciel.produit(T,TI);
		MT1 = ProuduitMatriciel.produit(M,MT);
		return MT1;
		
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
		//H------->G
		g.drawLine(TX[7]+320,240-TY[7],TX[6]+320,240-TY[6]);
		//A------->E
		g.drawLine(TX[0]+320,240-TY[0],TX[4]+320,240-TY[4]);
		//B------->F
		g.drawLine(TX[1]+320,240-TY[1],TX[5]+320,240-TY[5]);
		//D------->H
		g.drawLine(TX[3]+320,240-TY[3],TX[7]+320,240-TY[7]);
		//C------->G
		g.drawLine(TX[2]+320,240-TY[2],TX[6]+320,240-TY[6]);
		
		
		g.drawString("A",TX[0]+320+6,240-TY[0]);
		g.drawString("B",TX[1]+320+6,240-TY[1]);
		g.drawString("C",TX[2]+320,240-TY[2]);
		g.drawString("D",TX[3]+320,240-TY[3]);
		g.drawString("E",TX[4]+320,240-TY[4]);
		g.drawString("F",TX[5]+320,240-TY[5]);
		g.drawString("G",TX[6]+320,240-TY[6]);
		g.drawString("H",TX[7]+320,240-TY[7]);
		
	/*	//A------->B
		g.drawLine(TX[0],TY[0],TX[1],TY[1]);
		//B------->C
		g.drawLine(TX[1],TY[1],TX[2],TY[2]);
		//C------->D
		g.drawLine(TX[2],TY[2],TX[3],TY[3]);
		//D------->A
		g.drawLine(TX[3],TY[3],TX[0],TY[0]);
		//E------->F
		g.drawLine(TX[4],TY[4],TX[5],TY[5]);
		//F------->G
		g.drawLine(TX[5],TY[5],TX[6],TY[6]);
		//E------->H
		g.drawLine(TX[4],TY[4],TX[7],TY[7]);
		//H------->G
		g.drawLine(TX[7],TY[7],TX[6],TY[6]);
		//A------->E
		g.drawLine(TX[0],TY[0],TX[4],TY[4]);
		//B------->F
		g.drawLine(TX[1],TY[1],TX[5],TY[5]);
		//D------->H
		g.drawLine(TX[3],TY[3],TX[7],TY[7]);
		//C------->G
		g.drawLine(TX[2],TY[2],TX[6],TY[6]);*/
	}
	public void tracerClor(int TX[],int TY[],Graphics  g) {
		g.setColor(Color.LIGHT_GRAY);
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
		//H------->G
		g.drawLine(TX[7]+320,240-TY[7],TX[6]+320,240-TY[6]);
		//A------->E
		g.drawLine(TX[0]+320,240-TY[0],TX[4]+320,240-TY[4]);
		//B------->F
		g.drawLine(TX[1]+320,240-TY[1],TX[5]+320,240-TY[5]);
		//D------->H
		g.drawLine(TX[3]+320,240-TY[3],TX[7]+320,240-TY[7]);
		//C------->G
		g.drawLine(TX[2]+320,240-TY[2],TX[6]+320,240-TY[6]);
		
		
		g.drawString("A",TX[0]+320+6,240-TY[0]);
		g.drawString("B",TX[1]+320+6,240-TY[1]);
		g.drawString("C",TX[2]+320,240-TY[2]);
		g.drawString("D",TX[3]+320,240-TY[3]);
		g.drawString("E",TX[4]+320,240-TY[4]);
		g.drawString("F",TX[5]+320,240-TY[5]);
		g.drawString("G",TX[6]+320,240-TY[6]);
		g.drawString("H",TX[7]+320,240-TY[7]);
		
	/*	//A------->B
		g.drawLine(TX[0],TY[0],TX[1],TY[1]);
		//B------->C
		g.drawLine(TX[1],TY[1],TX[2],TY[2]);
		//C------->D
		g.drawLine(TX[2],TY[2],TX[3],TY[3]);
		//D------->A
		g.drawLine(TX[3],TY[3],TX[0],TY[0]);
		//E------->F
		g.drawLine(TX[4],TY[4],TX[5],TY[5]);
		//F------->G
		g.drawLine(TX[5],TY[5],TX[6],TY[6]);
		//E------->H
		g.drawLine(TX[4],TY[4],TX[7],TY[7]);
		//H------->G
		g.drawLine(TX[7],TY[7],TX[6],TY[6]);
		//A------->E
		g.drawLine(TX[0],TY[0],TX[4],TY[4]);
		//B------->F
		g.drawLine(TX[1],TY[1],TX[5],TY[5]);
		//D------->H
		g.drawLine(TX[3],TY[3],TX[7],TY[7]);
		//C------->G
		g.drawLine(TX[2],TY[2],TX[6],TY[6]);*/
	}
	
	
	public void elips(Graphics g)
    {
        // center of the
        int cx, cy;
  
        // center of th ellipse
        cx = 150;
        cy = 175;
  
        // major and minor axis
        double A = 75, B = 50, px = 0, py = 0;
  
        // set color
        g.setColor(Color.blue);
  
        // draw the ellipse
        for (int i = 0; i <= 360; i++) {
            double x, y;
            x = A * Math.sin(Math.toRadians(i));
            y = B * Math.cos(Math.toRadians(i));
  
            if (i != 0) {
                // draw a line joining previous and new point .
                g.drawLine((int)px+320 + cx,240- ((int)py + cy),
                                320+((int)x + cx),240- ((int)y + cy));
            }
  
            // store the previous points
            px = x;
            py = y;
        }
    }
	

}
