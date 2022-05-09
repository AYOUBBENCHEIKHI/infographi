package graphe2D;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Line2D;
import java.util.GregorianCalendar;

import javax.swing.JPanel;

public class Cercle extends JPanel{
	private static final long serialVersionUID = 1L;
	private int h;
	private int k;
	private int r;
	
	public Cercle() {
		
	}
	public Cercle(int r,int h,int k) {
		this.setH(h);
		this.setK(k);
		this.setR(r);
		
	}


	public int getH() {
		return h;
	}


	public void setH(int h) {
		this.h = h;
	}


	public int getK() {
		return k;
	}


	public void setK(int k) {
		this.k = k;
	}


	public int getR() {
		return r;
	}


	public void setR(int r) {
		this.r = r;
	} 
	//roper 
	 public void reper(Graphics g) {
		 Graphics2D g2 = (Graphics2D) g;
		 g2.draw ((Shape) new Line2D.Double(0,240,640,240));
		g2.draw ((Shape) new Line2D.Double(320,0,320,480));
	 }
	 //tracer
	 public void tracer(int x,int y,Graphics g) {
		super.paintComponent(g);
		 g.drawLine(x+320,240-y, x+320,240- y);
	 }
	 
	 //Methode pour tracer le cerce par la methode de bresenham
	 public void CercleBresenHam(Graphics g) {
			int x,y,s,i,h,k;
			h=getH();
			k=getK();
			x=0;
			y=getR();
			s=3-2*getR();
			i=0;
			while(i <= y) {
				if(s>=0) {
					s=s+4*(x-y)+10;
					x=x+1;
					y=y-1;
				}
				if(s<0) {
					s=s+4*x+6;
					x=x+1;
				}
				i=i+1;
				this.tracer(x+h,y+k, g);    
				this.tracer(-x+h,-y+k, g);
				this.tracer(y+h,x+k, g);
				this.tracer(-y+h,-x+k, g);
				this.tracer(-y+h,x+k, g);
				this.tracer(y+h,-x+k, g);
				this.tracer(-x+h,y+k, g);
				this.tracer(x+h,-y+k, g);
		
			}
	 }
	 
	 
	 
	//---------------------------Methode trigonometrique -------------------------
	 public void CercleTrigonometrique(Graphics g) {
		 int x,y,h,k;
		 h=getH();
		 k=getK();
		 double a=0;
		 while(a <=  Math.PI/4) {
			 x=(int) (getR()*Math.cos(a));
			 y=(int) (getR()*Math.sin(a));
				this.tracer(x+h,y+k, g);    
				this.tracer(-x+h,-y+k, g);
				this.tracer(y+h,x+k, g);
				this.tracer(-y+h,-x+k, g);
				this.tracer(-y+h,x+k, g);
				this.tracer(y+h,-x+k, g);
				this.tracer(-x+h,y+k, g);
				this.tracer(x+h,-y+k, g);
				a=a+Math.PI/50;
		 }
		 
	 }
	 
	 //----------------------Methode plynomial  (x-h)*(x-h)+(y-k)*(y-k)=r*r------------------
	 public void CerclePolynomial(Graphics g) {
		 int x,y,h,k;
		 h=getH();
		 k=getK();
		 x=0;
		 while(x <= (r/Math.sqrt(2))) {
			 y=(int) (Math.sqrt(r*r-(x-h)*(x-h))+k);
			 x++;
			 	this.tracer(x+h,y+k, g);    
				this.tracer(-x+h,-y+k, g);
				this.tracer(y+h,x+k, g);
				this.tracer(-y+h,-x+k, g);
				this.tracer(-y+h,x+k, g);
				this.tracer(y+h,-x+k, g); 
				this.tracer(-x+h,y+k, g);
				this.tracer(x+h,-y+k, g);
		 }
	 }

	 
	 //horloge 
	 //cercle des nombre 
	 
	 
	 public void Horloge(Graphics g,int r) {
		 super.paintComponent(g);
			GregorianCalendar temp=new GregorianCalendar();
			int h = temp.get(GregorianCalendar.HOUR_OF_DAY);//retorni le heure de lordinateur
			int min = temp.get(GregorianCalendar.MINUTE);
			int sec = temp.get(GregorianCalendar.SECOND);
			
		    
		    
		     Font font = new Font("Times New Roman",0,15);
		     g.setFont(font);
			
		     for(int i=1;i<=12;i++)
				{
				     double angle=i*Math.PI/6.0-Math.PI/2.0;
				     double x=320+getX()+r*Math.cos(angle);
				     double y=240-getY()+r*Math.sin(angle);
				      g.drawString(" "+i,(int)x,(int)y);
				}

				double angles=(sec*((Math.PI)/30.0)-(Math.PI/2.0));
				int xsf=(int) (getX()+(int)(0.7*r*Math.cos(-angles)));
				int ysf=(int) (getY()+(int)(0.7*r*Math.sin(-angles)));
				g.setColor(Color.BLACK);
				Ligne lsec = new Ligne((int)getX(), (int)getY(), xsf, ysf);
				lsec.LigneBresenham(g);
				//g.drawLine((int)320+getX(),(int)240-getY(),xsf,ysf);
				
			
				double anglem=(min*((Math.PI)/30.0)-(Math.PI/2.0));
				int xmf=(int) (getX()+(int)(0.6*r*Math.cos(-anglem)));
				int ymf=(int) (getY()+(int)(0.6*r*Math.sin(-anglem)));
				g.setColor(Color.BLACK);
				Ligne lmin = new Ligne((int)getX(), (int)getY(), xmf, ymf);
				lmin.LigneBresenham(g);
				//g.drawLine((int)320+getX(),(int)240-getY(),xmf,ymf);
				
				
				double angleh=(h*((2*Math.PI)/12.0)-(Math.PI/2.0));
				int xhf=(int) (getX()+(int)(0.4*r*Math.cos(-angleh)));
				int yhf=(int) (getY()+(int)(0.4*r*Math.sin(-angleh)));
				g.setColor(Color.BLACK);
				Ligne lh = new Ligne((int)getX(), (int)getY(), xhf, yhf);
				lh.LigneBresenham(g);
				//g.drawLine((int)320+getX(),(int)240-getY(),xhf,yhf);
			
	 }
	 public void increment()
		{
		 GregorianCalendar temp=new GregorianCalendar();
			int h=temp.get(GregorianCalendar.HOUR_OF_DAY);//retorni le heure de lordinateur
			int m=temp.get(GregorianCalendar.MINUTE);
			int s=temp.get(GregorianCalendar.SECOND);
			 s = s+1;
			 System.out.println("helloo");
			if(s>60)
			{
				 m=m+1;
				s=1;
				if(m>60)
				{
					m=1;
					h=h+1;
					if(h>12)
					{
						h=1;
					}
				}
			}
			this.repaint();
		}
	 
	 public void heur() {
		 while(true) {
			this.increment();
	 			try
				{
					Thread.sleep(1000);
				}
				catch(InterruptedException e)
				{
				}
		 }
	 }
	 
}

