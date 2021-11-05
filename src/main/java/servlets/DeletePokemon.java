package servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.PokemonService;
import services.PokemonServiceImpl;
import utils.RouteUtils;

/**
 * Servlet implementation class DeletePokemon
 */
@WebServlet("/pokemon-delete")
public class DeletePokemon extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public DeletePokemon() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		this.getServletContext().getRequestDispatcher(RouteUtils.ROUTE_POKEMON_DELETE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        PokemonService pokemonService = new PokemonServiceImpl();
		
        int pokemonIdToDelete = Integer.valueOf(request.getParameter("idPokemonToDelete"));
		pokemonService.delete(pokemonIdToDelete);
		
		response.sendRedirect("pokedex");
	}

}
