

public class ProuduitMatriciel {
	 public ProuduitMatriciel() {
		 
	 }
 
	static double[][] produit( double M[][], double N[][])throws Exception {
		 double p[][];
		int l,c;
		if(M[0].length != N.length) {
			System.out.println("imposible de faire le produit");
		}
		if(N == null || M == null) {
			System.out.println("l'un des deux matrice est null");
		}
		if(M.length * M[0].length < N.length * N[0].length){
				l= N.length;
				c= N[0].length;
			 }
		else{
				 l= M.length;
				 c= M[0].length;
			 }
		p= new  double[l][c];
		l=0;

		for(int i=0;i<M.length;i++) {
			c=0;
			for(int j=0;j<N[0].length;j++) {
				 double calcul = 0;
				for(int k=0;k<N.length;k++) {
					 //System.out.printf("%4d    * %4d", M[i][k],N[k][j]);
	                    calcul += M[i][k] * N[k][j];
	                    //if (k == 0)
	                   	//System.out.printf("    + ");

				}
                //System.out.printf(" = %4d   ",calcul);
                p[l][c] = calcul;
                c++;	
			}
			//System.out.printf("n");
            l++;
		}
		return p;
	}
	
	
	public static void afficher( double [][]M) throws Exception{
		if(M == null){
			throw new Exception("La matrice est à null");
		}
		    for (int i = 0;i < M.length;i++)
		    {
		        for (int j = 0;j < M[0].length ;j++)
		        {
		            System.out.printf("%4d ",M[i][j] );
		        }
		       System.out.println();
		    }
		    System.out.println();
	}



	
	public static void main(String[] args) {
		
		 double[][] MA = {{2,3},{5,1}};
		 double[][] MB= {{3,2},{6,1}};
		 double[][]MC = null;
	
	     try {
	    	 
	    	 afficher(MA);
			 afficher(MB);
			 MC =produit(MA, MB);
	    	 System.out.println();
			afficher(MC);
			
		} catch (Exception e) {
			System.out.println(e);
		}


	}

	 public static void afficher(int[][] M) throws Exception {
		if(M == null){
			throw new Exception("La matrice est à null");
		}
		    for (int i = 0;i < M.length;i++)
		    {
		        for (int j = 0;j < M[0].length ;j++)
		        {
		            System.out.printf("%4d ",M[i][j] );
		        }
		       System.out.println();
		    }
		    System.out.println();
		
	}
}
