package servlets;

import java.io.IOException;
import java.util.List;

import beans.Ability;
import beans.Pokemon;
import forms.CreatePkmnForm;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import services.AbilityService;
import services.AbilityServiceImpl;
import services.PokemonService;
import services.PokemonServiceImpl;

/**
 * Servlet implementation class CreatePokemon
 */
@WebServlet("/create-pokemon")
public class CreatePokemon extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CreatePokemon() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AbilityService abilityService= new AbilityServiceImpl();
		List<Ability> allAbilities =  abilityService.selectAll();
		request.setAttribute("allAbilities", allAbilities);
		
		CreatePkmnForm createPkmnForm = new CreatePkmnForm();
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/jsp/create-pokemon.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println(request.getParameter("pkmn-name"));
//		System.out.println(request.getParameter("attack"));
//		System.out.println(request.getParameter("defense"));
//		System.out.println(request.getParameter("speed"));
//		System.out.println(request.getParameter("elem-type"));
//		System.out.println(request.getParameter("abilities"));
		
		CreatePkmnForm createPkmnForm = new CreatePkmnForm();
		createPkmnForm.setPkmnName(request.getParameter("pkmn-name"));
		createPkmnForm.setLifepoints(Integer.valueOf(request.getParameter("lifepoints")));
		createPkmnForm.setAttack(Integer.valueOf(request.getParameter("attack")));
		createPkmnForm.setDefense(Integer.valueOf(request.getParameter("defense")));
		createPkmnForm.setSpeed(Integer.valueOf(request.getParameter("speed")));
		createPkmnForm.setElemType(request.getParameter("elem-type"));
		
		
		//recuperation du elemType de abilities en BDD à partir de l'id selectionné par l'utilisateur
		AbilityService abilityService= new AbilityServiceImpl();
		Ability ability = abilityService.selectById(Integer.valueOf(request.getParameter("abilities")));
		String abilityElemType = ability.getElemType();
		
		
		// recuperation de la valeur du ElemType (eau, feu ou plante) dans une variable 
		String elemType = request.getParameter("elem-type");
		
		System.out.println(abilityElemType + "<- abilityElemType");
		System.out.println(elemType + "<- elemType");
		
		//Condition de création du pokémon : le ElemType choisi doit correspondre 
		//au elemType de la capacité choisie pour pouvoir creer le pokemon
		if(elemType.equalsIgnoreCase(abilityElemType)) {
			
		// creaction du pokemon en base de donnée	
		createPkmnForm.setAbility(ability);
		PokemonService pokemonService = new PokemonServiceImpl();
		pokemonService.create(
				new Pokemon(createPkmnForm.getPkmnName(),
						createPkmnForm.getLifepoints(),
						createPkmnForm.getAttack(),
						createPkmnForm.getDefense(),
						createPkmnForm.getSpeed(),
						createPkmnForm.getElemType(),
						createPkmnForm.getAbility()));
		
		//redirection vers le pokedex
		response.sendRedirect("pokedex");
		
		} else {
			request.setAttribute("errorMessage", "La capacité choisie ne correspond pas au type du pokemon");
			
			//envoyer les informations entrées par l'utilisateur en session
			HttpSession session = request.getSession();
			session.setAttribute("inputPkmnData", createPkmnForm);
			
			//redirection vers doget
			doGet(request, response);


			
			
		}
		
		
	}

}
