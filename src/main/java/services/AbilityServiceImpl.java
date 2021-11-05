package services;

import java.util.List;

import beans.Ability;
import dal.AbilityDAO;
import dal.AbilityDAOImpl;

public class AbilityServiceImpl implements AbilityService {

	@Override
	public List<Ability> selectAll() {
		System.out.println("[UserServiceImpl - selectAll()]");
        AbilityDAO abilityDAO = new AbilityDAOImpl();
        return abilityDAO.selectAll();
	}

	@Override
	public Ability selectById(int providedId) {
		System.out.println("[UserServiceImpl - selectById(int providedId)]");
        AbilityDAO abilityDAO = new AbilityDAOImpl();
        return abilityDAO.selectById(providedId);
	}

	@Override
	public String create(Ability providedAbility) {
		System.out.println("[UserServiceImpl - create(Ability providedAbility)]");
        AbilityDAO abilityDAO = new AbilityDAOImpl();
        return abilityDAO.create(providedAbility);
	}

	@Override
	public String update(Ability providedAbility) {
		System.out.println("[UserServiceImpl - update(Ability providedAbility)]");
        AbilityDAO abilityDAO = new AbilityDAOImpl();
        return abilityDAO.update(providedAbility);
	}

	@Override
	public String delete(int abilityId) {
		System.out.println("[UserServiceImpl - delete(int abilityId)]");
        AbilityDAO abilityDAO = new AbilityDAOImpl();
        return abilityDAO.delete(abilityId);
	}

}
