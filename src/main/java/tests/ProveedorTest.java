package tests;

import java.util.Date;
import java.util.List;

import dao.ProveedorDAO;
import model.TblProveedorcl2;

public class ProveedorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// instanciamos la respectivas clases
		TblProveedorcl2 tbl = new TblProveedorcl2();
		ProveedorDAO crudimp = new ProveedorDAO();
		// asignamos los respectivos valores

		//Crear proveedor
		/*
		tbl.setNomproveecl2("Banco de Comercio");
		tbl.setRsocialproveecl2("Banco de Comercio");
		tbl.setEmailproveecl2("mail@comercio.com");
		Date fecha = new Date();
		Date fechasql = new Date(fecha.getTime());
		tbl.setFeingproveecl2(fechasql);
		tbl.setRucproveecl2("207894562");
		crudimp.RegistrarProveedor(tbl);
		*/

		//Actualizar proveedor
		/*
		tbl.setIdprooveedorcl2(1);
		tbl.setNomproveecl2("Interbank");
		tbl.setRsocialproveecl2("Banco Internacional");
		tbl.setEmailproveecl2("interbank@info.com");
		Date fecha = new Date();
		Date fechasql = new Date(fecha.getTime());
		tbl.setFeingproveecl2(fechasql);
		tbl.setRucproveecl2("2044552266");
		// invocamos el respectivo metodo registrar...
		crudimp.ActualizarProveedor(tbl);
		*/
		
		//Eliminar proveedor
		/*
		tbl.setIdprooveedorcl2(1);
		// invocamos el respectivo metodo registrar...
		crudimp.EliminarProveedor(tbl);
		*/
		
		//Buscar proveedor
		/*
		tbl.setIdprooveedorcl2(2);
		TblProveedorcl2 tblFound = crudimp.BuscarProveedor(tbl);
		*/
		
		//Lista proveedores
		List<TblProveedorcl2> listado = crudimp.ListadoProveedor();
		for(TblProveedorcl2 item:listado){
			System.out.println(" ID: " + item.getIdprooveedorcl2() + 
					" Nombre: " + item.getNomproveecl2()+ 
					" Razón Social: " + item.getRsocialproveecl2());
		}
		
	}

}
