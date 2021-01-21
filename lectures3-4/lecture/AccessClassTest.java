
public class AccessClassTest {

	public static void main(String[] args){

		AccessClass tc1 = new AccessClass();
		AccessClass tc2 = new AccessClass();
		
		tc1.instanceMethod();
		tc1.instanceMethod();
		tc1.instanceMethod();

		tc2.instanceMethod();
		

		System.out.println(" For tc1, instanceMember is " 
			+ tc1.instanceMember + " and classMember is "
			+ tc1.classMember);
		System.out.println(" For tc2, instanceMember is " 
			+ tc2.instanceMember + " and classMember is "
			+ tc2.classMember);

		System.out.println("Now call classMethod on tc1");
		
		tc1.classMethod();

		System.out.println(" For tc1, instanceMember is " 
			+ tc1.instanceMember + " and classMember is "
			+ tc1.classMember);
		System.out.println(" For tc2, instanceMember is " 
			+ tc2.instanceMember + " and classMember is "
			+ tc2.classMember);
			
		System.out.println("Now call classMethod on tc2");

		tc2.classMethod();

		System.out.println(" For tc1, instanceMember is " 
			+ tc1.instanceMember + " and classMember is "
			+ tc1.classMember);
		System.out.println(" For tc2, instanceMember is " 
			+ tc2.instanceMember + " and classMember is "
			+ tc2.classMember);
	}
}
