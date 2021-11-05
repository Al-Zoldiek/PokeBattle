package services;

import java.util.List;

import beans.Pokemon;
import dal.PokemonDAO;
import dal.PokemonDAOImpl;

public class PokemonServiceImpl implements PokemonService {

	@Override
	public List<Pokemon> findAll() {
		System.out.print("[PokemonServiceImpl findAll() ");
		PokemonDAO pokemonDAO = new PokemonDAOImpl();
		return pokemonDAO.findAll();
	}
	
	@Override
	public Pokemon findByName(String nameToFind) {
		System.out.print("[PokemonServiceImpl findByName(String nameToFind) ");
		PokemonDAO pokemonDAO = new PokemonDAOImpl();
		return pokemonDAO.findByName(nameToFind);
	}

	@Override
	public String delete(int pokemonIdToDelete) {
		System.out.print("[PokemonServiceImpl delete(int pokemonIdToDelete) ");
		PokemonDAO pokemonDAO = new PokemonDAOImpl();
		return pokemonDAO.delete(pokemonIdToDelete);
	}
	
	
}
