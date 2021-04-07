public class TestArrayOfArrays {
	public static final int SUN = 0;
	public static final int MON = 1;
	public static final int TUE = 2;
	public static final int WED = 3;
	public static final int THU = 4;
	public static final int FRI = 5;
	public static final int SAT = 6;
	
	private static String arrayToString(String[] array) {

		if (array == null)
			return null;

		StringBuffer buffer = new StringBuffer();

		buffer.append("[");

		for (int i = 0; i < array.length; i++) {

			buffer.append('\"').append(array[i]).append('\"');

			if (i < array.length - 1) {
				buffer.append(", ");
			}
		}

		buffer.append(']');

		return buffer.toString();
	}

	public static void main (String[] args) {
		String[][] myWeeklyTasks;
		
		myWeeklyTasks = new String[7][]; // only one dimension specified!
		
		myWeeklyTasks[SUN] = new String[0];
	
		myWeeklyTasks[MON] = new String[4];
		myWeeklyTasks[MON][0] = "Course Prep";
		myWeeklyTasks[MON][1] = "Teaching";
		myWeeklyTasks[MON][2] = "Office Hour";
		myWeeklyTasks[MON][3] = "Misc Meetings";
	
		myWeeklyTasks[TUE] = new String[2];
		myWeeklyTasks[TUE][0] = "Student Meetings";
		myWeeklyTasks[TUE][1] = "Research";
	
		myWeeklyTasks[WED] = new String[2];
		myWeeklyTasks[WED][0] = "Course Prep";
		myWeeklyTasks[WED][1] = "Research";
			
		myWeeklyTasks[THU] = new String[3];
		myWeeklyTasks[THU][0] = "Teaching";
		myWeeklyTasks[THU][1] = "Other Meetings";
		myWeeklyTasks[THU][2] = "Research";

	
		myWeeklyTasks[FRI] = new String[1];
		myWeeklyTasks[FRI][0] = "Research";

		myWeeklyTasks[SAT] = new String[1];
		myWeeklyTasks[SAT][0] = "Grocery Shopping";
		

		// Notice:
		// 1) myWeeklyTasks[<DAY>] is passed to a method whose parameter is String[]
		// 2)  myWeeklyTasks[<DAY>] has a different length depending on what <DAY> is
		System.out.println("Sun: " + arrayToString(myWeeklyTasks[SUN]));
		System.out.println("Mon: " + arrayToString(myWeeklyTasks[MON]));
		System.out.println("Tue: " + arrayToString(myWeeklyTasks[TUE]));
		System.out.println("Wed: " + arrayToString(myWeeklyTasks[WED]));
		System.out.println("Thu: " + arrayToString(myWeeklyTasks[THU]));
		System.out.println("Fri: " + arrayToString(myWeeklyTasks[FRI]));
		System.out.println("Sat: " + arrayToString(myWeeklyTasks[SAT]));
	}
}