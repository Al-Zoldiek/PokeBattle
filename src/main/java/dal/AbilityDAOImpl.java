package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utils.DAOUtils;
import beans.Ability;

public class AbilityDAOImpl implements AbilityDAO {

	@Override
	public List<Ability> findAll() {
		System.out.println("> AbilityDAOImpl findAll]");

		List<Ability> abilityList = new ArrayList<Ability>();
		
		// Ouverture de la connexion à la BDD
		Connection connection = DAOUtils.getConnection();
		
		// Requête
		String request = "SELECT * FROM abilities";
		
		try {
			// Préparation de la requête
			PreparedStatement prepareStmt = connection.prepareStatement(request);
			// Exécutution la requete
			ResultSet resultSet = prepareStmt.executeQuery();
			
			while(resultSet.next()) {
				Ability ability = new Ability(
						resultSet.getString("ability_name"),
						resultSet.getInt("ability_power"),
						resultSet.getString("elem_type")
						);
				abilityList.add(ability);
			}
			
			// Fermeture de la connexion à la BDD
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return abilityList;
	}

	@Override
	public String create(Ability abilityToCreate) {
		System.out.println("> AbilityDAOImpl create]");
		// Etape 1 : Connexion à la BDD
		Connection connection = DAOUtils.getConnection();
		
		// Etape 2 : Préparation de notre requete
		String request = "INSERT INTO abilities (ability_name, ability_power, elem_type) VALUES (?,?,?)";
		
		try {
			// Etape 3 : Exécuter la requete
			// Préparation
			PreparedStatement prepareStmt;
			prepareStmt = connection.prepareStatement(request);
			prepareStmt.setString(1, abilityToCreate.getName()); // 1er
			prepareStmt.setInt(2, abilityToCreate.getPower()); // 2e
			prepareStmt.setString(2, abilityToCreate.getElemType()); // 3e
			
			// Exécuter la requete
			prepareStmt.executeUpdate(); // Car on fait une modification
			
			connection.close();
			return "La création s'est bien passée.";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "La création ne s'est pas bien passée.";
		}
		
	}

}
