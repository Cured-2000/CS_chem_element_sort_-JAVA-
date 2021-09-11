import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Chem {//NICHOLAS ESPINOSA

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//define new hashmap
		HashMap<String, Element> element = new HashMap<String, Element>();
		Scanner input = new Scanner(System.in);
		boolean loop = true;
		//prints menu
		System.out.println("Select an option number from the following menu:\r\n" + 
				"Option  Action\r\n" + 
				"------  -----------------------------------------\r\n" + 
				"   1    Add a chemical element to the collection.\r\n" + 
				"   2    Search for an element in the collection.\r\n" + 
				"   3    Delete an element from the collection.\r\n" + 
				"   4    Load elements from a text file.\r\n" + 
				"   5    Display the collection sorted by symbol.\r\n" + 
				"   6    Quit.\r\n" + 
				"Enter your choice number 1-6:" + 
				"");
		//while loop keeps the program running repeatedly
		
		while (loop) {
			int x ;// validates number imput
				while (!input.hasNextInt()) {
			        System.out.println("That's not a number!");
			        input.next(); 
			    }	
				x= input.nextInt();

			switch (x) {
			case 1://adding a new element
				System.out.println("enter a element symbol");
				String chSym = input.next();
				System.out.println("enter element name");
				String elName = input.next();
				System.out.println("enter a atomic number");
				int atmNum;
				while (!input.hasNextInt()) {
			        System.out.println("That's not a number!");
			        input.next(); 
			    }	
				atmNum = input.nextInt();
				System.out.println("enter a atomic wieght");
				double atmWie;
				while (!input.hasNextDouble()) {
			        System.out.println("That's not a number!");
			        input.next(); 
			    }
				atmWie = input.nextDouble();
				Element x1 = new Element(elName, atmNum, atmWie);
				element.put(chSym, x1);
				System.out.println(" the element "+elName+" has been added to the map" );
				break;
			case 2:// search element
				System.out.println("enter a element symbol");
				String sKey = input.next();
				if (element.containsKey(sKey)) {
					System.out.println(element.get(sKey));
				} else {
					System.out.println(sKey + " is not in the map");
				}
				break;
			case 3:// delete element
				System.out.println("enter a element symbol");
				String delKey = input.next();
				if (element.containsKey(delKey)) {
					element.remove(delKey);
					System.out.println(delKey+"has been removed!");
				} else {
					System.out.println(delKey + " is not in the map");
				}
				break;
			case 4:// reads and adds elements from a file 

				ArrayList<Element> readElm = new ArrayList <Element>();//stores keys 
				ArrayList<String> rKey = new ArrayList <String>();//tracks elements 
				File file = new File("elements.txt");
				try {
					Scanner inputFile = new Scanner(file);
					while (inputFile.hasNext()) {
						String line = inputFile.nextLine();
						String[] split = line.split(",");
						rKey.add(split[0]);//store key values
						String rName = split[1];
						int rAtmnum = Integer.parseInt(split[2].trim());
						double rAtmwei = Double.parseDouble(split[3].trim());
						readElm.add(new Element(rName, rAtmnum, rAtmwei)) ;

					}
					//places keys and elements in hashmap(element)
					for(int i=0;i<rKey.size();i++) {
						element.put(rKey.get(i), readElm.get(i));
					}
					System.out.println("elements succesfully added!");
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					System.out.println("elements not read!");
					e.printStackTrace();
				}
				break;
			case 5:// sorts and prints hashmap via treemap
				TreeMap<String,Element> sortElements = new TreeMap<String,Element>();
				sortElements.putAll(element);
				System.out.println("                      Atomic   Atomic\r\n" + 
						"Symbol  Name          Number   Weight\r\n" + 
						"------  ------------  ------  -------\r\n" + 
						"");
				Iterator it = sortElements.entrySet().iterator();
				//goes through and formats tree map
				while(it.hasNext()){
					  Map.Entry pairs = (Map.Entry) it.next();
					  System.out.println(" "+pairs.getKey() + "	" + pairs.getValue());
					}
				break;
			case 6:// exits program
				System.out.println("goodbye...");
				loop = false;
				break;
			default:// validates number input 1-6
				System.out.println(x + " is not a number between 1 and 6");
				break;
			}
		}
	}

}
