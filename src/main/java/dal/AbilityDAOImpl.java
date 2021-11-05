package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import beans.Ability;
import utils.DAOUtils;

public class AbilityDAOImpl implements AbilityDAO{

	private static String ABILITY_TABLE = "abilities";
    private static String ABILITY_COL_ID = "id";
    private static String ABILITY_COL_NAME = "ability_name";
    private static String ABILITY_COL_POWER = "ability_power";
    private static String ABILITY_COL_ELEM_TYPE = "elem_type";
    private static String QUERY_SELECT_ALL = "SELECT * FROM ";
    private static String QUERY_DELETE = "DELETE FROM ";
    private static String QUERY_INSERT = "INSERT INTO ";
    private static String QUERY_UPDATE = "UPDATE ";
    private static String QUERY_WHERE_ID = " WHERE id = ?";
    private static String QUERY_VALUES_3 = " VALUES (?,?,?)";
    private static String QUERY_PARAM_3 = " (ability_name, ability_power, elem_type)";
    private static String QUERY_UPDATE_PARAM = " SET ability_name = ?, ability_power = ?, elem_type = ?";
    
	@Override
	public List<Ability> selectAll() {
		 // Initialisation d'une liste à remplir
        List<Ability> abilityQuerySet = new ArrayList<>();

        // Création de la connexion
        Connection connection = DAOUtils.getConnection();

        // Préparation de requête
        String query = QUERY_SELECT_ALL + ABILITY_TABLE;

        try {
            // Préparation de l'envoi de requête
            PreparedStatement pprdStatement = connection.prepareStatement(query);

            ResultSet resultSet = pprdStatement.executeQuery();
            while (resultSet.next()) {
            	Ability user = new Ability(
                        resultSet.getInt(ABILITY_COL_ID),
                        resultSet.getString(ABILITY_COL_NAME),
                        resultSet.getInt(ABILITY_COL_POWER),
                        resultSet.getString(ABILITY_COL_ELEM_TYPE));                
                abilityQuerySet.add(user);
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        return abilityQuerySet;
	}

	@Override
	public Ability selectById(int providedId) {
		

		Ability abilityById = null;
	        // Création de la connexion
	        Connection connection = DAOUtils.getConnection();

	        // Préparation de requête
	        String query = QUERY_SELECT_ALL + ABILITY_TABLE + 
	        		QUERY_WHERE_ID;

	        try {
	            // Préparation de l'envoi de requête
	            PreparedStatement pprdStatement = connection.prepareStatement(query);

	            pprdStatement.setInt(1, providedId);

	            ResultSet resultSet = pprdStatement.executeQuery();
	            if (resultSet.next()) {
	                abilityById = new Ability(
	                        providedId,
	                        resultSet.getString(ABILITY_COL_NAME),
	                        resultSet.getInt(ABILITY_COL_POWER),
	                        resultSet.getString(ABILITY_COL_ELEM_TYPE));
	                connection.close();
	            }
	        } catch (SQLException sqlException) {
	            sqlException.printStackTrace();

	        }
	        return abilityById;
	    }
	

	@Override
	public String create(Ability providedAbility) {
		// Création de la connexion
        Connection connection = DAOUtils.getConnection();

        // Préparation de requête
        String query = QUERY_INSERT + ABILITY_TABLE
        				+ QUERY_PARAM_3
        				+ QUERY_VALUES_3;

        try {
            // Préparation de l'envoi de requête
            PreparedStatement pprdStatement = connection.prepareStatement(query);

            pprdStatement.setString(1, providedAbility.getName());
            pprdStatement.setInt(2, providedAbility.getPower());
            pprdStatement.setString(3, providedAbility.getElemType());

            pprdStatement.executeUpdate();
            return "L'insert en base de donnees a ete effectuee";
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return "L'insert en base de donnees n'a pas ete effectuee";
        }
	}

	@Override
	public String update(Ability providedAbility) {
		// Création de la connexion
        Connection connection = DAOUtils.getConnection();

        // Préparation de requête
        String query = QUERY_UPDATE + ABILITY_TABLE  
        				+ QUERY_UPDATE_PARAM + QUERY_WHERE_ID;

        try {
            // Préparation de l'envoi de requête
            PreparedStatement pprdStatement = connection.prepareStatement(query);

            pprdStatement.setString(1, providedAbility.getName());
            pprdStatement.setInt(2, providedAbility.getPower());
            pprdStatement.setString(3, (providedAbility.getElemType()));

            pprdStatement.executeUpdate();
            return "L'update en base de donnees a ete effectuee";
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return "L'update en base de donnees n'a pas ete effectuee";
        }
	}

	@Override
	public String delete(int abilityId) {
		// Création de la connexion
        Connection connection = DAOUtils.getConnection();

        // Préparation de requête
        String query = QUERY_DELETE + ABILITY_TABLE 
        				+ QUERY_WHERE_ID;

        try {
            // Préparation de l'envoi de requête
            PreparedStatement pprdStatement = connection.prepareStatement(query);

            pprdStatement.setInt(1, abilityId);

            pprdStatement.executeUpdate();
            return "La suppression en base de donnees a ete effectuee";
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return "La suppression en base de donnees n'a pas ete effectuee";
        }
	}

}
