package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import beans.Pokemon;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import services.PokemonService;
import services.PokemonServiceImpl;
import utils.RouteUtils;

/**
 * Servlet implementation class BattlePage
 */
@WebServlet("/battle-page")
public class BattlePage extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public BattlePage() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PokemonService pokemonService = new PokemonServiceImpl();
		HttpSession session = request.getSession();
		List<Pokemon> pokemonList = new ArrayList<Pokemon>();
		
		pokemonList = pokemonService.findAll();
		System.out.println(pokemonList + "<- pokemonList from BattlePage doGet()");
		request.setAttribute("pokemonList", pokemonList);
		this.getServletContext().getRequestDispatcher(RouteUtils.ROUTE_BATTLE_PAGE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Trouver un moyen de réhydrater la page avec notre premier choix
		
		PokemonService pokemonService = new PokemonServiceImpl();
		HttpSession session = request.getSession();
		List<Pokemon> pokemonList = new ArrayList<Pokemon>();
		
		System.out.println(request.getParameter("pokemons"));
		System.out.println(request.getParameter("step-test"));
		
		
		String stepTester = (String) session.getAttribute("stepTester"); 
		if(stepTester == null) {
			List<Pokemon> pokemonListRedone = new ArrayList<Pokemon>();
			
			pokemonList = pokemonService.findAll();
		
			request.setAttribute("pokemonList", pokemonListRedone);
			session.setAttribute("stepTester", "is-first-selected");
			
			doGet(request, response);
		}else if(stepTester.equalsIgnoreCase("is-first-selected")){
			session.setAttribute("stepTester", "is-second-selected");
			doGet(request, response);
		}
	}

}
