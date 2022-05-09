package rattrapage2022;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestPerspective extends JPanel {

	public TestPerspective() {
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
		p.tracerPlan(tx, ty, g);
		p.reper(g);	
		g.setColor(Color.blue);
		//prpojection perspective 
		double PRS[][] = null;
		try {
			PRS=p.projectionPerspectivePlanQlq(M, 0, 0, 100,0,0, 1, 3, 2, 0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//MP = p.projectionCavalier(MR2);
		MMT = p.doubleToInt(PRS);
		p.extraction(MMT, tx,ty);
		g.setColor(Color.blue);
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
		f.getContentPane().add(new TestPerspective());
		f.setSize(800,800);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
		f.setResizable(false);
		f.revalidate();	
		
		//f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


}
