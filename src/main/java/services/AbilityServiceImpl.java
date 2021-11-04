package services;

import java.util.List;

import beans.Ability;
import dal.AbilityDAO;
import dal.AbilityDAOImpl;

public class AbilityServiceImpl implements AbilityService {

	@Override
	public List<Ability> findAll() {
		System.out.print("[AbilityServiceImpl findAll ");
		AbilityDAO abilityDAO = new AbilityDAOImpl();
		return abilityDAO.findAll();
	}
	
	@Override
	public String create(Ability abilityToCreate) {
		System.out.print("[AbilityrServiceImpl create ");
		AbilityDAO abilityDAO = new AbilityDAOImpl();
		return abilityDAO.create(abilityToCreate);
	}
	
}
