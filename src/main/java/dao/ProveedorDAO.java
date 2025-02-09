package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.util.SocketUtils;

import interfaces.IProveedor;
import model.TblProveedorcl2;

public class ProveedorDAO implements IProveedor {

	@Override
	public void RegistrarProveedor(TblProveedorcl2 tblproveedor) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("LPII_CL2_RodriguezPeredaVicente");
		// permite gestionar entidades..
		EntityManager em = emf.createEntityManager();
		// iniciamos la transaccion
		em.getTransaction().begin();
		try {
			// registramos
			em.persist(tblproveedor);
			// emitimos mensaje por pantalla....
			System.out.println("Proveedor registrado en BD correctamente!!!!!!!!");
			// confirmamos
			em.getTransaction().commit();
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		} finally {
			// cerramos la transaccion...
			em.close();
		}

	}

	@Override
	public void ActualizarProveedor(TblProveedorcl2 tblproveedor) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("LPII_CL2_RodriguezPeredaVicente");
		EntityManager em = emf.createEntityManager();
		System.out.println("ACTUALIZAR PROVEEDOR ACA");
		try {
			em.getTransaction().begin();
			em.merge(tblproveedor);
			em.getTransaction().commit();
		} catch (RuntimeException e) {
			System.out.println(e.getMessage()); 
			
		} finally {
			em.close();
		}
		// emitimos mensaje por pantalla....
		System.out.println("Proveedor actualizado en BD correctamente!!!!!!!!");
	}

	@Override
	public void EliminarProveedor(TblProveedorcl2 tblproveedor) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("LPII_CL2_RodriguezPeredaVicente");
		// permite gestionar entidades..
		EntityManager em = emf.createEntityManager();

		try {
			em.getTransaction().begin();
			TblProveedorcl2 provFound = em.find(TblProveedorcl2.class, tblproveedor.getIdprooveedorcl2());
			if (provFound != null) {
				em.remove(provFound);
			}
			em.getTransaction().commit();
		} catch (RuntimeException e) {
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			e.getMessage();

		} finally {
			em.close();
			System.out.println("Proveedor eliminado en BD correctamente!!!!!!!!");
		}

	}

	@Override
	public List<TblProveedorcl2> ListadoProveedor() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("LPII_CL2_RodriguezPeredaVicente");
		EntityManager em = emf.createEntityManager();
		List<TblProveedorcl2> listado = null;

		try {
			em.getTransaction().begin();
			listado = em.createQuery("SELECT t FROM TblProveedorcl2 t", TblProveedorcl2.class).getResultList();
			em.getTransaction().commit();
		} catch (RuntimeException e) {
			System.out.print(e.getMessage());
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			e.getMessage();

		} finally {
			em.close();
		}
		return listado;
	}

	@Override
	public TblProveedorcl2 BuscarProveedor(TblProveedorcl2 tblproveedor) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("LPII_CL2_RodriguezPeredaVicente");
		EntityManager em = emf.createEntityManager();
		TblProveedorcl2 provFound = null;
		try {
			em.getTransaction().begin();
			provFound = em.find(TblProveedorcl2.class, tblproveedor.getIdprooveedorcl2());
			em.getTransaction().commit();
		} catch (RuntimeException e) {
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			e.getMessage();

		} finally {
			em.close();
		}
		System.out.println("Proveedor encontrado: " + provFound.getNomproveecl2());
		return provFound;

	}

}
