import java.util.*;
import java.io.*;


public class Tester {
	
	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Appointment> apps = new ArrayList<Appointment>();
		
		Appointment therapy = new Monthly("Go to Therapy.", 2016, 10, 15);
		Appointment brushTeeth = new Daily("Go brush your teeth.", 2016, 1, 1);
		Appointment breakfastAtTiffanys = new OneTime("Go eat breakfast with Tiffany.", 2016, 12, 28);
		Appointment goToWork = new Daily("Go to work.", 2016, 1, 1);
		Appointment graduate = new OneTime("Graduate!", 2017, 5, 20);
		
		apps.add(therapy);
		apps.add(brushTeeth);
		apps.add(breakfastAtTiffanys);
		apps.add(goToWork);
		apps.add(graduate);
		
		boolean alwaysDo = true;
		
		while (alwaysDo == true) {
			System.out.println("What would you like to do? (ADD to add an appointment, DATE to check a date, SAVE to save, LOAD to load)");
			String next = sc.next();
			
			if (next.equalsIgnoreCase("DATE")) {
				System.out.println("Enter the year.");
				int enteredYear = sc.nextInt();
				System.out.println("Enter the month.");
				int enteredMonth = sc.nextInt();
				System.out.println("Enter the day.");
				int enteredDay = sc.nextInt();
				
				for (int i = 0; i < apps.size(); i++) {
					if (apps.get(i).isItToday(enteredYear,  enteredMonth,  enteredDay) == true) {
						System.out.println(apps.get(i).description);
					}
				}	
			}
			
			if (next.equalsIgnoreCase("ADD")) {				
				System.out.println("What is the description?");
				String des1 = sc.next();	
				
				System.out.println("What is the year?");
				int y1 = sc.nextInt();
				
				System.out.println("What is the month?");
				int m1 = sc.nextInt();
				
				System.out.println("What is the day?");
				int d1 = sc.nextInt();	
				
				System.out.println("Is it MONTHLY, DAILY, or ONETIME?");
				String kindOfApp = sc.next();	
				
				if (kindOfApp.equalsIgnoreCase("MONTHLY")) {
					Appointment userAdded = new Monthly(des1, y1, m1, d1);
					apps.add(userAdded);
				}
				
				if (kindOfApp.equalsIgnoreCase("DAILY")) {
					Appointment userAdded = new Daily(des1, y1, m1, d1);
					apps.add(userAdded);
				}
				
				if (kindOfApp.equalsIgnoreCase("ONETIME")) {
					Appointment userAdded = new OneTime(des1, y1, m1, d1);
					apps.add(userAdded);
				}
				
			}
			
			if (next.equalsIgnoreCase("SAVE")) {	
				FileWriter fw = new FileWriter("C:\\Users\\37558\\Desktop\\workspace2\\Appointment Book\\src\\savefile.txt");
				PrintWriter output = new PrintWriter(fw);
				
				for (int i = 5; i < apps.size(); i++) {
					output.println(apps.get(i).description);
					output.println(apps.get(i).year);
					output.println(apps.get(i).month);
					output.println(apps.get(i).day);
					
					if (apps.get(i).daily == true) {
						output.println("daily");
					}
					
					if (apps.get(i).monthly == true) {
						output.println("monthly");
					}
					
					if (apps.get(i).monthly == false && apps.get(i).daily == false) {
						output.println("onetime");
					}
				}
				
				output.close();
				fw.close();
				
			}
			
			if (next.equalsIgnoreCase("LOAD")) {	
				Scanner sf = new Scanner(new File("C:\\Users\\37558\\Desktop\\workspace2\\Appointment Book\\src\\savefile.txt"));
				
				ArrayList<String> text = new ArrayList<String>();
				
				while (sf.hasNext()) {
					text.add(sf.nextLine());
				}
				
				String des2;
				int year2;
				int month2;
				int day2;
				String appKind;
				
				System.out.println(text.size());
				
				int i = 0;
				while (i < text.size()) {
					des2 = text.get(i + 0);
					year2 = Integer.valueOf(text.get(i + 1));
					month2 = Integer.valueOf(text.get(i + 2));
					day2 = Integer.valueOf(text.get(i + 3));
					appKind = text.get(i + 4);
					i = i + 5;
					
					if (appKind.equalsIgnoreCase("MONTHLY")) {
						Appointment userAdded = new Monthly(des2, year2, month2, day2);
						apps.add(userAdded);
					}
					
					if (appKind.equalsIgnoreCase("DAILY")) {
						Appointment userAdded = new Daily(des2, year2, month2, day2);
						apps.add(userAdded);
					}
					
					if (appKind.equalsIgnoreCase("ONETIME")) {
						Appointment userAdded = new OneTime(des2, year2, month2, day2);
						apps.add(userAdded);
					}
				}
				
				sf.close();
			}
			
			System.out.println(" ");
		}
		
		
	}
	
}
