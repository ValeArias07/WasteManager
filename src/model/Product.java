package model;

import java.util.Arrays;

public class Product {
	
	private String id;
	private String proname;
	private String prodescription;
	
	private Residue residuesP[];
	
	
public Product(String pid, String pProname, String pProdescription, int cantR) {
	
	id=pid;
	proname=pProname;
	prodescription=pProdescription;
	
	residuesP= new Residue[cantR];

	}
 public String addResidue(String option, String pindicator, String pname, String porigin, String pcolor, int pdesTime, String pProduct,String ptype, String pdescription){

    boolean duplicated=repeatName(pname);
    String message=" ";
    
    int ubi=ubication();
    
    if(duplicated==false){

        message="Waste registered sucessfully";
        residuesP[ubi]= new Recyclable(pindicator,pname,porigin,pcolor,pdesTime,pProduct,ptype,pdescription);
    	 }
    return message;
}


public String addResidue(String option, String pindicator, String pname, String porigin, String pcolor, int pdesTime, String pProduct,boolean pcomposting){

    boolean duplicated=repeatName(pname);
    String message="";
    int ubi=ubication();
    
    if(duplicated==false){
        message="Waste registered sucessfully";
        residuesP[ubi]= new Biodegradable(pindicator,pname,porigin,pcolor,pdesTime,pProduct,pcomposting);
    }
    return message;
}

public String addResidue(String option, String pindicator, String pname, String porigin, String pcolor, int pdesTime, String pProduct,String pRecommendation){

    boolean duplicated=repeatName(pname);
    String message="";
    int ubi=ubication();
    
    if(duplicated==false){
    	
        message="Waste registered sucessfully";
        residuesP[ubi]= new Inert(pindicator,pname,porigin, pcolor,pdesTime,pProduct,pRecommendation);
        
    }
    else
    message="Sorry, you cant register this waste because is duplicated";
    return message;

}

public boolean repeatName(String pname){

    boolean duplicated=false;

    for(int i=0; i<residuesP.length && duplicated==false; i-=-1){
    
        if(residuesP[i]!=null){
         String testName=residuesP[i].getName();
            if(testName.equals(pname)){

                duplicated=true;
            }
        }
    }
    return duplicated;
  }

public int ubication() {
	
	int ubi=-1;
	boolean found=false;
	
	for(int i=0; i<residuesP.length && found==false; i-=-1){
	    
        if(residuesP[i]!=null){
        	ubi++;
        	}
		}
	return ubi;
	}


	public String getId() {
		return id;
		}
	
	public String getProname() {
		return proname;
		}
	
	public String getProdescription() {
		return prodescription;
		}
	
	public Residue[] getResiduesP() {
		return residuesP;
		}
	@Override
	public String toString() {
		return "\n Product name="  + proname + "\n identificator=" + id + "\n Description="+ prodescription + "\n Residues=" + Arrays.toString(residuesP);
	}
	
	public String toStringR() {
		return "\n Total Waste=" + Arrays.toString(residuesP);
	}

}

