package dal;

import java.util.List;

import beans.Pokemon;

public interface PokemonDAO {
	
	public List<Pokemon> findAll();
	
	public Pokemon findByName(String nameToFind);

}
