package trainProject;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.TreeMap;

public class Ticket {
	
	private int counter;
	private String pnr;
	private LocalDate travelDate;
	private Train train;
	private TreeMap <Passenger,Integer>Passengers;
	
	
	public TreeMap<Passenger, Integer> getPassengers() {
		return Passengers;
	}


	public void setPassengers(TreeMap<Passenger, Integer> passengers) {
		Passengers = passengers;
	}


	public Ticket(LocalDate travelDate, Train train) {
		super();
		this.travelDate = travelDate;
		this.train = train;
	}


	public int getCounter() {
		return counter;
	}


	public void setCounter(int counter) {
		this.counter = counter;
	}


	public String getPnr() {
		return pnr;
	}


	public void setPnr(String pnr) {
		this.pnr = pnr;
	}


	public LocalDate getTravelDate() {
		return travelDate;
	}


	public void setTravelDate(LocalDate travelDate) {
		this.travelDate = travelDate;
	}


	public Train getTrain() {
		return train;
	}


	public void setTrain(Train train) {
		this.train = train;
	}

	
	public String generatePNR()
	{
		String Sor = String.valueOf(train.getSource().charAt(0));
		String Des = String.valueOf(train.getDestination().charAt(0));
		String date = travelDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		String pnr = Sor+Des+"-"+date+"-"+counter++;
		
		if(travelDate.isBefore(LocalDate.now()))
		{
			return "Please check date again!";
			
		}
		else 
		{
			return pnr;
		}
					
		
	}
	
	public double calcPassengerFare(Passenger passenger)
	{
		if(passenger.getAge()<=12)
		{
			return (0.5)*(train.getTicketPrice());
			
		}
		else if(passenger.getAge()>=60)
			return (0.6)*(train.getTicketPrice());
		else if(passenger.getGender()=='F')
			return (0.25)*(train.getTicketPrice());
		else
			return train.getTicketPrice();
		
		
		
	}
	
	public void addPassenger(String name,int age,char gender)
	
	{
		Passengers = new TreeMap();
		Integer passfare = (int) calcPassengerFare (new Passenger(name,age,gender));
		Passengers.put(new Passenger(name,age,gender),passfare);
		
		
	}
	
	public double calTotalTicketPrice()
	{
		double totalPrice=0;
		Collection<Integer>price = Passengers.values();
		for(Integer values:price)
		{
		totalPrice +=values;
		}
		return totalPrice;
		
	}
	
	public void generateTicket() throws Exception
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append(pnr);
		System.out.println("PNR : "+sb.toString());
		
		sb.append(train.getTrainNo());
		System.out.println("Train No : "+sb.toString());
		
		sb.append(train.getTrainName());
		System.out.println("Train Name : "+sb.toString());
		
		sb.append(train.getSource());
		System.out.println("From : "+sb.toString());
		
		sb.append(train.getDestination());
		System.out.println("To : "+sb.toString());
		
		sb.append(travelDate);
		System.out.println("Travel Date : "+sb.toString());

		
		
		

	}
	
	/*
	 * public void writeTicket() throws IOException {
	 * 
	 * BufferedWriter bw = new BufferedWriter(new
	 * FileWriter("ticketconf.txt",true));
	 * 
	 * bw.newLine();
	 * 
	 * bw.write(pnr); bw.newLine(); bw.write(train.getTrainNo()); bw.newLine();
	 * bw.write(train.getTrainName()); bw.newLine(); bw.write(train.getSource());
	 * bw.newLine(); bw.write(train.getDestination()); bw.newLine();
	 * bw.write(travelDate.toString()); bw.newLine(); bw.flush(); bw.close();
	 * 
	 * 
	 * 
	 * 
	 * }
	 */
}
