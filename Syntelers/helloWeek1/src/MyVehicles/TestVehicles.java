package MyVehicles;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;

public class TestVehicles implements Comparable{

	public static void main(String[] args) {
		ArrayList<Vehicles> vehicles = new ArrayList<Vehicles>();
		Vehicles truck1 = new Trucks();
		Vehicles car1 = new Cars();
		vehicles.add(truck1);
		vehicles.add(car1);
		HashMap<Integer, Vehicles> list1 = new HashMap<Integer, Vehicles>();
		//I casted the object vehicles so it can be added to the list1
		list1.put(1, car1);
		list1.put(2, truck1);
		Trucks[] trucks = new Trucks[20];
		Trucks truck;
		for(int i=0; i < trucks.length; i++)
		{
			truck = new Trucks();
			
			truck.setType("Truck");
			truck.setNumpas(5);
			truck.setMiles(20000);
			truck.setMaxCost(30000);
			truck.setMinCost(12000);
			truck.setModel("Jeep");
			truck.setYr(2010);
			truck.changeCost(1.0);
			
			trucks[i] = truck;
			//System.out.println(trucks[i]);
		}
		
		//HashMap map =new  HashMap();
		
		Cars[] cars = new Cars[20];
		Cars car;
		for(int i=0; i < trucks.length; i++)
		{
			car = new Cars();
			car.setType("Car");
			car.setNumpas(5);
			car.setMiles(20000);
			car.setMaxCost(30000);
			car.setMinCost(12000);
			car.setModel("Jeep");
			car.setYr(2010);
			car.changeCost(1.0);
			
			cars[i] = car;
			//System.out.println(trucks[i]);
		}
		
		System.out.println(trucks[1]);
		System.out.println(cars[1]);
		
		ArrayList<Vehicles> list = new ArrayList<Vehicles>();
	
	}

	public int compareTo(Vehicles vehicle) {
		// TODO Auto-generated method stub
		//int compparePrice = ((Vehicles)vehicle)
		return 0;
	}

	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

}

