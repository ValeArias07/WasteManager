package model;

import java.util.Arrays;

public class Product {
	
	static final int MAXR=15; 
	
	private String proName;
	private String id;
	private String prodescription;
	
	private Residue residues[];
	
	public Product(String pProname, String pid, String pProdescription) {
		
		proName=pProname;
		id=pid;
		prodescription=pProdescription;
		
		residues= new Residue[MAXR];
		
	}
	
	public boolean addResidue(Residue residue) {
		boolean registered;
		int ubi = ubicationR();
		if(ubi!=-1) {
			
			residues[ubi] = residue;
			registered = true;
		}
		else 
			registered = false;
		
		return registered;
	}
	
	
	public boolean repeatNameR(String pProname){

	    boolean duplicated=false;

	    for(int i=0; i<residues.length && duplicated==false; i-=-1){
	    
	        if(residues[i]!=null){
	         String testName=residues[i].getName();
	            if(testName.equals(pProname)){

	                duplicated=true;
	            }
	        }
	    }
	    return duplicated;
	  }

	public int ubicationR() {
		
		int ubi=0;
		boolean found=false;
		
		for(int i=0; i<residues.length && found==false; i++){
		    
	        if(residues[i]!=null){
	        	ubi++;
	        	}
			}
		return ubi;
		}
	
	public String getProname() {
		return proName;
	}

	public String getId() {
		return id;
	}

	public String getProdescription() {
		return prodescription;
	}

	public String toString() {
		return "\n Product name: "  + proName + "\n identificator: " + id + "\n Description: "+ prodescription;
	}
	
	public String toStringR() {
		String infoR="";
		
		for(int i=0; i<residues.length; i++) {
			if(residues[i]!=null) {
				
				infoR +=residues[i].toString();
			}
			else 
				infoR="There is no residues registred in this product";
		}
		
		return "All product residues: \n"+ infoR;
	}
}

