
public class PCB implements Runnable{
	private String JobID;
	
	private int ArrivalTime;
	private int CPUBurst;
	private int currentCPUBurst;
	private int IOTime;
	private int ProgramCounter;
	
	private String State; 

	//public PCB(){
		
	//}
	
	public void run(){
		try{
			System.out.println("Thread is running: "+JobID);
		}
		catch(Exception e){
			
		}
	}
	
	
	public PCB(){
		JobID="";
		ArrivalTime=0;
		CPUBurst=0;
		currentCPUBurst=0;
		IOTime=0;
		ProgramCounter=0;
	}
	
	
	public void setJobId(String id){
		JobID=id;
	}
	
	public void setArrivalTime(int t){
		ArrivalTime=t;
	}
	
	public void setCPUBurst(int ct){
		CPUBurst=ct;
	}
	
	public void setState(String s){
		State=s;
	}
	
	public String getJobId(){
		return JobID;
	}
	
	public int getCPUBurst(){
		return CPUBurst;
	}
	
	public int getArrivalTime(){
		return ArrivalTime;
	}
	
	public String getState(){
		return State;
	}
	
	
	
}
