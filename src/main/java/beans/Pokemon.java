package beans;

public class Pokemon {

	
	private String name;
	private int lifepoints;
	private int attack;
	private int defense;
	private int speed;
	private String elemType;
	private Ability ability;
	
	
	
	
	public Pokemon() {
		super();
	}

	public Pokemon(String name, int lifepoints, int attack, int defense, int speed, String elemType) {
		super();
		this.name = name;
		this.lifepoints = lifepoints;
		this.attack = attack;
		this.defense = defense;
		this.speed = speed;
		this.elemType = elemType;
	}

	public Pokemon(String name, int lifepoints, int attack, int defense, int speed, String elemType, Ability ability) {
		super();
		this.name = name;
		this.lifepoints = lifepoints;
		this.attack = attack;
		this.defense = defense;
		this.speed = speed;
		this.elemType = elemType;
		this.ability = ability;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLifepoints() {
		return lifepoints;
	}

	public void setLifepoints(int lifepoints) {
		this.lifepoints = lifepoints;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public String getElemType() {
		return elemType;
	}

	public void setElemType(String elemType) {
		this.elemType = elemType;
	}

	public Ability getAbilty() {
		return ability;
	}

	public void setAbilty(Ability ability) {
		this.ability = ability;
	}
	
	
	
}
