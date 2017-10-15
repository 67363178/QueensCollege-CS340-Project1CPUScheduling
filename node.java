
public class node {
	double num;
	PCB data;
	node next;
	node tempdata;

	public node(PCB p){
		data=p;
		next=null;
	}
	
	public node(node p){
		tempdata=p;
		next=null;
	}
	
	public node(double n){
		num=n;
		next=null;
	}
	
	public node(int n){
		num=n;
		next=null;
	}


	public String getJobId() {
		
		return data.getJobId();
	}


	public int getArrivalTime() {
		// TODO Auto-generated method stub
		return data.getArrivalTime();
	}


	public int getCPUBurst() {
		// TODO Auto-generated method stub
		return data.getCPUBurst();
	}
	
	
}
