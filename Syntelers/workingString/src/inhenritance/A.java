package inhenritance;

public class A extends Today{

	public static void main(String[] args) {
		Today a = new A();
		A a2 = new A();
		
		a.pr();
		a2.pedo();
		//A a1 = new A();
		//a1.pr2();
	}
	
	public void pr(){
		
		
		//super.pr();
		System.out.println("This is child");
	}
	
	public void pedo(){
		
		boolean i = false;
		int count = 0;
		while(!i){
			count = count + 1;
			//System.out.println(count);
			if(count==100)
				i = true;
			
		}
		System.out.println("This also is count: " + count);
	}

}
