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
	
/** This method created a new residue in the objet product
 * @param residue if the object product that was created in the class Controler
 * @return registered is the boolean that determinate if the residue was created or not
 */
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
	
/** This method search in the array of residues if the name is repeated or not.
 * @param pname is the parameter of the new residue pname!=" ".
 * @return info is the message that will show if the name is repeated or not
 */
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
	
/**This method search the ubication in the residues array to created a new residue 
 * @return ubi is the ubication where the new residue will be created
 */
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
//Getters and Setters methods	
	public String getProname() {
		return proName;
	}

	public String getId() {
		return id;
	}

	public String getProdescription() {
		return prodescription;
	}
	
/** This toString method contains all the information about a product
 */
	public String toString() {
		return "\n Product name: "  + proName + "\n identificator: " + id + "\n Description: "+ prodescription;
	}
	
/** This toString method contains all the information about a residues of the objetc product
 */
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

