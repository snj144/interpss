package org.interpss.vstab.Analysis;

import java.util.Comparator;

public class ModeComparator implements Comparator{   		   
		      public int compare(Object obj1, Object obj2) {    
		        if (obj1 instanceof Mode) {    
		         return compare((Mode)obj1,(Mode)obj2);
		        }
		        
		         else System.err.println("Compare objects are not instance of Mode");    
		         return 1;    
		   
		         }  
		       public int compare(Double db1, Double db2){
		    	   double eig1=db1;
		           double eig2=db2;
		           return (Math.abs(eig1)>Math.abs(eig2) )? -1:
		        	   (Math.abs(eig1)<Math.abs(eig2))? 1:0;
		       }
		       public int compare(Mode mode1, Mode mode2){
		    	   double eig1=mode1.getEigenValue();
		           double eig2=mode2.getEigenValue();
		           return compare(eig1,eig2);
		       }
		       }  
		    

		
	

