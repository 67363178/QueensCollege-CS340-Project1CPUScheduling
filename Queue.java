public class Queue {
	private node front;
	private node back;
	private boolean state;
	
	public int time;
	public String id;
	public int CPU;
	public Queue() {
		front=back=null;
	}
	
	public boolean isEmpty(){
		return front==null;
	}
	
	public int getCPU(){
		return CPU=front.getCPUBurst();
	
	}

	public String getJobId(){
		return id=front.getJobId();
	}
	
	public int getArrivalTime(){
		return time=front.getArrivalTime();
	}
	
	public void Compare(){
		int counter=0;
		node p =front;
		if(p.getCPUBurst()>p.next.getCPUBurst()){
			dequeue();
			
			PCB pcb=new PCB();
			pcb.setArrivalTime(p.getArrivalTime());
			pcb.setCPUBurst(p.getCPUBurst());
			pcb.setJobId(p.getJobId());
			
			enqueue(pcb);
		}
	}
	
	public void enqueue(PCB x){
		//if(state.equals("ready")){
			if(isEmpty()) back=front=new node(x);
			else back=back.next=new node(x);
		//}

		//else{
		//	System.out.println("The Process is not ready. ");
		//}
	}
	
	public double dequeue(){
		double returnvalue=front.num;
		front=front.next;
		return returnvalue;
	}
	
	public String toString(){
		int counter=0;
		node p=front;
		String returnString="";
		while(p!=null){
			returnString=returnString+"JobID: "+p.getJobId()+" ArrivalTime: "+Integer.toString(p.getArrivalTime())+" CPUBurst: "+Integer.toString(p.getCPUBurst())+"\n";  //Integer To String
			p=p.next;
		}
		//System.out.println("start "+returnString+" testing ");
		return returnString;
	}
	
	
	
}
