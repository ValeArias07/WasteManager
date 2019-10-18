package model;

public class Recyclable extends Residue{
	
	public final String P="paper";
	public final String PB="paperboard";
	public final String G="glass";
	public final String PL="plastic";
	public final String M="metal";
	
	private String type;
	private String description;

	public Recyclable(String pindicator, String pname, String porigin, String pcolor, int pdesTime, String pProduct, String pType){

		super(pindicator, pname, porigin, pcolor, pdesTime,pProduct);

		type=ptype;
		description=pdescription;

	}
	

}
