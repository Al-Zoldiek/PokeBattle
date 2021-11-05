package servlets;

import java.io.IOException;

import beans.Ability;
import beans.Pokemon;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.AbilityService;
import services.AbilityServiceImpl;
import services.PokemonService;
import services.PokemonServiceImpl;
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
		
		AbilityService abilityService = new AbilityServiceImpl();
		PokemonService pokemonService = new PokemonServiceImpl();
		
		Ability newAbility = new Ability(1, "lanceflamme", 5, "Feu");
		Pokemon newPkmn = new Pokemon("Rondoudou", 200, 50, 50, 40, "Eau" ,newAbility);
		pokemonService.create(newPkmn);
		
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
