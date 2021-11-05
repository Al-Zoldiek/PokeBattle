package beans;

public class Ability {

	public int id;
	private String name;
	private int power;
	private String elemType;
	
	
	
	public Ability() {
		super();
	}

	public Ability(String name, int power, String elemType) {
		super();
		this.name = name;
		this.power = power;
		this.elemType = elemType;
	}
	
	public Ability(int id, String name, int power, String elemType) {
		super();
		this.id = id;
		this.name = name;
		this.power = power;
		this.elemType = elemType;
	}
	
	@Override
	public String toString() {
		return "Capacity [name=" + name + ", power=" + power + ", elemType=" + elemType + "]";
	}
	
	public int getId() {
		return id;
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
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	public String getElemType() {
		return elemType;
	}
	public void setElemType(String elemType) {
		this.elemType = elemType;
	}
	
	
}
