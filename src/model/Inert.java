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

		return "Type of Residue: Inert \n Indicator: " + super.getIndicator() + "\n Name: " + super.getName() + "\n Origin: "+ super.getOrigin() + "\n Harm level: "+ super.getHarm() + "\n Color: "+ super.getColor() + "\n Descomposition time:  " +super.getDesTime() + "\n Recomendation: " + recommendation + "\n ___________________";
	
	}
}
