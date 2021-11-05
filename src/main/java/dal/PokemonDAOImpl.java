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

	private static String POKEMON_TABLE = "pokemon";
	private static String POKEMON_TABLE_INNER_JOIN_ABILITES = "pokemon p INNER JOIN abilities a ON p.ability_id = a.id";
    private static String POKEMON_COL_ID = "id";
    private static String POKEMON_COL_NAME = "pkmn_name";
    private static String POKEMON_COL_LIFEPOINTS = "lifepoints";
    private static String POKEMON_COL_ATTACK = "attack";
    private static String POKEMON_COL_DEFENSE = "defense";
    private static String POKEMON_COL_SPEED = "speed";
    private static String POKEMON_COL_ELEM = "elem_type";
    private static String POKEMON_COL_ABILITY = "ability_id";
    private static String QUERY_SELECT_ALL = "SELECT * FROM ";
    private static String QUERY_DELETE = "DELETE FROM ";
    private static String QUERY_INSERT = "INSERT INTO ";
    private static String QUERY_UPDATE = "UPDATE ";
    private static String QUERY_WHERE_ID = " WHERE id = ?";
    private static String QUERY_PARAM_7 = " (pkmn_name, lifepoints, attack, defense, speed, elem_type, ability_id)";
    private static String QUERY_VALUES_7 = " VALUES (?,?,?,?,?,?,?)";
    private static String QUERY_UPDATE_PARAM = " SET pkmn_name=?, lifepoints=?, attack=?, defense=?, speed=?, elem_type=?, ability_id=?";
    
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
						resultSet.getInt("id"),
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
	
	public String delete(int pokemonIdToDelete) {
		System.out.println("[PokemonDAOImpl delete]");
		
		// Etape 1 : Connexion a la BDD
		Connection connection = DAOUtils.getConnection();
		
		// Etape 2 : Preparation de notre requete
		String request = "DELETE FROM pokemon WHERE id = ?";
		
		try {
			// Etape 3 : Executer la requete
			// Preparation
			PreparedStatement prepareStmt = connection.prepareStatement(request);
			prepareStmt.setInt(1, pokemonIdToDelete);
			
			// Exécuter la requete
			prepareStmt.executeUpdate();
			
			// Etape 4 : Fermeture de la connexion � la BDD
			connection.close();
			return "La suppression du pokemon s'est bien pass�e";
		} catch (SQLException e) {
			e.printStackTrace();
			return "La suppression du pokemon ne s'est pas bien pass�e";
		}
	}

	@Override
	public String create(Pokemon pokemonProvided) {
		// Création de la connexion
        Connection connection = DAOUtils.getConnection();

        // Préparation de requête
        String query = QUERY_INSERT + POKEMON_TABLE
        				+ QUERY_PARAM_7
        				+ QUERY_VALUES_7;
        	System.out.println(query);
        	System.out.println(pokemonProvided.getAbilty().toString());
        	System.out.println(pokemonProvided.getAbilty().id);
        try {
            // Préparation de l'envoi de requête
            PreparedStatement pprdStatement = connection.prepareStatement(query);

            pprdStatement.setString(1, pokemonProvided.getName());
            pprdStatement.setInt(2, pokemonProvided.getLifepoints());
            pprdStatement.setInt(3, pokemonProvided.getAttack());
            pprdStatement.setInt(4, pokemonProvided.getDefense());
            pprdStatement.setInt(5, pokemonProvided.getSpeed());
            pprdStatement.setString(6, pokemonProvided.getElemType());
            pprdStatement.setInt(7, pokemonProvided.getAbilty().id);
            System.out.println(pprdStatement.toString() + "<- pprdStat toString()");
            pprdStatement.executeUpdate();
            return "L'insert en base de donnees a ete effectuee";
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return "L'insert en base de donnees n'a pas ete effectuee";
        }
	}
}
