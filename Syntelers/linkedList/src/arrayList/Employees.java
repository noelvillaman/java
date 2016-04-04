package arrayList;

public class Employees {
	private int id;
	private String name;
	private int years;
	public int getId() {
		return id;
	}
	
	public Employees(int i, String name, int years)
	{
		this.id = i;
		this.name = name;
		this.years = years;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getYears() {
		return years;
	}
	public void setYears(int years) {
		this.years = years;
	}
	@Override
	public String toString() {
		return "Employees: id=" + id + ", name=" + name + ", years=" + years;
	}

}
