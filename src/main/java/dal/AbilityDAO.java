package dal;

import java.util.List;

import beans.Ability;

public interface AbilityDAO {

    public List<Ability> selectAll();
    public Ability selectById(int providedId);
    public String create(Ability ability);
    public String update(Ability ability);
    public String delete(int abilityId);

}
