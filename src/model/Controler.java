import javax.lang.model.util.ElementScanner6;

public class Controler {

private Product products[];
private Residue residues[];

public Controler (){

 product=new Product[100];
 residues= new Residue[100];

}

public String addRedisue(String option, String pindicator, String pname, String porigin, String pcolor, int pdesTime, String pProduct,String ptype, String pdescription){

    boolean duplicated=repeatName(pname);
    String message0="";
    
    if(duplicated==false){

        message="Waste registered sucessfully";

        residue[i]= new Recyclable(pindicator,pname,porigin, String,pdesTime,pProduct,ptype,pdescription);


    }

    return message;

}

public String addRedisue(String option, String pindicator, String pname, String porigin, String pcolor, int pdesTime, String pProduct,boolean pcomposting){

    boolean duplicated=repeatName(pname);
    String message0="";
    
    if(duplicated==false){

        message="Waste registered sucessfully";

        residue[i]= new Biodegradable(pindicator,pname,porigin, String,pdesTime,pProduct,pcomposting);

    }

    return message;

}

public String addRedisue(String option, String pindicator, String pname, String porigin, String pcolor, int pdesTime, String pProduct,String pRecommendation){

    boolean duplicated=repeatName(pname);
    String message0="";
    
    if(duplicated==false){

        message="Waste registered sucessfully";

        residue[i]= new Inert(pindicator,pname,porigin, String,pdesTime,pProduct,pRecommendation);

    }
    else
        message="Sorry, you cant register this waste because is duplicated";

    return message;

}


public boolean repeatName(String pname){

    boolean duplicated=false;

    for(int i=0; i<residues.length && duplicated==false; i-=-1){
    
        if(residues[i]!=null){
         String testName=residues[i].getName();
            if(testName.equals(pname)){

                duplicated=true;
            }
        }
    }
    return duplicated;
    }

}