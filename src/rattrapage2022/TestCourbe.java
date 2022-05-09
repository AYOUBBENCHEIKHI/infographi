package rattrapage2022;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestCourbe extends JPanel {

	public TestCourbe() {
		// TODO Auto-generated constructor stub
	}
	@Override
	protected void paintChildren(Graphics g) {
		super.paintChildren(g);
		double PT[][] = {
						{0,0,3,1},
						{0,2,3,1},
						{3,2,0,1},
						{3,0,0,1}				
						};
		
		double M[][] = {{0,0,0,1},
				{3,0,0,1},
				{0,0,3,1},
				{0,2,0,1},
				{3,2,0,1},
				{0,2,3,1}};
		
		int tx[] = new int [7];
		int ty[] = new int [7];
		double MP[][] = null;
		int MMT[][] =null;
		Prisme p =new Prisme();
		MP = p.projectionCavalier(M);
		MMT = p.doubleToInt(MP);
		
		p.extraction(MMT, tx,ty);
		p.tracer(tx, ty, g);
		p.reper(g);	
		g.setColor(Color.blue);
		
		double[][] P =new double[7][4];
		P[0]=p.polynomBern(PT, 0);
		P[1]=p.polynomBern(PT, 0.15);
		P[2]=p.polynomBern(PT, 0.35);
		P[3]=p.polynomBern(PT, 0.50);
		P[4]=p.polynomBern(PT, 0.65);
		P[5]=p.polynomBern(PT, 0.85);
		P[6]=p.polynomBern(PT, 1);
		
		
		double point[][] = null;
		point =p.projectionCavalier(P);
		MMT = p.doubleToInt(point);
		p.extraction(MMT, tx,ty);
		for(int i=0;i<7;i++) {
			g.setColor(Color.red);
			if(i==6) {
				g.drawLine(320+tx[i],240-ty[i],320+tx[i],240-ty[i]);
			}
			else {
				g.drawLine(320+tx[i],240-ty[i],320+tx[i+1],240-ty[i+1]);
			}
			
		}
	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame f = new JFrame("Corbe");
		f.addWindowListener( new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
		f.getContentPane().add(new  TestCourbe());
		f.setSize(800,800);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		f.setResizable(false);
		f.revalidate();	
		
		//f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
