package beans;

public class Ability {

	private String name;
	private int power;
	private String elemType;
	
	
	
	public Ability(String name, int power, String elemType) {
		super();
		this.name = name;
		this.power = power;
		this.elemType = elemType;
	}
	
	@Override
	public String toString() {
		return "Capacity [name=" + name + ", power=" + power + ", elemType=" + elemType + "]";
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
