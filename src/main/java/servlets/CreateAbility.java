package servlets;

import java.io.IOException;

import beans.Ability;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.AbilityService;
import services.AbilityServiceImpl;
import utils.RouteUtils;

@WebServlet("/create-ability")
public class CreateAbility extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CreateAbility() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher(RouteUtils.ROUTE_CREATE_ABILITY).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("ability-name"));
		System.out.println(request.getParameter("ability-power"));
		
		AbilityService abilityService = new AbilityServiceImpl();
		Ability abilityToCreate = new Ability(request.getParameter("ability-name"),
				Integer.valueOf(request.getParameter("ability-power")),
				request.getParameter("elem-type"));
		abilityService.create(abilityToCreate);
		
		response.sendRedirect("pokedex");
	}

}
