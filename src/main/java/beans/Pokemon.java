package beans;

public class Pokemon {

	
	private String name;
	private int lifepoints;
	private int attack;
	private int defense;
	private int speed;
	private String elemType;
	private Ability ability;
	
	private static double STRONG_VS = 1.5;
	private static double WEAK_VS = 0.5;
	private static String WATER_TYPE = "Eau";
	private static String FIRE_TYPE = "Feu";
	private static String PLANT_TYPE = "Plante";
	
	
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
		
	@Override
	public String toString() {
		return "Pokemon [name=" + name + ", lifepoints=" + lifepoints + ", attack=" + attack + ", defense=" + defense
				+ ", speed=" + speed + ", elemType=" + elemType + ", ability=" + ability.toString() + "]";
	}

	// This method initializes a fight between 2 Pokemon objects
	public static String fight(Pokemon attacker, Pokemon defender) {
		System.out.println("[Pokemon-Beans fight(" + 
							attacker.toString() + "," + 
							defender.toString() +")]");
		String winner = "";
		
		// While... allows us to repeat the fight until one's lifepoints reach 0
		while((attacker.getLifepoints() > 0) 
				&& (defender.getLifepoints() > 0)) {
			attacker.attack(defender);
			defender.attack(attacker);
			
			// Testing whether attacker or defender have reached 0 lifepoints, in this case the concerned Pokemon has its LP set to 0
			// and we affect to a local variable winner the winning Pokemon's name 
			if(attacker.getLifepoints() <= 0) {
				// Attacker dies and HP are set to 0
				attacker.setLifepoints(0);
				winner = defender.getName();
				break;
			}else if(defender.getLifepoints() <= 0) {
				// Defender dies and HP are set to 0
				defender.setLifepoints(0);
				winner = attacker.getName();
				break;
			}
		
		}
		return winner; 
	
	}

	// This method allows a Pokemon to reduce a defender Pokemon's life points, depending on both statistics
	private void attack(Pokemon defender) {
		System.out.println("[Pokemon-Beans attacker.attack(" + 
				defender.toString() +")]");
		double damageCalculation = this.attack * ((this.ability.getPower())/10);
		double damageReduction = (defender.defense % 5) / 100;
		double actualLifePoints = this.lifepoints;
		defender.setLifepoints((int)( actualLifePoints - (damageCalculation - damageReduction)));
		
	}
	
	
	
}
