package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utils.DAOUtils;
import beans.Ability;
import beans.Pokemon;

public class PokemonDAOImpl implements PokemonDAO {

	@Override
	public List<Pokemon> findAll() {
		System.out.println("> PokemonDAOImpl findAll]");

		List<Pokemon> pokemonList = new ArrayList<Pokemon>();
		
		// Ouverture de la connexion à la BDD
		Connection connection = DAOUtils.getConnection();
		
		// Requête
		String request = "SELECT * FROM pokemon p INNER JOIN abilities a ON p.ability_id = a.id;";
		
		try {
			// Préparation de la requête
			PreparedStatement prepareStmt = connection.prepareStatement(request);
			// Exécutution la requete
			ResultSet resultSet = prepareStmt.executeQuery();
			
			// Dans la table pokemon :
			// id - pkmn_name - lifepoints - atttack - defense - speed - elem_type - ability_id
			// Constructeur pokemon :
			// String name, int lifepoints, int attack, int defense, int speed, String elemType, Ability ability
			// Il faut donc aller chercher la capacité pour la mettre dans le constructeur du pokemon
			while(resultSet.next()) {
				Ability ability = new Ability(
						resultSet.getString("ability_name"),
						resultSet.getInt("ability_power"),
						resultSet.getString("elem_type")
						);
				Pokemon pokemon = new Pokemon(
					resultSet.getString("pkmn_name"),
					resultSet.getInt("lifepoints"),
					resultSet.getInt("attack"),
					resultSet.getInt("defense"),
					resultSet.getInt("speed"),
					resultSet.getString("elem_type"),
					ability
				);
				pokemonList.add(pokemon);
			}
			
			// Fermeture de la connexion à la BDD
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pokemonList;
	}

	@Override
	public Pokemon findByName(String nameToFind) {
		System.out.println("> PokemonDAOImpl findByName > " + nameToFind + "]");

		Pokemon pokemon = null;
		
		// Ouverture de la connexion à la BDD
		Connection connection = DAOUtils.getConnection();
		
		// Requête
		String request = "SELECT * FROM pokemon p INNER JOIN abilities a ON p.ability_id = a.id WHERE pkmn_name = ?";
		
		try {
			// Préparation de la requête
			PreparedStatement prepareStmt = connection.prepareStatement(request);
			prepareStmt.setString(1, nameToFind);
			// Exécutution la requete
			ResultSet resultSet = prepareStmt.executeQuery();
			
			// come pour FindAll()
			while(resultSet.next()) {
				Ability ability = new Ability(
						resultSet.getString("ability_name"),
						resultSet.getInt("ability_power"),
						resultSet.getString("elem_type")
						);
				pokemon = new Pokemon(
					resultSet.getString("pkmn_name"),
					resultSet.getInt("lifepoints"),
					resultSet.getInt("attack"),
					resultSet.getInt("defense"),
					resultSet.getInt("speed"),
					resultSet.getString("elem_type"),
					ability
				);
			}
			
			// Fermeture de la connexion à la BDD
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pokemon;
	}
}
