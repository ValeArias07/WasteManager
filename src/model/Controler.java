package model;

public class Controler {

private Product products[];
private Residue residues[];

public Controler (int n ){
	
 products=new Product[n];
 residues= new Residue[Product.MAXR*n];

}
public String addProduct(String pProname, String pid, String pProdescription) {
	
	int ubi=ubicationP();
	boolean duplicated=repeatNameP(pProname);
	boolean duplicatedId=repeatId(pid);
	
	String info;
	if(ubi!=-1 && duplicatedId==false && duplicated==false) {
		products[ubi] = new Product(pProname,pid,pProdescription);
		info="Product registered sucessfully"+ ubi;
	}
	else
		info="Sorry, you cant register this product because it name or id is duplicated";
	
	return info;
}

public String addResiduo(String pindicator, String pname, String porigin, String pcolor, int pdesTime, boolean pcomposting) {
	boolean reply;
	String info;
	int ubi=ubicationR();

	if(ubi!=-1 && repeatNameR(pname)==false) {
		
		residues[ubi] = new Biodegradable(pindicator,pname,porigin, products[searchPositionPname(pname)], pcolor, pdesTime, pcomposting);
		 
		reply = products[searchPositionPname(pname)].addResidue(residues[ubi]);
		
		if(reply == false) {
			residues[ubi]=null;
			
			info=" Error. The residue cant be register, the associeted product had using all it Residues amount" + Product.MAXR;
		}
		else
			info="Registered Successfull";
	}
	else
		info="Error. The residue cant be created, the amount of products is full or the name is duplicated";
	
	return info;
	
}

public String addResiduo( String pindicator, String pname, String porigin, String pcolor, int pdesTime, String pType, String pdescription) {
	boolean reply;
	String info;
	int ubi=ubicationR();
	
	if(ubi!=-1 && repeatNameR(pname)==false) { 
		
		residues[ubi] = new Recyclable (pindicator,pname,porigin,products[searchPositionPname(pname)],pcolor,pdesTime,pType, pdescription);
		 
		reply = products[searchPositionPname(pname)].addResidue(residues[ubi]);
		
		if(reply == false) {
			residues[ubi]=null;
			
			info=" Error. The residue cant be register, the associeted product had using all it Residues amount" + Product.MAXR;
		}
		else
			info="Registered Successfull";
	}
	else
		info="Error. The product cant be created, the amount of products is full or the name is duplicated";
	
	return info;
	
}

public String addResiduo(String pindicator, String pname, String porigin, String pcolor, int pdesTime, String pRecommendation) {
	boolean reply;
	String info;
	int ubi=ubicationR();
	
	if(ubi!=-1 && repeatNameR(pname)==false) { 
		
		residues[ubi] = new Inert (pindicator, pname,porigin, products[searchPositionPname(pname)], pcolor, pdesTime, pRecommendation);
		 
		reply = products[searchPositionPname(pname)].addResidue(residues[ubi]);
		
		if(reply == false) {
			residues[ubi]=null;
			
			info=" Error. The residue cant be register, the associeted product had using all it Residues amount" + Product.MAXR;
		}
		else
			info="Registered Successfull";
	}
	else
		info="Error. The product cant be created, the amount of products is full or the name is duplicated";
	
	return info;	
}

public boolean searchProduct(String proname) {
	boolean found=false;
	
	for(int i=0; i<products.length && found==false; i++) {
		
		String testName=products[i].getProname();
		
		if(testName.equals(proname)) {
			found=true;
		}
	}
	return found;
}

public int searchPositionPname(String proname) {
	int position=-1;
	String name;
	boolean found = false;
	for(int i=0; i<products.length && found == false; i++) {
		
		if(products[i]!=null) {
			
			name=products[i].getProname();
			if(name.equals(proname)) {
				position = i;
				found = true;
			}
		}
	}
	
	return position;
}

public boolean repeatNameR(String pname){

    boolean duplicated=false;

    for(int i=0; i<residues.length && duplicated==false; i++){
    
        if(residues[i]!=null){
         String testName=residues[i].getName();
            if(testName.equals(pname)){

                duplicated=true;
            }
        }
    }
    return duplicated;
  }

public boolean repeatId(String pid){

    boolean duplicated=false;

    for(int i=0; i<products.length && duplicated==false; i++){
    
        if(products[i]!=null){
         String testId=products[i].getId();
            if(testId.equals(pid)){

                duplicated=true;
            }
        }
    }
    return duplicated;
  }

public boolean repeatNameP(String pname){

    boolean duplicated=false;

    for(int i=0; i<products.length && duplicated==false; i++){
    
        if(products[i]!=null){
        	
         String testName=products[i].getProname();
            if(testName.equals(pname)){

                duplicated=true;
            }
        }
    }
    return duplicated;
  }

public int ubicationR() {
	
	int ubi=-1;
	boolean found=false;
	
	for(int i=0; i<residues.length && found==false; i++){
	    
        if(residues[i]==null){
        	ubi=i;
        	found=true;
        	}
		}
	
	return ubi;
	}

public int ubicationP() {
	
	int ubi=-1;

	boolean found=false;
	
	for(int i=0; i<products.length && found==false; i++){
	    
        if(products[i]==null){
        	ubi=i;
        	found=true;
        	}
		}

	return ubi;
	}

public String showAllR() {

	String infoBio= "";
	String infoIn= "";
	String infoRe= "";
	
	for(int a=0; a<residues.length;a++) {
		if(residues[a]!=null) {
			
		if(residues[a] instanceof Biodegradable) {	
		infoBio+="\n" + ((Biodegradable)residues[a]).toString();

			}
		}
	}

		for(int e=0; e<residues.length;e++) {
			if(residues[e]!=null) {
				
			if(residues[e] instanceof Recyclable) {	
			infoRe+="\n" + ((Recyclable)residues[e]).toString();
			
			}
		}
	}
		for(int i=0; i<residues.length;i++) {
			if(residues[i]!=null) {
				
			if(residues[i] instanceof Inert) {	
			infoIn+="\n" + ((Inert)residues[i]).toString();
				}
			}
		}
	if(infoBio.equals(""))
		infoBio="No residues created yet";
				
	if(infoIn.equals(""))
		infoIn="No residues created yet";
	
	if(infoRe.equals(""))
		infoRe="No residues created yet";
		
		
	String finalInfo= "Biodegradable Residues: \n" + infoBio  + "\n Recyclabe Residues: \n" +infoRe + "\n Inert Residues:" + infoIn ;	
	
	return finalInfo;
}

public String showAllP() {
	
	String info="";
	
	for(int i=0; i<products.length; i++) {
		
		if(products[i]!=null) {
			
			info+= products[i].toString()+ "\n";
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
				
				info=products[i].toStringR();
				found=true;
				}
			}
		}
	return info;
	}

public static String getInd() {
	return Residue.IND;
}

public static String getDom() {
	return Residue.DOM;
}

public static String getMun() {
	return Residue.MUN;
}

public static String getCons() {
	return Residue.CONS;
}

public static String getHos() {
	return Residue.HOS;
}
}