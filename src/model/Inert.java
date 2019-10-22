package model;

public class Inert extends Residue{
	
	private String recommendation;

	public Inert(String pindicator, String pname, String porigin, Product productAssociated, String pcolor, int pdesTime, String pRecommendation){

		super(pindicator, pname,porigin,productAssociated,pcolor,pdesTime);
		
		recommendation=pRecommendation;

	}

	public String getRecommendation() {
		return recommendation;
	}
	
}

