package model;

public class Recyclable extends Residue{
	
	public final String P="paper";
	public final String PB="paperboard";
	public final String G="glass";
	public final String PL="plastic";
	public final String M="metal";
	
	private String type;
	private String description;
	private boolean usable;

	public Recyclable(String pindicator, String pname, String porigin, String pcolor, int pdesTime, String pProduct, String pType, String pdescription){

		super(pindicator, pname, porigin, pcolor, pdesTime,pProduct);

		type=pType;
		description=pdescription;
		usable=isUsable();
	}
	
	public double getHarm() {
		return super.getHarm();
	}
	
	public boolean isUsable() {
		
		boolean pusable=false;
		
		if(description!=null) {
			pusable=true;
		}
		
		return pusable;
	}

	public void recalculateHarm() {
		
		double harmLevel=0.0;
	
		harmLevel=super.getHarm();
		harmLevel-=0.02;
		
		super.setHarm(harmLevel);
	}
	
	
	public String toString() {
		
		String usabled="";
		
		if(usable==true)
			usabled="Yes";
		else
			usabled="No";
		
		return "\n indicator="+super.getIndicator() + "\n name=" + super.getName() + "\n origin="+ super.getOrigin()+ "\n color="+ super.getColor() + "\n type=" + type + "\n description=" + description + "\n It  is usable?=" + usabled + "\n ___________________________";
	}
	
}
