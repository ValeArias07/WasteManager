package model;

public class Biodegradable extends Residue implements Usable{
	
	private boolean composting;
	private boolean usable;

	public Biodegradable (String pindicator, String pname, String porigin, Product productAssociated, String pcolor, int pdesTime,boolean pcomposting){
	super( pindicator,pname,porigin,productAssociated, pcolor,pdesTime);

	composting=pcomposting;
	usable=isUsable();
	
	}

	public boolean getComposting() {
		return composting;
	}
	
	public double getHarm() {
		return super.getHarm();
	}
	
	public void recalculateHarm() {
		
		double harmLevel=0.0;
		harmLevel=super.getHarm();
		
		if(composting==true) {
			harmLevel-=0.01;
		}
		
		super.setHarm(harmLevel);
	}
	public boolean isUsable() {
		
		boolean pusable=false;
		int desTime=super.getDesTime();
		
		if(desTime<360 && composting==true) {
			pusable=true;
		}
		
		return pusable;
	}
	public String toString() {
		
		String compostable="";
		String usabled="";
		
		if(composting==false)
			compostable="No";
		else
			compostable="Yes";
		
		if(usable==true)
			usabled="Yes";
		else
			usabled="No";
		
		return "\n indicator: " +super.getIndicator() + "\n name: " + super.getName() + "\n origin: "+ super.getOrigin()+ "\n color: "+ super.getColor() + "\n descomposition time: " +super.getDesTime() + "\n It  is compostable?: " + compostable  + "\n It  is usable?: " + usabled + "\n ___________________";
	}
	
}
