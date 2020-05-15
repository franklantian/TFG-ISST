package es.upm.dit.isst.tfg.dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import es.upm.dit.isst.tfg.model.Professor;
import es.upm.dit.isst.tfg.model.TFG;

public class TFGDAOImplementation implements TFGDAO {

	private static TFGDAOImplementation instancia = null;

	private TFGDAOImplementation() {
	}


	public static TFGDAOImplementation getInstance() {
		if (null==instancia)
			instancia = new TFGDAOImplementation();
		return instancia;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void create(TFG tfg) {
		Session session = SessionFactoryService.get().openSession(); 
		session.beginTransaction();

		session.save(tfg); 

		session.getTransaction().commit();
		session.close();

	}

	@SuppressWarnings("unchecked")
	@Override
	public TFG read(String email) {
		Session session = SessionFactoryService.get().openSession(); 
		session.beginTransaction();

		TFG tfg = session.get(TFG.class, email); 

		session.getTransaction().commit();
		session.close();

		return tfg;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void update(TFG tfg) {
		Session session = SessionFactoryService.get().openSession(); 
		session.beginTransaction();

		session.saveOrUpdate(tfg); 

		session.getTransaction().commit();
		session.close();

	}

	@SuppressWarnings("unchecked")
	@Override
	public void delete(TFG tfg) {
		Session session = SessionFactoryService.get().openSession(); 
		session.beginTransaction();

		session.delete(tfg); 

		session.getTransaction().commit();
		session.close();

	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<TFG> readAll() {
		Session session = SessionFactoryService.get().openSession(); 
		session.beginTransaction();

		List<TFG> tfgs = session.createQuery("from TFG").list();

		session.getTransaction().commit();
		session.close();
		return tfgs;
	}

	@SuppressWarnings("unchecked")
	@Override
	public TFG login(String email, String password) {
		// TODO Auto-generated method stub
		//abrir una session
		Session session = SessionFactoryService.get().openSession(); 
		TFG t = null;
		//arrangar transaccion
		session.beginTransaction();

		//Operacion real
		Query q = session.createQuery("select t from Professor t where t.email = :email and t.password = :password");
		q.setParameter("email", email); 
		q.setParameter("password", password); 
		List<TFG> tfgs = q.getResultList(); 
		if (tfgs.size() > 0)
			t = (TFG) (q.getResultList().get(0));
		//Prueba de modelos


		//cerrar la transaccion y session
		session.getTransaction().commit();
		session.close();
		return t;
	}

}
