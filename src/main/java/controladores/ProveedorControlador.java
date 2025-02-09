package controladores;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
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
		RequestDispatcher dispatcher;
		ProveedorDAO crudimp=new ProveedorDAO();

		TblProveedorcl2 tblprov=new TblProveedorcl2();
		TblProveedorcl2 proveedor = new TblProveedorcl2();
		TblProveedorcl2 proveedor2 = new TblProveedorcl2();
		
		//recuperamos el listado de productos de la BD..
		List<TblProveedorcl2> listaProv = null;
		//declaramos una variable de tipo string...
		//recibimos el valor segun la accion..
		String accion=request.getParameter("accion");
		//aplicamos una condicion...
		if(accion!=null){
			//aplicamos un switch..
			switch(accion){
			case "Editar":
				System.out.println("ACCION EDITAR");
				System.out.println(request.getParameter("idproveedor"));
				proveedor.setIdprooveedorcl2(Integer.parseInt(request.getParameter("idproveedor")));
				proveedor=crudimp.BuscarProveedor(proveedor);
				request.setAttribute("proveedor", proveedor);
				request.getRequestDispatcher("/frmActualizarProveedor.jsp").forward(request, response);
				
				break;
			case "Registrar":
				System.out.println("ACCION REGISTRAR");
				request.getRequestDispatcher("/frmRegistrarProveedor.jsp").forward(request, response);
				break;
			case "Actualizar":
				System.out.println("GUARDAR ACTUALIZAR");
				proveedor.setIdprooveedorcl2(Integer.parseInt(request.getParameter("codigo")));
				proveedor.setNomproveecl2(request.getParameter("nombre"));
				proveedor.setRsocialproveecl2(request.getParameter("razonSocial"));
				proveedor.setRucproveecl2(request.getParameter("ruc"));
				proveedor.setEmailproveecl2(request.getParameter("email"));
				proveedor.setFeingproveecl2(new Date());
				crudimp.ActualizarProveedor(proveedor);
				listaProv = crudimp.ListadoProveedor();
				request.setAttribute("listado", listaProv);
				dispatcher= request.getRequestDispatcher("menuPrincipal.jsp");
				dispatcher.forward(request, response);
				break;
			case "guardarNuevo":
				System.out.println("GUARDAR NUEVO");
				
				proveedor.setNomproveecl2(request.getParameter("nombre"));
				proveedor.setRsocialproveecl2(request.getParameter("razonSocial"));
				proveedor.setRucproveecl2(request.getParameter("ruc"));
				proveedor.setEmailproveecl2(request.getParameter("email"));
				proveedor.setFeingproveecl2(new Date());
				crudimp.RegistrarProveedor(proveedor);
				listaProv = crudimp.ListadoProveedor();
				request.setAttribute("listado", listaProv);
				dispatcher= request.getRequestDispatcher("menuPrincipal.jsp");
				dispatcher.forward(request, response);
				break;
				
			case "Eliminar":
				System.out.println("ELIMINAR NUEVO");
				proveedor2.setIdprooveedorcl2(Integer.parseInt(request.getParameter("idproveedor").toString()));
				
				crudimp.EliminarProveedor(proveedor2);
				
				listaProv = crudimp.ListadoProveedor();
				request.setAttribute("listado", listaProv);
				dispatcher= request.getRequestDispatcher("menuPrincipal.jsp");
				dispatcher.forward(request, response);
				break;
			case "Listar":
				//redireccionamos hacia la vista(.jsp)
				listaProv = crudimp.ListadoProveedor();
				request.setAttribute("listado", listaProv);
				dispatcher= request.getRequestDispatcher("menuPrincipal.jsp");
				dispatcher.forward(request, response);
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
