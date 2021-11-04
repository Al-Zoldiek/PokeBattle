package servlets;

import java.io.IOException;
import java.util.List;

import beans.Pokemon;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.PokemonService;
import services.PokemonServiceImpl;
import utils.RouteUtils;

/**
 * Servlet implementation class Pokedex
 */
@WebServlet("/pokedex")
public class Pokedex extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Pokedex() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// findAll() va chercher les pokemons de la base de données
		System.out.println("--- Test findAll() Pokemon ---");
		PokemonService pokemonService = new PokemonServiceImpl();
		List<Pokemon> allPokemons = pokemonService.findAll();
		request.setAttribute("allPokemons", allPokemons);
		this.getServletContext().getRequestDispatcher(RouteUtils.ROUTE_POKEDEX).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
