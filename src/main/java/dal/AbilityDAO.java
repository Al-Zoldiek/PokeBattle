package dal;

import java.util.List;

import beans.Ability;

public interface AbilityDAO {
	
	public List<Ability> findAll();
	
	public String create(Ability abilityToCreate);

}
