package servlets;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class DisplayAbilities
 */
@WebServlet("/display-abilities")
public class DisplayAbilities extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public DisplayAbilities() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("--- Test findAll() Pokemon ---");
		AbilityService abilityService = new AbilityServiceImpl();
		List<Ability> allAbilities = abilityService.findAll();
		request.setAttribute("allAbilities", allAbilities);
		this.getServletContext().getRequestDispatcher(RouteUtils.ROUTE_DISPLAY_ABILITIES).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
