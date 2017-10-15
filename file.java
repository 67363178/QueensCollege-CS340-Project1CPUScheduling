import java.io.*;
import java.util.*;
public class file {
	private Scanner x;
	//private PCB ProcessControlBlock=new PCB();
	public Queue readyQueue = new Queue();
	
	public void openfile(){
		try{
			x=new Scanner(new File("jobs.txt"));
		}
		
		catch(Exception e){
			System.out.println("File Not Found");
		}
	}
	
	public void readFile(){
		int time=0;
		int counter=0;
		int counterWhile=0;
		int counterQempty=0;
		
		boolean Tstate=false;
		
		while(x.hasNext()){
			
			PCB ProcessControlBlock=new PCB();
			
			String a=x.next();
			ProcessControlBlock.setJobId(a);
			//System.out.println(a);
			
			String b=x.next();
			ProcessControlBlock.setArrivalTime(Integer.parseInt(b));
			//System.out.println(b);
			
			String c=x.next();
			ProcessControlBlock.setCPUBurst(Integer.parseInt(c));
			//System.out.println(c);
			
			ProcessControlBlock.setState("ready");
			
			//temp=ProcessControlBlock;
			
			
			if(time==Integer.parseInt(b)){ //arrival at the same time
				readyQueue.enqueue(ProcessControlBlock);
				counterQempty++;
				//System.out.println("JobId "+a+" Arrival time "+b+" CPU burst "+c+" State "+ProcessControlBlock.getState());
			}
		
			else if(time!=Integer.parseInt(b)){
				//run the process since the arrival time is 7 for process17
				System.out.println("Process "+ ProcessControlBlock.getJobId()+" Waiting until time: "+ ProcessControlBlock.getArrivalTime());
				
					if(counterQempty>=2) readyQueue.Compare();
				
				while(time<ProcessControlBlock.getArrivalTime()){
					
					if(readyQueue.isEmpty()){
						System.out.println("Current Time is "+time+". No processes in the ready queue.\nWaiting for new processes.");
						
						readyQueue.enqueue(ProcessControlBlock);
						counterQempty++;
						
						time=ProcessControlBlock.getArrivalTime();
						System.out.println("Process "+ProcessControlBlock.getJobId()+" arrive at "+ProcessControlBlock.getArrivalTime());
						counterWhile=0;
					}//empty queue
					
					if(counterWhile==1&&counterQempty>=2){
						readyQueue.Compare();
					}
					
					System.out.println("Process "+ readyQueue.getJobId()+" is processing. With CPUT Burst: "+ readyQueue.getCPU()+" At time "+time);
					
					
					if((counterQempty>1)&&time+readyQueue.getCPU()>ProcessControlBlock.getArrivalTime()){ 
					//if(counterQempty>1) only 1 PCB in the queue, avoid 
						time=time+(ProcessControlBlock.getArrivalTime()-time);
						System.out.println("Current Time is Now: "+time);
					
						System.out.println("Process "+ ProcessControlBlock.getJobId()+" entering at time: "+ ProcessControlBlock.getArrivalTime());
						
						readyQueue.enqueue(ProcessControlBlock); 
						counterQempty++;
						
						counter=1;
						counterWhile=0;
					}
					
					if(counter==1){
						time=time+(readyQueue.getCPU());
						counter=0;
					}
					
					else time=time+(readyQueue.getCPU());
					
					System.out.println("Time in real life: "+time+"\nJob: "+readyQueue.getJobId()+" Done.\n");
					readyQueue.dequeue();
					counterQempty--;
							
					
					System.out.println("Current Time After Processing: "+time);
					counterWhile=1;
					
				}//while
			}
			
		}
	
	}
	
	public void closeFile(){
		x.close();
	}
	
}
