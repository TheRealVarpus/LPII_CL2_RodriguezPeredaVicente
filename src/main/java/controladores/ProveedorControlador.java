package controladores;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProveedorDAO;
import model.TblProveedorcl2;

/**
 * Servlet implementation class ProveedorControlador
 */
public class ProveedorControlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProveedorControlador() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		ProveedorDAO crudimp=new ProveedorDAO();
		TblProveedorcl2 tblprov=new TblProveedorcl2();
		//recuperamos el listado de productos de la BD..
		List<TblProveedorcl2> listadoproductos=crudimp.ListadoProveedor();
		//declaramos una variable de tipo string...
		//recibimos el valor segun la accion..
		String accion=request.getParameter("accion");
		//aplicamos una condicion...
		if(accion!=null){
			//aplicamos un switch..
			switch(accion){
			case "Modificar":
				
				break;
			case "Registrar":
				
				break;
			case "Eliminar":
				
				break;
			case "Listar":
				//redireccionamos hacia la vista(.jsp)
				request.getRequestDispatcher("/menuPrincipal.jsp").forward(request, response);
				//salimos
				break;
			}  //fin del switch.....
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
