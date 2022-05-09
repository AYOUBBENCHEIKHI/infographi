package rattrapage2022;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestRotation  extends JPanel{

	public TestRotation() {
		// TODO Auto-generated constructor stub
	}
	@Override
	protected void paintChildren(Graphics g) {
		super.paintChildren(g);
		double M[][] = {{0,0,0,1},
						{3,0,0,1},
						{0,0,3,1},
						{0,2,0,1},
						{3,2,0,1},
						{0,2,3,1}};
		int tx[] = new int [6];
		int ty[] = new int [6];
		double MP[][] = null;
		int MMT[][] =null;
		Prisme p =new Prisme();
		MP = p.projectionCavalier(M);
		MMT = p.doubleToInt(MP);
		
		p.extraction(MMT, tx,ty);
		p.tracer(tx, ty, g);
		p.reper(g);
		g.setColor(Color.red);
		g.drawLine(320,240,320+150,240-100);
		
		//rotation de teta DG
		double MR0[][] = null;
		MR0 =p.rotaionZ(M);
		//rotation de 45 DG
		double MR1[][] = null;
		MR1 =p.rotaionY(MR0);
		//rotation de -teta DG
		double MR2[][] = null;
		MR2 =p.rotaionZMoin(MR1);
		
		g.setColor(Color.blue);
		MP = p.projectionCavalier(MR2);
		MMT = p.doubleToInt(MP);
		p.extraction(MMT, tx,ty);
		p.tracer(tx, ty, g);
		
		
	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame f = new JFrame("Rotaion de 45dg");
		f.addWindowListener( new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});
		f.getContentPane().add(new TestRotation());
		f.setSize(800,800);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		f.setResizable(false);
		f.revalidate();	
		
		//f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
