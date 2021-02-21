package trainProject;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TrainApplication {
	
	public static LocalDate dateInput(String input)
	{
		DateTimeFormatter dateFormat=DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date=LocalDate.parse(input, dateFormat);
		return date;
	}

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("===========Train Application========");
		
		//Train = new Train(0, null, null, null, 0);
		
		System.out.println("Enter the train number : ");
		int trainNo = scanner.nextInt();
		
		System.out.println("Enter the train name : ");
		String trainName = scanner.next();
		
		
		System.out.println("Enter travel date ");
		//String travelDate = scanner.next();
		/*
		 * LocalDate date = LocalDate.parse(travelDate, date);
		 * System.out.println("travel date "+date);
		 */
		String input=scanner.next();
		LocalDate travelDate=dateInput(input);
		
		System.out.println("Enter the number of passengers : ");
		int totalPass = scanner.nextInt();
		
		Train train = new Train(trainNo,trainName,"Pune","Mumbai",2500);
		Ticket ticket = new Ticket(travelDate,train);
		
		
		for(int i=1;i<=totalPass;i++)
		{
			System.out.println("Enter your Name : ");
			String name = scanner.next();
			
			scanner.nextLine();
			
			
			System.out.println("Enter your Age : ");
			int age = scanner.nextInt();
			
			scanner.nextLine();
			
			System.out.println("Enter your Gender(M/F) : ");
			char gender = scanner.next().charAt(0);
			
			
			
		}
		System.out.println("Ticket confirmed : "+ticket.generatePNR());
		
		
	}

}
