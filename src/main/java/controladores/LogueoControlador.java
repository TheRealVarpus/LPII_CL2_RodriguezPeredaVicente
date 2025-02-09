package controladores;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProveedorDAO;
import dao.UsuarioDAO;
import model.TblProveedorcl2;

/**
 * Servlet implementation class LogueoControlador
 */
public class LogueoControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogueoControlador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String usuario= request.getParameter("usuario");
		String passwrod= request.getParameter("password");
		UsuarioDAO crudimp = new UsuarioDAO();
		ProveedorDAO provDAO = new ProveedorDAO();
		RequestDispatcher dispatcher;
		

		if(crudimp.validarUsuario(usuario,passwrod)){
			List<TblProveedorcl2> listaProv = provDAO.ListadoProveedor();
			request.setAttribute("listado", listaProv);
			dispatcher= request.getRequestDispatcher("menuPrincipal.jsp");
		}else{
			request.setAttribute("error", "Error de Usuario");
			dispatcher= request.getRequestDispatcher("index.jsp");
		}
		dispatcher.forward(request, response);
		System.out.println("parametro: " +usuario );
		doGet(request, response);
	}

}
