import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Line2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Courbes.CourbeBernsten;
import graphe3D.Cub3D;

public class TestBSplin extends JPanel{
	private static final long serialVersionUID = 1L;
	public TestBSplin() {
		// TODO Auto-generated constructor stub
	}
	@Override
	protected void paintChildren(Graphics g) {
		super.paintChildren(g);
		exament ex =new exament();
		//B Spline 
		double S[][] =new double[10][4];
		S[0] = ex.bSplin(0);
		S[1] = ex.bSplin(0.125);
		S[2] = ex.bSplin(0.25);
		S[3] = ex.bSplin(0.375);
		S[4] = ex.bSplin(0.5);
		S[6] = ex.bSplin(0.625);
		S[7] = ex.bSplin(0.75);
		S[8] = ex.bSplin(0.875);
		S[9] = ex.bSplin(1);
		//MP = cub.projectionCavalier(S);
		
		//reper----------------
			Graphics2D g2 = (Graphics2D) g;
			 g2.draw ((Shape) new Line2D.Double(0,340,640,340));
			g2.draw ((Shape) new Line2D.Double(320,0,320,480));
			//--------------------------
			CourbeBernsten bez = new CourbeBernsten();
			double[] b0 = {0,0};
			double[] b1 = {100,100};
			double[] b2 = {200,50};
			double[] b3 = {300,100};
			double Point[][] = {b0,b1,b2,b3};
			double[][] p =new double[7][2];
			p[0]=bez.polynomBern(Point, 0);
			p[1]=bez.polynomBern(Point, 0.15);
			p[2]=bez.polynomBern(Point, 0.35);
			p[3]=bez.polynomBern(Point, 0.50);
			p[4]=bez.polynomBern(Point, 0.65);
			p[5]=bez.polynomBern(Point, 0.85);
			p[6]=bez.polynomBern(Point, 1);
			
			/*for(int i=0;i<7;i++) {
				//System.err.println("["+p[i][0]+","+p[i][1]+"]");
				g.setColor(Color.red);
				if(i==6) {
					g.drawLine(320+(int)(p[i][0]),340-(int)(p[i][1]),320+(int)(p[i][0]),340-(int)(p[i][1]));
					//break;
				}
				else {
					g.drawLine(320+(int)(p[i][0]),340-(int)(p[i][1]),320+(int)(p[i+1][0]),340-(int)(p[i+1][1]));
				}
				
			}*/
			for(int i=0;i<7;i++) {
				//System.err.println("["+p[i][0]+","+p[i][1]+"]");
				g.setColor(Color.red);
				
					g.drawLine(320+(int)(p[i][0]),340-(int)(p[i][1]),320+(int)(p[i][0]),340-(int)(p[i][1]));
					//break;
				
				
			}
		
	
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame f = new JFrame("B_Spline");
		f.addWindowListener( new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
		f.getContentPane().add(new TestBSplin());
		f.setSize(800,800);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		f.setResizable(false);
		f.revalidate();	
		
		//f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
