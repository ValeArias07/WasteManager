package model;

public class Residue{
	
	
	static final String IND="industrie";
	static final String DOM="dominicilie";
	static final String MUN="municipal";
	static final String CONS="construction";
	static final String HOS="hospitalary";
	
	private String indicator;
	private String name;
	private String origin;
	private String color;
	private int desTime;
	private double harmfulLevel;
	
	private Product product;
	
	public Residue(String pindicator, String pname, String porigin, Product productAssociated, String pcolor, int pdesTime){

		indicator=pindicator;
		name=pname;
		origin=porigin;
		color=pcolor;
		desTime=pdesTime;
		product= productAssociated;
		harmfulLevel=calculateHarm();
		

	}

	public  String getIndicator(){
		return indicator;
	}

	public String getName(){
		return name;
	}

	public String getOrigin() {
		return origin;
	}

	public String getColor() {
		return color;
	}

	public int getDesTime() {
		return desTime;
	}

	public double getHarm() {
		return harmfulLevel;
	}

	public double setHarm(double harmLevel) {
		harmfulLevel=harmLevel;
		return harmfulLevel;
	}
	
	public double calculateHarm() {
		
		double pharmful=0.0;
		
		if(origin.equals(IND)) { 
			pharmful=desTime*0.10;
		}
		else
			if(origin.equals(DOM)) {
				pharmful=desTime*0.08;
			}
			else
				if(origin.equals(MUN)) {
					pharmful=desTime*0.15;	
				}
				else
					if(origin.equals(CONS)) {
						pharmful=desTime*0.05;	
					}
					else
						if(origin.equals(HOS)) {
							pharmful=desTime*0.12;
						}
							
		return pharmful;
	}

	
}
