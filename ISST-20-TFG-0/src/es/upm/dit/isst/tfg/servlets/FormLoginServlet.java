package es.upm.dit.isst.tfg.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.upm.dit.isst.tfg.dao.ProfessorDAOImplementation;
import es.upm.dit.isst.tfg.dao.TFGDAOImplementation;
import es.upm.dit.isst.tfg.model.Professor;
import es.upm.dit.isst.tfg.model.TFG;

/**
 * Servlet implementation class FormLoginServlet
 */
@WebServlet("/FormLoginServlet")
public class FormLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FormLoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	private final String ADMIN_EMAIL = "root"; 
	private final String ADMIN_PASSWORD = "root";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		List<Professor> profesores = (List<Professor>) ProfessorDAOImplementation.getInstance().readAll();
		List<TFG> tfgs = (List<TFG>) TFGDAOImplementation.getInstance().readAll();
		TFG tfg = TFGDAOImplementation.getInstance().login(email, password);
		Professor professor = ProfessorDAOImplementation.getInstance().login(email, password);
		
		//Prioridad 1 ,admin=root,password=root
		if( ADMIN_EMAIL.equals(email) && ADMIN_PASSWORD.equals(password) ) {
			req.getSession().setAttribute("admin", true);
			req.getSession().setAttribute("profesores", profesores);
			req.getSession().setAttribute("tfgs", tfgs);
			getServletContext().getRequestDispatcher("/admin.jsp").forward(req,resp);
		}
		//Prioridad 2, login con la cuenta de profesor, mira su tfg.
		else if ( null != tfg ) {
			req.getSession().setAttribute("tfg", tfg);
			getServletContext().getRequestDispatcher("/TFG.jsp").forward(req,resp); //Si es un profesorm get su tfg
		} 
		//Prioridad 3, login con la cuenta no es profesor ni admin,get inicialmente los datos.
		else if ( null != professor ) {
			req.getSession().setAttribute("profesor", ProfessorDAOImplementation.getInstance().read(professor.getEmail()));
			getServletContext().getRequestDispatcher("/Profesor.jsp").forward(req,resp);
		} else {
			getServletContext().getRequestDispatcher("/index.html").forward(req,resp);
		}
	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

