package services;

import java.util.List;

import beans.Pokemon;

public interface PokemonService {
	
	public List<Pokemon> findAll();
	
	public Pokemon findByName(String nameToFind);
	public Pokemon findById(int idProvided);
	
	public String delete(int pokemonIdToDelete);
	
	public String create(Pokemon pokemonProvided);

}
