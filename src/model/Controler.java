package model;
import java.util.Collections;

public class Controler {

private Product products[];
private Residue residues[];

public Controler (int n ){
	
 products=new Product[n];
 residues= new Residue[Product.MAXR*n];

}

/** This method create a new product
 * @param pProname is the name of the new product that will be created. pProname!=""
 * @param pid is the id of the new product that will be created. pid!= ""
 * @param pProdescription is the description of the new product that will be created. pProdescription!=""
 * @return info is the message that say if the product was created or not
 */
public String addProduct(String pProname, String pid, String pProdescription) {
	
	int ubi=ubicationP();
	boolean duplicated=repeatNameP(pProname);
	boolean duplicatedId=repeatId(pid);
	
	String info;
	if(ubi!=-1 && duplicatedId==false && duplicated==false) {
		products[ubi] = new Product(pProname,pid,pProdescription);
		info="Product registered sucessfully";
	}
	else
		info="Sorry, you cant register this product because it name or id is duplicated";
	return info;
}

/** This method create an Biodegradable residue and associate it with a product
 * @param proname is the name of the product associated proname!=""
 * @param pindicator is the id of the residue that will be created pindicator!=""
 * @param pname is the name of the residue that will be created pname!=""
 * @param porigin is the origin of the residue that will be created porigin!=""
 * @param pcolor is the color of the residue that will be created pcolor!=""
 * @param pdesTime is the time of Descomposition of the residue that will be created pDestime!=""
 * @param pcomposting is the boolean that determinate if the biodegradable residue is compostable or not. pcomposting!=null
 * @return message is the message that say if the residue was created or not. Also it say if the residue is repeated or not.
 */
public String addResiduo(String proname, String pindicator, String pname, String porigin, String pcolor, int pdesTime, boolean pcomposting) {
	boolean reply;
	String info;
	int ubi=ubicationR();

	if(ubi!=-1 && repeatNameR(pname)==false) {
		
		residues[ubi] = new Biodegradable(pindicator,pname,porigin, products[searchPositionPname(proname)], pcolor, pdesTime, pcomposting);
		 
		reply = products[searchPositionPname(proname)].addResidue(residues[ubi]);
		
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

/** This method create an Recyclable residue and associate it with a product
 * @param proname is the name of the product associated proname!=""
 * @param pindicator is the id of the residue that will be created pindicator!=""
 * @param pname is the name of the residue that will be created pname!=""
 * @param porigin is the origin of the residue that will be created porigin!=""
 * @param pcolor is the color of the residue that will be created pcolor!=""
 * @param pdesTime is the time of Descomposition of the residue that will be created pDestime!=""
 * @param pType is the type of the recyclable residue. pType!=""
 * @param pdescription is the description of the recyclable residue. pdescription!=""
 * @return message is the message that say if the residue was created or not. Also it say if the residue is repeated or not.
 */
public String addResiduo(String proname, String pindicator, String pname, String porigin, String pcolor, int pdesTime, String pType, String pdescription) {
	boolean reply;
	String info;
	int ubi=ubicationR();
	
	if(ubi!=-1 && repeatNameR(pname)==false) { 
		
		residues[ubi] = new Recyclable (pindicator,pname,porigin,products[searchPositionPname(proname)],pcolor,pdesTime,pType, pdescription);
		 
		reply = products[searchPositionPname(proname)].addResidue(residues[ubi]);
		
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

/** This method create an Inert residue and associate it with a product
 * @param proname is the name of the product associated proname!=""
 * @param pindicator is the id of the residue that will be created pindicator!=""
 * @param pname is the name of the residue that will be created pname!=""
 * @param porigin is the origin of the residue that will be created porigin!=""
 * @param pcolor is the color of the residue that will be created pcolor!=""
 * @param pdesTime is the time of Descomposition of the residue that will be created pDestime!=""
 * @param pRecommendation is the recommendation to discard the inert residue pRecommendation!=""
 * @return message is the message that say if the residue was created or not. Also it say if the residue is repeated or not.
 */
public String addResiduo(String proname,String pindicator, String pname, String porigin, String pcolor, int pdesTime, String pRecommendation) {
	boolean reply;
	String info;
	int ubi=ubicationR();
	
	if(ubi!=-1 && repeatNameR(pname)==false) { 
		
		residues[ubi] = new Inert (pindicator, pname,porigin, products[searchPositionPname(proname)], pcolor, pdesTime, pRecommendation);
		 
		reply = products[searchPositionPname(proname)].addResidue(residues[ubi]);
		
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

/** This method search with the name of an product if it exists in the array or not
 * @param proname is the name of the product that will be searched proname!="".
 * @return found is the boolean that say if the product is or not in the array
 */
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

/** This method search with the name of an product it ubication
 * @param proname is the name of the product that will be searched proname!="".
 * @return position is the position where the product is
 */
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

/** This method search in the array of residues if the name is repeated or not.
 * @param pname is the parameter of the new residue pname!=" ".
 * @return info is the message that will show if the name is repeated or not
 */
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

/** This method search in the array of products if the id is repeated or not.
 * @param id is the parameter of the new product id!=" ".
 * @return info is the message that will show if the id is repeates or not
 */
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

/** This method search in the array of products if the name is repeated or not.
 * @param pname is the parameter of the new product pname!=" ".
 * @return info is the message that will show if the name is repeated or not
 */
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

/**This method search the ubication in the residues array to created a new residue 
 * @return ubi is the ubication where the new residue will be created
 */
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

/**This method search the ubication in the products array to created a new product 
 * @return ubi is the ubication where the new product will be created
 */
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

/** This method show all the information about the residues registered
 * @return info is the message that contains all the information of the distinct type of residue.
 */
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

/**This method show all the information of the products registered
 * @return info is the message with all the information of the products
 */
public String showAllP() {
	
	String info="";
	
	for(int i=0; i<products.length; i++) {
		
		if(products[i]!=null) {
			
			info+= products[i].toString()+ "\n";
		}
	}
	
	return info;
}

/** This method search the name of a residue and show all the information of it
 * @param pname is the name of that residue that be searched pname!="".
 * @return info is the all information of the residue founded.
 */
public String searchName (String pname) {
	
	String testName="";
	String info="Not found. That waste is not register";
	boolean found=false;
	
	for(int i=0; i<residues.length && found==false; i++) {
		
	if(residues[i]!=null) {
		
		if(residues[i] instanceof Biodegradable) {
			
			testName=residues[i].getName();
			if(testName.equals(pname)) {
				
				info="Information found \n" + ((Biodegradable)residues[i]).toString();
				found=true;
			}
		}
			else
				if(residues[i] instanceof Recyclable){
					
				testName=residues[i].getName();
					
					if(testName.equals(pname)) {
						
						info="Information found \n" + ((Recyclable)residues[i]).toString();
						found=true;
					}
				}
		
			else
				if(residues[i] instanceof Inert){
						
				testName=residues[i].getName();
						
					if(testName.equals(pname)) {
							
						info="Information found \n" + ((Inert)residues[i]).toString();
						found=true;
					}	
				}
			}
		}
	return info;
	}

/**This method search the id of an product and show all the residues associated with it
 * @param id is the id of the product that will be searched in the array
 * @return info is the message that will have the info of the residues associated
 */
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

/** This method take the harm level of every residue and order the array since the most harmful to least the harmful
 * @return info  is the message that show the arrays ordered
 */
public String harmOrder() {
	String info="";
	for(int i=0; i<residues.length;i++) {
		
		if(residues[i]!=null && residues[i+1]!=null) {
			if(residues[i].getHarm()<residues[i+1].getHarm()) {
				residues[i+1]=residues[i];
			}
		}
	}
	
	for(int i=0; i<residues.length;i++) {
		
		if(residues[i]!=null)
		 info+= "\n" + residues[i].toString();
	}
	return info;
}

/** These methods just catch the constants of the class Product and Residue.
  @return Residue.IND is the constant that be used in main.
 */
public static String getInd() {
	return Residue.IND;
}

/** These methods just catch the constants of the class Product and Residue.
@return Residue.DOM is the constant that be used in main.
*/

public static String getDom() {
	return Residue.DOM;
}

/** These methods just catch the constants of the class Product and Residue.
@return Residue.MUN is the constant that be used in main.
*/
public static String getMun() {
	return Residue.MUN;
}

/** These methods just catch the constants of the class Product and Residue.
@return Residue.CONS is the constant that be used in main.
*/
public static String getCons() {
	return Residue.CONS;
}

/** These methods just catch the constants of the class Product and Residue.
@return Residue.HOS is the constant that be used in main.
*/
public static String getHos() {
	return Residue.HOS;
}

/** These methods just catch the constants of the class Product and Residue.
@return Recyclable.P is the constant that be used in main.
*/
public static String getP() {
	return Recyclable.P;
}

/** These methods just catch the constants of the class Product and Residue.
@return Recyclable.PB is the constant that be used in main.
*/
public static String getPb() {
	return Recyclable.PB;
}

/** These methods just catch the constants of the class Product and Residue.
@return Recyclable.G is the constant that be used in main.
*/
public static String getG() {
	return Recyclable.G;
}

/** These methods just catch the constants of the class Product and Residue.
@return Recyclable.PL is the constant that be used in main.
*/
public static String getPl() {
	return Recyclable.PL;
}

/** These methods just catch the constants of the class Product and Residue.
@return Recyclable.M is the constant that be used in main.
*/
public static String getM() {
	return Recyclable.M;
}
}