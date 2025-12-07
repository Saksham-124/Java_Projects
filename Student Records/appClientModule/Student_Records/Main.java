package Student_Records;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		StudentDataFunction DatabaseOperations = new StudentDataFunction();
		
		int choice;
		
		do {
			
			System.out.println("\n--------------- Student Record System ---------------");
			
			System.out.println("\n1. Student Data Insert");
			
			System.out.println("\n2. Show Single Data Student");
			
			System.out.println("\n3. Show All Data Student");
			
			System.out.print("\nEnter Your Choice : ");
			
			choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice)
			{
			
				// Insert Data in SQL
				case 1 :
					
					System.out.print("\nEnter Your Student ID : ");
					int sid = sc.nextInt();
					
					sc.nextLine();
	
					System.out.print("Enter Your Name : ");
					String sname = sc.nextLine();
					
					System.out.print("Enter Your Course : ");
					String scourse = sc.nextLine();
					
					System.out.print("Enter Your Email ID : ");
					String semailid = sc.nextLine();
					
//					System.out.println(sid);
//					System.out.println(sname);
//					System.out.println(scourse);
//					System.out.println(semailid);
					
					boolean done = DatabaseOperations.insert(new StudentInformation(sid, sname, scourse, semailid));
					
					if(done) {
						
						System.out.println("\nData Insert Successfully !");
					
					}
					
					else {
						
						System.out.println("\nFailed to Insert Data !");
					
					}
					
					break;
					
				
				// Show Single Data
				case 2 :
					
					System.out.print("\nEnter Your Student ID : ");
					
					int sid1 = sc.nextInt();
					
					StudentInformation student = DatabaseOperations.showData(sid1);
					
					if (student != null) {
						
						System.out.println("\nStudent ID : " + student.studentId);
						
						System.out.println("Student Name : " + student.studentName);
						
						System.out.println("Student Course : " + student.studentCourse);
						
						System.out.println("Student Email : " + student.studentEmailId);
					}
					
					else {
						
						System.out.println("\nStudent Not Found !");
					}
					
					break;
					
					
				// Show All Data
				case 3 :
					
					int count = 1;
					
					System.out.println("\nAll Students");
					
					for (StudentInformation si : DatabaseOperations.showAll()) {
						
						System.out.println("\nStudent : " + count);
						
						System.out.println("Student ID : " + si.studentId);
						
						System.out.println("Student Name : " + si.studentName);
						
						System.out.println("Student Course : " + si.studentCourse);
						
						System.out.println("Student Emai ID : " + si.studentEmailId);
						
						count++;
					}
					
					break;
					
				
//				// Update Data
//				case 4 :
//					
//					System.out.print("\nEnter Your Student ID : ");
//					
//					int sid2 = sc.nextInt();
//					
//					StudentInformation oldData = DatabaseOperations.showData(sid2);
//					
//					if (oldData == null) {
//						
//						System.out.println("Data is not found !!");
//						
//					}
//					
//					else {
//						
//						System.out.println("OLD Data : " + oldData.studentId + oldData.studentName + oldData.studentCourse + oldData.studentEmailId);
//						
//						System.out.println("New Name : ");
//						String newName = sc.next();
//						
//						System.out.println("New Course : ");
//						String newCourse = sc.next();
//						
//						System.out.println("New Email ID : ");
//						String newEmailId = sc.next();
//						
//					}
			}
		
		} while(choice != 3);
		
		sc.close();
		
	}

}
