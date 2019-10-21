package model;

public class Controler {

private Product products[];
private Residue residues[];

public Controler (){

 products=new Product[100];
 residues= new Residue[100];

}

public String addResidue(String option, String pindicator, String pname, String porigin, String pcolor, int pdesTime, String pProduct,String ptype, String pdescription){

    boolean duplicated=repeatNameR(pname);
    String message=" ";
    
    int ubi=ubicationR();
    
    if(duplicated==false){

        message="Waste registered sucessfully";
        residues[ubi]= new Recyclable(pindicator,pname,porigin,pcolor,pdesTime,pProduct,ptype,pdescription);
    	 }
    return message;
}


public String addResidue(String option, String pindicator, String pname, String porigin, String pcolor, int pdesTime, String pProduct,boolean pcomposting){

    boolean duplicated=repeatNameR(pname);
    String message="";
    int ubi=ubicationR();
    
    if(duplicated==false){
        message="Waste registered sucessfully";
        residues[ubi]= new Biodegradable(pindicator,pname,porigin,pcolor,pdesTime,pProduct,pcomposting);
    }
    return message;
}

public String addResidue(String option, String pindicator, String pname, String porigin, String pcolor, int pdesTime, String pProduct,String pRecommendation){

    boolean duplicated=repeatNameR(pname);
    String message="";
    int ubi=ubicationR();
    
    if(duplicated==false){
    	
        message="Waste registered sucessfully";
        residues[ubi]= new Inert(pindicator,pname,porigin, pcolor,pdesTime,pProduct,pRecommendation);
        
    }
    else
    message="Sorry, you cant register this waste because is duplicated";
    return message;

}

public String createProduct(String pid, String pProname, String pProdescription, int cantR){
	
	 boolean duplicated=repeatNameP(pProname);
	    String message="";
	    int ubi=ubicationP();
	    
	    if(duplicated==false){
	    	
	        message="Product registered sucessfully";
	        products[ubi]= new Product(pid,pProname, pProdescription,cantR);
	        
	    }
	    else
	    message="Sorry, you cant register this product because is duplicated";
	    return message;
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
	
	int ubi=-1;
	boolean found=false;
	
	for(int i=0; i<residues.length && found==false; i-=-1){
	    
        if(residues[i]!=null){
        	ubi++;
        	}
		}
	return ubi;
	}

public boolean repeatNameP(String pname){

    boolean duplicated=false;

    for(int i=0; i<products.length && duplicated==false; i-=-1){
    
        if(products[i]!=null){
         String testName=products[i].getProname();
            if(testName.equals(pname)){

                duplicated=true;
            }
        }
    }
    return duplicated;
  }

public int ubicationP() {
	
	int ubi=-1;
	boolean found=false;
	
	for(int i=0; i<products.length && found==false; i-=-1){
	    
        if(products[i]!=null){
        	ubi++;
        	}
		}
	return ubi;
	}

public String showAllR() {

	String infoBio= "";
	
	for(int a=0; a<residues.length;a++) {
		if(residues[a]!=null) {
			
		if(residues[a] instanceof Biodegradable) {
			
		infoBio+="\n" + ((Biodegradable)residues[a]).toString();
		
			}
		}
	}
		
		String infoRe= "";
		
		for(int e=0; e<residues.length;e++) {
			if(residues[e]!=null) {
				
			if(residues[e] instanceof Recyclable) {
				
			infoRe+="\n" + ((Recyclable)residues[e]).toString();
			
			}
		}
	}
		
		String infoIn= "";
		
		for(int i=0; i<residues.length;i++) {
			if(residues[i]!=null) {
				
			if(residues[i] instanceof Inert) {
				
			infoIn+="\n" + ((Inert)residues[i]).toString();
			
			}
		}
	}
	String finalInfo= "Biodegradable Residues" + "\n" + infoBio + "\n Recyclabe Residues" + infoRe +  "\n Inert Residues" + infoIn ;	
	
	return finalInfo;
}

public String showAllP() {
	
	String info="";
	
	for(int i=0; i<products.length; i++) {
		
		if(products[i]!=null) {
			
			info+="\n" + products[i].toString();
		}
	}
	
	return info;
}

public String searchName (String pname) {
	
	String testName="";
	String info="Not found. That waste is not register";
	boolean found=false;
	
	for(int i=0; i<residues.length && found==false; i++) {
		
	if(residues[i]!=null) {
		
		if(residues[i] instanceof Biodegradable) {
			
			testName=residues[i].getName();

			if(testName.equals(pname)) {
				
				info="Information found" + ((Biodegradable)residues[i]).toString();
				found=true;
			}
		}
			else
				if(residues[i] instanceof Recyclable){
					
				testName=residues[i].getName();
					
					if(testName.equals(pname)) {
						
						info="Information found" + ((Recyclable)residues[i]).toString();
						found=true;
					}
				}
		
			else
				if(residues[i] instanceof Inert){
						
				testName=residues[i].getName();
						
					if(testName.equals(pname)) {
							
						info="Information found" + ((Inert)residues[i]).toString();
						found=true;
					}	
				}
			}
		}
	return info;
	}

public String searchId(String id) {
	
	boolean found=false;
	String info="Info not found. That product was not created";
	String testId="";
	
	for(int i=0; i<products.length && found==false; i++) {
		
		if(products[i]!=null) {
			
			testId=products[i].getId();
			
			if(testId.equals(id)) {
				
				info="information found" + products[i].toStringR();
				found=true;
				
				}
			}
		}
	return info;
	}
}