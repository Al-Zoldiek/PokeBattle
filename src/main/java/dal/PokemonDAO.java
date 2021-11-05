package dal;

import java.util.List;

import beans.Pokemon;

public interface PokemonDAO {
	
	public List<Pokemon> findAll();
	
	public Pokemon findById(String nameToFind);
	
	public String delete(int pokemonIdToDelete);
	
	public String create(Pokemon pokemonProvided);

	public Pokemon findById(int providedId);

}
