package model;

public class Residue{
	
	
	public final String IND="industrie";
	public final String DOM="dominicilie";
	public final String MUN="municipal";
	public final String CONS="construction";
	public final String HOS="hospitalary";
	
	private String indicator;
	private String name;
	private String origin;
	private String color;
	private int desTime;
	private String product;
	private double harmfulLevel;
	
	public Residue(String pindicator, String pname, String porigin, String pcolor, int pdesTime, String pProduct){

		indicator=pindicator;
		name=pname;
		origin=porigin;
		color=pcolor;
		desTime=pdesTime;
		product=pProduct;
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
	public String getProduct() {
		return product;
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
