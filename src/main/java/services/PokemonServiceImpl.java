package services;

import java.util.List;

import beans.Pokemon;
import dal.PokemonDAO;
import dal.PokemonDAOImpl;

public class PokemonServiceImpl implements PokemonService {

	@Override
	public List<Pokemon> findAll() {
		System.out.print("[PokemonServiceImpl findAll ");
		PokemonDAO pokemonDAO = new PokemonDAOImpl();
		return pokemonDAO.findAll();
	}
	
	@Override
	public Pokemon findByName(String nameToFind) {
		System.out.print("[PokemonServiceImpl findByName ");
		PokemonDAO pokemonDAO = new PokemonDAOImpl();
		return pokemonDAO.findByName(nameToFind);
	}

	@Override
	public String delete(int pokemonIdToDelete) {
		System.out.print("[PokemonServiceImpl findByName ");
		PokemonDAO pokemonDAO = new PokemonDAOImpl();
		return pokemonDAO.delete(pokemonIdToDelete);
	}

	@Override
	public String create(Pokemon pokemonProvided) {
		System.out.print("[PokemonServiceImpl create(Pokemon pokemonProvided) ");
		PokemonDAO pokemonDAO = new PokemonDAOImpl();
		return pokemonDAO.create(pokemonProvided);
	}
	
	
}
