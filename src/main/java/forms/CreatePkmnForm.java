package forms;

import beans.Ability;
import beans.Pokemon;

public class CreatePkmnForm {
	public String pkmnName;
	private int lifepoints;
	private int attack;
	private int defense;
	private int speed;
	public String elemType;
	public Ability ability;
	public boolean isError = false;
	public String message;


	/**
	 * 
	 */
	public CreatePkmnForm() {
	}
	

	public Pokemon addNewPkmn() {
		return new Pokemon(pkmnName, lifepoints, attack, defense, speed, elemType, ability);
	}

	/**
	 * @return the pkmnName
	 */
	public String getPkmnName() {
		return pkmnName;
	}

	/**
	 * @param pkmnName the pkmnName to set
	 */
	public void setPkmnName(String pkmnName) {
		this.pkmnName = pkmnName;
	}

	/**
	 * @return the lifepoints
	 */
	public int getLifepoints() {
		return lifepoints;
	}

	/**
	 * @param lifepoints the lifepoints to set
	 */
	public void setLifepoints(int lifepoints) {
		this.lifepoints = lifepoints;
	}

	/**
	 * @return the attack
	 */
	public int getAttack() {
		return attack;
	}

	/**
	 * @param attack the attack to set
	 */
	public void setAttack(int attack) {
		this.attack = attack;
	}

	/**
	 * @return the defense
	 */
	public int getDefense() {
		return defense;
	}

	/**
	 * @param defense the defense to set
	 */
	public void setDefense(int defense) {
		this.defense = defense;
	}

	/**
	 * @return the speed
	 */
	public int getSpeed() {
		return speed;
	}

	/**
	 * @param speed the speed to set
	 */
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	/**
	 * @return the elemType
	 */
	public String getElemType() {
		return elemType;
	}

	/**
	 * @param elemType the elemType to set
	 */
	public void setElemType(String elemType) {
		this.elemType = elemType;
	}

	/**
	 * @return the isError
	 */
	public boolean isError() {
		return isError;
	}

	/**
	 * @param isError the isError to set
	 */
	public void setError(boolean isError) {
		this.isError = isError;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the ability
	 */
	public Ability getAbility() {
		return ability;
	}

	/**
	 * @param ability the ability to set
	 */
	public void setAbility(Ability ability) {
		this.ability = ability;
	}

}
