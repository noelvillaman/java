package MyVehicles;

public class Cars implements Vehicles {
	
	private String type;
	private int numpas;
	private int maxCost;
	private int minCost;
	private double miles;
	private String model;
	private double cost;
	private int yr;

	public Cars() {}

	public String getType() {
		return type;
	}

	
	public int getNumpas() {
		return numpas;
	}

	public void setNumpas(int numpas) {
		this.numpas = numpas;
	}

	public int getMaxCost() {
		return maxCost;
	}

	public void setMaxCost(int maxCost) {
		this.maxCost = maxCost;
	}

	public int getMinCost() {
		return minCost;
	}

	public void setMinCost(int minCost) {
		this.minCost = minCost;
	}

	public double getMiles() {
		return miles;
	}

	public void setMiles(double miles) {
		this.miles = miles;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYr() {
		return yr;
	}

	public void setYr(int yr) {
		this.yr = yr;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "" + type + ", " + numpas + ", " + maxCost + ", " + minCost
				+ ", " + miles + ", " + model + ", " + yr + ", " + cost;
	}

	@Override
	public void Type(String t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void NumPas(int np) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void MaxCost(int maxc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void MinCost(int minc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Miles(double miles) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Model(String model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Year(int yr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeCost(double cost) {
		if(this.maxCost == 30000 || this.minCost < 1000)
			this.maxCost = (int)cost;
	}

	
	
}
