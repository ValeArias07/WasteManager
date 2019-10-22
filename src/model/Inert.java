package model;

public class Inert extends Residue{
	
	private String recommendation;

	public Inert(String pindicator, String pname, String porigin, String pcolor, int pdesTime, String pProduct, String pRecommendation){

		super(pindicator, pname, porigin, pcolor, pdesTime,pProduct);
		
		recommendation=pRecommendation;

	}

	public String getRecommendation() {
		return recommendation;
	}

	@Override
	public String toString() {
		return "\n indicator="+super.getIndicator() + "\n name=" + super.getName() + "\n origin="+ super.getOrigin()+ "\n color="+ super.getColor() + "\n recommendation=" + recommendation + "\n ___________________________";
	}

}
