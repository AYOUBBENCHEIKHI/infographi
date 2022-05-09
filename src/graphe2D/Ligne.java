package graphe2D;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Line2D;
import javax.swing.JPanel;

public class Ligne extends JPanel{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int xd;
	 private int yd;
	 private int xf;
	 private int yf;
	 
	 
	 public Ligne() {
		 
	 }
	 public void tracer(Graphics g) {
		 g.drawLine(getXd(), getYd(),getXf(), getYf());
		 g.draw3DRect(xd, yd, xf, xd, getFocusTraversalKeysEnabled());
	 }
	 public Ligne(int xd,int yd,int xf,int yf) {
		 this.setXd(xd);
		 this.setXf(xf);
		 this.setYd(yd);
		 this.setYf(yf);
	 } 
	public int getXd() {
		return xd;
	}

	public void setXd(int xd) {
		this.xd = xd;
	}

	public int getYd() {
		return yd;
	}

	public void setYd(int yd) {
		this.yd = yd;
	}

	public int getXf() {
		return xf;
	}

	public void setXf(int xf) {
		this.xf = xf;
	}

	public int getYf() {
		return yf;
	}

	public void setYf(int yf) {
		this.yf = yf;
	}
	//les methode de trace 
	
	//--------------------------tracer le reper---------------------
	
	public void reper(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.draw ((Shape) new Line2D.Double(0,240,640,240));
		g2.draw ((Shape) new Line2D.Double(320,0,320,480));
	}
	// methode pour tracer la ligne
	public void TracerLigne(int x,int y,Graphics g) {
		super.paintComponent(g);
		g.drawLine(x+320,240-y,320+x,240-y);
		//g.drawLine(x,y,x,y);
	}
	//--------------------methode de bresenham-----------------------------
	 public void LigneBresenham(Graphics g){
		 int dx,dy,px,py,s,x,y;
		 dx = getXf()-getXd(); 
		 dy = getYf() - getYd();
		 x=getXd();
		 y=getYd();
		 s = 2*dy - dx;
		 px=(getXd() > getXf()) ? -1:1;//ON FAIT TEST SI XD > XF ON DONNE -1 aPX , 1 SI NON 
		 py=(getYd() > getYf()) ? -1:1;
		 dx = Math.abs(dx);
		 dy= Math.abs(dy);
		if(dx > dy) {
			 for(int i=0;i<dx;i++) {
				 if(s >= 0) {
					 x=x+px;
					 y=y+py;
					 s = s + 2 * ( dy - dx ) ;
				 }
				 if(s < 0) {
					 x=x+px;
					 s = s + 2 * dy ;
				 }
				 this.TracerLigne(x,y,g);
			 }
			
		 }//premiere octan
		 if (dx < dy) {
			 for(int i=0;i<dx;i++) {
				 if(s >= 0) {
					 x=x+px;
					 y=y+py;
					 s = s + 2 * ( dx - dy ) ;
				 }
				 if(s < 0) {
					 y=y+py;
					 s = s + 2 *  dx  ;
				 }
				 this.TracerLigne(x,y,g);
			 }
			 
		 }		
	 }
	 
	 
	//--------------------methode de polynomial-----------------------------
	 public  void LignePolynomial(Graphics g){
		 int dx,dy,px=1,py=1,x,y;
		 float a,b;
		 dx = getXf()-getXd(); 
		 dy = getYf() - getYd();
		 x=getXd();
		 y=getYd();
		 px=(getXd() > getXf()) ? -1:1;//ON FAIT TEST SI XD > XF ON DONNE -1 aPX , 1 SI NON 
		 py=(getYd() > getYf()) ? -1:1;
		 dx = Math.abs(dx);
		 dy= Math.abs(dy);
		 if(dx >= dy) {
			a=(float) dy/dx;
			b=getYd()-getXd()*a;
			int  i=getXd();
			 while(i<getXf()) {
				 y = (int) (a*i + b);
				this.TracerLigne(i, y, g);
				i=i+px;
			} 
		 }
		 if(dx < dy) {
				a=(float) dx/dy;
				b=getXd()-getYd()*a;
				int  i=getYd();
				 while(i<getYf()) {
					 x = (int) (a*i + b);
					 this.TracerLigne(x, i, g);
					i=i+py;
				}
			 }
	 }
	 
}
