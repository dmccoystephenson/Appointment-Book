
public class Appointment {
	public String description;
	public int year;
	public int month;
	public int day;
	boolean daily = false;
	boolean monthly = false;
	
	public Appointment(String des, int y, int m, int da) {
		description = des;
		year = y;
		month = m;
		day = da;
	}
	
	public boolean isItToday(int yearX, int monthX, int dayX) {
		boolean today = false;
		
		if ((yearX == year || monthly == true || daily == true) && (monthX == month || monthly == true || daily == true) && (dayX == day || daily == true)) {
			today = true;
		}
		
		return today;
	}
	
}
