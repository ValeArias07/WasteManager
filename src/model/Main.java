package model;
import java.util.Scanner;


public class Main {
	
	private Controler controler;
	private Scanner lectorL;
	private Scanner lectorN;
	
	public static void main (String args[]) {
		
		Main main = new Main();
		main.menu();
		
	}
	
	public Main() {
	
	lectorN= new Scanner(System.in);
	lectorL= new Scanner(System.in);
	
	System.out.println("Welcome to the Waste Manager Pro. Please, write the number of products that you want to register");
	
	int n=lectorN.nextInt();
	
	controler= new Controler(n);
	}
	
	public void menu() {
		int option=0;
		while(option!=7) {
			
			System.out.println("Write the option that you want. "
					+ "\n 1.Create an product and it Residues. "
					+ "\n 2. Create a Residue. "
					+ "\n 3. Search an Residue giving the name or the product id. "
					+ "\n 4. Show all the products registered."
					+ "\n 5. Generate a report with all the residues"
					+ "\n 6. show from the most harmful to the least harmful"
					+ "\n 7. exit");
			
			option=lectorN.nextInt();
			
			switch(option) {
			
			case(1):
				System.out.println(createP());
				break;
				
			case(2):
				System.out.println(createResidues());
				break;
			
			case(3):
				System.out.println(searchNameOrId());
				break;
			
			case (4):
				System.out.println(controler.showAllP()); 
				break;
				
			case(5):
				System.out.println(controler.showAllR());
			}	
		}
			
	}
	
	public String createP() {
		
		System.out.println("Write the name of the product");
		String pProname=lectorL.nextLine();
		
		System.out.println("Write the id of the product");
		String pid=lectorL.nextLine();
		
		System.out.println("Write the description of the product");
		String pProdescription=lectorL.nextLine();
		
		String message=controler.addProduct(pProname, pid, pProdescription);
		
		return message;
	}
public String createProductWithName(String pProname) {
		
		System.out.println("Write the id of the product");
		String pid=lectorL.nextLine();
		
		System.out.println("Write the description of the product");
		String pProdescription=lectorL.nextLine();
		
		String message=controler.addProduct(pProname, pid, pProdescription);
		
		return message;
	}

	public String createResidues() {
		String message="";
		
		System.out.println("Write next information about the Residue");
		
		System.out.println("Write the name of the product associated");
		String proname=lectorL.nextLine();
		
		if(controler.searchPositionPname(proname)==-1) {
			System.out.println("There is none product with that name. Lets add a new product, write all the information about it");
			createProductWithName(proname);
		}
		
			System.out.println("What kind of residue do you want to register? \n 1. Biodegradable \n 2. Recyclable \n 3. Inert ");
			int optionR=lectorN.nextInt();
			
			System.out.println("Write the name");
			String pname=lectorL.nextLine();
			
			System.out.println("Write the indicator");
			String pindicator=lectorL.nextLine();
			
			String porigin=origin();
			
			System.out.println("Write the color");
			String pcolor=lectorL.nextLine();
			
			System.out.println("Write the time of descomposition");
			int pdesTime=lectorN.nextInt();
			
			System.out.println("OJO CON UBI" + controler.ubicationR());
			
				switch(optionR) {
				
				case(1):
					
					System.out.println("It is composting");
					
					String ans=lectorL.nextLine(); 
					
					boolean pcomposting;
					
					if(ans.equalsIgnoreCase("no")) 
						pcomposting=false;
							else
								pcomposting=true;	
					
						message=controler.addResiduo(pindicator, pname, porigin,pcolor, pdesTime, pcomposting);
						break;
						
				case(2):

						System.out.println("Write the type");
						String pType=lectorL.nextLine();
							
						System.out.println("Write the description");
						String pdescription=lectorL.nextLine();

						message=controler.addResiduo(pindicator, pname, porigin, pcolor, pdesTime, pType, pdescription);	
						break;

				case(3):

						System.out.println("Write the recommendation");
						String pRecommendation=lectorN.nextLine();

						message=controler.addResiduo(pindicator, pname, porigin, pcolor, pdesTime, pRecommendation);	
						break;
				}
		
		return message;
	}
	
	public String searchNameOrId() {
		
		String info="";
		
		System.out.println("How you want to search the residue, using name or id?");
		String option=lectorL.nextLine();
		
		if(option.equalsIgnoreCase("name")) {
			System.out.println("Write the name");
			String pname=lectorL.nextLine();
			
			 info=controler.searchName(pname);
		}
		else
			if((option.equalsIgnoreCase("id"))) {
				System.out.println("Write the id");
				String id=lectorL.nextLine();
				
			 info=controler.searchId(id);	
	}
		return info;
	}
	
	public String origin() {
		
		System.out.println("Write the origin. \n 1. Industrie \n 2. Domicilie \n 3. Municipal \n 4. Construction \n 5. Hospitalary");
		int option=lectorN.nextInt();
		String porigin=" ";
		
		switch(option) {
		
		case(1):
			porigin=controler.getInd();
			break;
		case(2):
			porigin=controler.getDom();
			break;
		case(3):
			porigin=controler.getMun();
			break;
		case(4):
			porigin=controler.getCons();
			break;
		case(5):
			porigin=controler.getHos();
			break;
		}
		return porigin;
	}
	
}
 
