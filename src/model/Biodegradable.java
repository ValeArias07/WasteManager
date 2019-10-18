package model;

public class Biodegradable extends Residue{
	
	private boolean composting;

	public Biodegradable(String pindicator, String pname, String porigin, String pcolor, int pdesTime, String pProduct, boolean pcomposting){

	super(pindicator, pname, porigin, pcolor, pdesTime,pProduct);

	composting=pcomposting;
	}
		
}
