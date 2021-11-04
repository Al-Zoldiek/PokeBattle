package servlets;

import java.io.IOException;

import beans.Ability;
import beans.Pokemon;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.RouteUtils;

/**
 * Servlet implementation class PokemonTest
 */
@WebServlet("/pokemonTest")
public class PokemonTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public PokemonTest() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Ability testAbility = new Ability("Test",40, "Eau");
		
		System.out.println("Ability de bouchonnage - " + testAbility.toString());
		
		Pokemon pokemonTest = new Pokemon("Test1", 200, 100, 50, 40, "Eau", testAbility);
		
		System.out.println("Premier pkmn de bouchonnage - " + pokemonTest.toString());
		
		Pokemon pokemonTest2 = new Pokemon("Test2", 400, 200, 50, 40, "Eau", testAbility);
		
		System.out.println("Deuxième pkmn de bouchonnage - " + pokemonTest2.toString());
	
		System.out.println(Pokemon.fight(pokemonTest, pokemonTest2));
		
		System.out.println("Test de Pokemon.fight(pokemonTest, pokemonTest2)");
		
		this.getServletContext().getRequestDispatcher(RouteUtils.ROUTE_POKEMON_TEST).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
