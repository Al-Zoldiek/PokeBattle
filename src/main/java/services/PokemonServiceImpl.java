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
		return pokemonDAO.findById(nameToFind);
	}

	@Override
	public String delete(int pokemonIdToDelete) {
		System.out.print("[PokemonServiceImpl delete(int pokemonIdToDelete) ");
		PokemonDAO pokemonDAO = new PokemonDAOImpl();
		return pokemonDAO.delete(pokemonIdToDelete);
	}

	@Override
	public String create(Pokemon pokemonProvided) {
		System.out.print("[PokemonServiceImpl create(Pokemon pokemonProvided) ");
		PokemonDAO pokemonDAO = new PokemonDAOImpl();
		return pokemonDAO.create(pokemonProvided);
	}

	@Override
	public Pokemon findById(int idProvided) {
		PokemonDAO pokemonDAO = new PokemonDAOImpl();
		return pokemonDAO.findById(idProvided);
	}
	
	
}
