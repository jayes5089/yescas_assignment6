package a6;
/* Jason Yescas
   Object-Oriented Programming : CPSC-24500-001
   4/8/2024
   Driver Class */

import java.util.Scanner;

// Menu to interact with every class in a6 package
public class Driver {
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(System.in);
		Nodes nodes = new Nodes();
		boolean exit = false;
		
		while(!exit) {
			System.out.println("1. Fill\n2. Clear\n3. Count Nodes\n4. Count ThreeDNodes\n5. Sort\n6. Display\n7. Exit");
			int choice = scan.nextInt();
			
			switch (choice) {
			case 1:
				System.out.println("Enter size: ");
				int size = scan.nextInt();
				nodes.fill(size);
				break;
			case 2:
				nodes.clear();
				break;
			case 3:
				System.out.println("Nodes count; "+ nodes.countNodes());
				break;
			case 4:
				System.out.println("ThreeDNodes count: "+ nodes.countThreeDNodes());
				break;
			case 5:
				nodes.sort();
				break;
			case 6:
				System.out.println(nodes);
				break;
			case 7:
				exit = true;
				break;
			default:
				System.out.println("Invalid choice. Please enter a number from 1 to 7.");
				break;
			}
		}
	}

}
