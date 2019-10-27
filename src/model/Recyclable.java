package model;

public class Recyclable extends Residue implements Usable{
	
	static final String P="Paper";
	static final String PB="Paperboard";
	static final String G="Glass";
	static final String PL="Plastic";
	static final String M="Metal";
	
	private String type;
	private String description;
	private boolean usable;

	public Recyclable(String pindicator, String pname, String porigin,Product productAssociated, String pcolor, int pdesTime, String pType, String pdescription){

		super( pindicator,pname,porigin,productAssociated, pcolor,pdesTime);

		type=pType;
		description=pdescription;
		usable=isUsable();
	}
	
	public double getHarm() {
		return super.getHarm();
	}
/** This method determinate if the recyclable residue is usable or not
 * @return pusable determinate if the residue recyclable is usable or not depending the description
 */
	public boolean isUsable() {
		
		boolean pusable=false;
		
		if(description!=null) {
			pusable=true;
		}
		
		return pusable;
	}
/** This method recalculate the harmful level or the residue Recyclable
 */
	public void recalculateHarm() {
		
		double harmLevel=0.0;
	
		harmLevel=super.getHarm();
		harmLevel-=0.02;
		
		super.setHarm(harmLevel);
	}
/** This toString method contains all the information about the objetc Recyclable
 */
	public String toString() {
		
		String usabled="";
		
		if(usable==true)
			usabled="Yes";
		else
			usabled="No";
		
		return "\n indicator: " + super.getIndicator() + "\n name: " + super.getName() + "\n origin: "+ super.getOrigin()+ "\n color: "+ super.getColor() + "\n descomposition time:  " +super.getDesTime() + "\n type: " + type + "\n description: " + description + "\n It  is usable?: " + usabled + "\n___________________";
	}
	
}
