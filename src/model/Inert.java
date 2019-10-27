package model;

public class Inert extends Residue{
	
	private String recommendation;

	public Inert(String pindicator, String pname, String porigin, Product productAssociated, String pcolor, int pdesTime, String pRecommendation){

		super(pindicator, pname,porigin,productAssociated,pcolor,pdesTime);
		
		recommendation=pRecommendation;

	}

/** This toString method contains all the information about a the object Inert
 */ 
public String toString() {

		return "\n indicator: " + super.getIndicator() + "\n name: " + super.getName() + "\n origin: "+ super.getOrigin() + "\n color: "+ super.getColor() + "\n descomposition time:  " + super.getDesTime() + "\n recomendation: " + recommendation + "\n ___________________";
	
	}
}
