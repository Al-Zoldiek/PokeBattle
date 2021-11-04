package services;

import java.util.List;

import beans.Ability;

public interface AbilityService {
	
	public List<Ability> findAll();
	
	public String create(Ability abilityToCreate);	
}
