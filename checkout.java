// Created by Ross Taylor
import java.util.Scanner;
public class checkout{

    public static void main(String[] args)throws Exception{
    	checkout program = new checkout();
		String[] list = program.scanValues();
		int price = program.calculatePrice(list);
		program.printPrice(price);
    }
	
    /**
     * Method to scan values entered and places value into an array.
     * @return
     */
    private String[] scanValues(){
    	Scanner scan = new Scanner(System.in);
		System.out.println("Please input the items you are buying.");
		String purchase = scan.nextLine();
		String[] list = purchase.trim().split("\\s+");
		scan.close();
		return list;
		
    }
    
	/**
	 * Method that calculates the price of apples and oranges in total.
	 */
    private int calculatePrice(String[] list){
		String apple = "apple";
		String orange = "orange";
		int numberOfApples = 0;
		int discountApples = 0;
		int numberOfOranges = 0;
		int discountOranges = 0;
		int price = 0;
		for(int i = 0; i < list.length; i++){
			if(list[i].toLowerCase().equals(apple)){
				numberOfApples++;
			}
			else if(list[i].toLowerCase().equals(orange)){
				numberOfOranges++;
			}
		}
		// following lines will only trigger if customer is applicable for discount.
		if(numberOfApples >= 2){
		    discountApples = numberOfApples/2; 
		}
		if(numberOfOranges >= 3){
		    discountOranges = numberOfOranges/3; 
		}
		price = ((numberOfApples * 60) - (discountApples * 60)) + ((numberOfOranges * 25) - (discountOranges *25));
		return price;
    }
    
    /**
     * Method responsible for printing the final output price.
     * @param price
     */
    private void printPrice(int price){
		int pricePounds = price / 100;
		int pricePence = price % 100;
		System.out.println(String.format("Total Cost: £%d.%02d", pricePounds, pricePence));
		
	}
	
}