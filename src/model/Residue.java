package model;

public class abstract Residue {
	
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
	
	public Residue(String pindicator, String pname, String porigin, String pcolor, int pdesTime, String pProduct){

		indicator=pindicator;
		name=pname;
		origin=porigin;
		color=pcolor;
		desTime=pdesTime;
		product=pProduct;

	}

	public  void getIndicador(){
		return indicator;
	}

	public void getName(){
		return name;
	}

}
