package ui;
import java.util.Scanner;
import model.Controler;

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
/** This method is the main's menu. Here we receive all the information that we need.
 */
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
	
/** This method receive the info that we need to create a product
 * @return message is the message that say if the product was created or not
 */
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
	
/** This method create, if it does not exists, the associate product of a residue.
 * @param pProname is the name of the product that doesnt exist
 * @return message is the message that say if the product was created or not
 */
public String createProductWithName(String pProname) {
		
		System.out.println("Write the id of the product");
		String pid=lectorL.nextLine();
		
		System.out.println("Write the description of the product");
		String pProdescription=lectorL.nextLine();
		
		String message=controler.addProduct(pProname, pid, pProdescription);
		
		return message;
	}

/** This method receive the information that we need to create a residue.
 * @return message is the message that say if the residue was created or not
 */
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
				
		while(optionR!=1 && optionR!=2 && optionR!=3) {
			System.out.println("Incorrect option. Write again what residue do you want to register? \n 1. Biodegradable \n 2. Recyclable \n 3. Inert ");
			optionR=lectorN.nextInt();
		}
			
			System.out.println("Write the name");
			String pname=lectorL.nextLine();
			
			System.out.println("Write the indicator");
			String pindicator=lectorL.nextLine();
			
			String porigin=origin();
			
			System.out.println("Write the color");
			String pcolor=lectorL.nextLine();
			
			System.out.println("Write the time of descomposition");
			int pdesTime=lectorN.nextInt();
			
			System.out.println(controler.ubicationR());
			
				switch(optionR) {
				
				case(1):
					
					System.out.println("It is composting");
					
					String ans=lectorL.nextLine(); 
					
					boolean pcomposting;
					
					if(ans.equalsIgnoreCase("no")) 
						pcomposting=false;
							else
								pcomposting=true;	
					
						message=controler.addResiduo(proname,pindicator, pname, porigin,pcolor, pdesTime, pcomposting);
						break;
						
				case(2):

						String pType=type();
						System.out.println("Write the description");
						String pdescription=lectorL.nextLine();

						message=controler.addResiduo(proname,pindicator, pname, porigin, pcolor, pdesTime, pType, pdescription);	
						break;

				case(3):

						System.out.println("Write the recommendation");
						String pRecommendation=lectorL.nextLine();

						message=controler.addResiduo(proname,pindicator, pname, porigin, pcolor, pdesTime, pRecommendation);	
						break;
				}
		
		return message;
	}
	
/** This method show the information of a residue depending the name or id of it
 * @return info is the message that conteins all the information about the residue founded.
 */
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
	
/** This method receive the information about the origin of the residue using the constants of the class Product
 * @return porigin is the origin of the residue
 */
	public String origin() {
		String porigin=" ";
		int option=0;
		
		System.out.println("Write the origin. "
				+ "\n 1." + controler.getInd() 
				+ "\n 2." + controler.getDom() 
				+ "\n 3." + controler.getMun() 
				+ "\n 4." + controler.getCons() 
				+ "\n 5." + controler.getHos());
		
		option=lectorN.nextInt();
		
		while(option!=1 && option!=2 && option!=3 && option!=4 && option!=5) {	
			System.out.println("Wrong option. Please, write again the origin."
					+ "\n 1." + controler.getInd() 
					+ "\n 2." + controler.getDom() 
					+ "\n 3." + controler.getMun() 
					+ "\n 4." + controler.getCons() 
					+ "\n 5." + controler.getHos());
			option=lectorN.nextInt();
		}
		
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

/** This method receive the information about the origin of the Recyclable residue using the constants of the class Recyclable
 * @return pType is the type of the Recyclable product
 */
	public String type() {
		
		System.out.println("Write the type."
				+ "\n 1." + controler.getP() 
				+ "\n 2." + controler.getPb() 
				+ "\n 3." + controler.getG() 
				+ "\n 4." + controler.getPl() 
				+ "\n 5." + controler.getM());
		int  optionT=lectorN.nextInt();
		
		while(optionT!=1 && optionT!=2 && optionT!=3 && optionT!=4 && optionT!=5) {
			System.out.println("Wrong option, please write the type again."
					+ "\n 1." + controler.getP() 
					+ "\n 2." + controler.getPb() 
					+ "\n 3." + controler.getG() 
					+ "\n 4." + controler.getPl() 
					+ "\n 5." + controler.getM());
			optionT=lectorN.nextInt();
		}
		String pType="";
		
		switch(optionT) {
		case(1):
			pType=controler.getP();
			break;
		case(2):
			pType=controler.getPb();
			break;
		case(3):
			pType=controler.getG();
			break;
		case(4):
			pType=controler.getPl();
			break;
		case(5):
			pType=controler.getM();
			break;
			
		}
		return pType;
	}
}
 
