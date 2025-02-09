package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import interfaces.IUsuario;
import model.TblUsuariocl2;

public class UsuarioDAO implements IUsuario {

	@Override
	public boolean validarUsuario(String usuario, String password) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("LPII_CL2_RodriguezPeredaVicente");
		EntityManager em = emf.createEntityManager();
		TblUsuariocl2 usuarioFound = null;
		List<TblUsuariocl2> listado = null;
		boolean validado = false;
		try {
			String sql="SELECT t FROM TblUsuariocl2 t where t.usuariocl2= :user and t.passwordcl2=:pass";
			Query query= em.createQuery(sql);
			query.setParameter("user", usuario).setParameter("pass", password);
		    System.out.print(sql);
			em.getTransaction().begin();
			listado = query.getResultList();
			if(!listado.isEmpty()){
				usuarioFound = listado.get(0);
				validado=true;
				System.out.println("BIENVENIDO " + usuarioFound.getUsuariocl2());
			}else{
				System.out.println("Usuario o Contraseña inválida");	
			}
			em.getTransaction().commit();
		} catch (RuntimeException e) {
			System.out.print(e.getMessage());
			if (em.getTransaction().isActive())
				em.getTransaction().rollback();
			e.getMessage();

		} finally {
			em.close();
		}
		
		return validado;
	}

}
