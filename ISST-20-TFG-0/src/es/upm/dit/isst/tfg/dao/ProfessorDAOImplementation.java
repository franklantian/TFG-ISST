package es.upm.dit.isst.tfg.dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import es.upm.dit.isst.tfg.model.Professor;

public class ProfessorDAOImplementation implements ProfessorDAO {

	//un atributo estatico que es una referencia de objecto de esta misma class,inicialmente es null
	private static ProfessorDAOImplementation instancia = null;

	//Privado, Nadie puede crear un objecto de esta class
	private ProfessorDAOImplementation() {
	}


	public static ProfessorDAOImplementation getInstance() {
		if (null==instancia)
			instancia = new ProfessorDAOImplementation();
		return instancia;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void create(Professor professor) {
		//abrir una session
		Session session = SessionFactoryService.get().openSession(); 
		//arrangar transaccion
		session.beginTransaction();

		//Operacion real
		session.save(professor); 

		//cerrar la transaccion y session
		session.getTransaction().commit();
		session.close();

	}

	@SuppressWarnings("unchecked")
	@Override
	public Professor read(String email) {
		//abrir una session
		Session session = SessionFactoryService.get().openSession(); 
		//arrangar transaccion
		session.beginTransaction();

		//Operacion real
		Professor professor = session.get(Professor.class, email); 

		//cerrar la transaccion y session
		session.getTransaction().commit();
		session.close();

		return professor;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void update(Professor professor) {
		//abrir una session
		Session session = SessionFactoryService.get().openSession(); 
		//arrangar transaccion
		session.beginTransaction();

		//Operacion real
		session.saveOrUpdate(professor); 

		//cerrar la transaccion y session
		session.getTransaction().commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void delete(Professor professor) {
		//abrir una session
		Session session = SessionFactoryService.get().openSession(); 
		//arrangar transaccion
		session.beginTransaction();

		//Operacion real
		session.delete(professor); 

		//cerrar la transaccion y session
		session.getTransaction().commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Professor> readAll() {
		//abrir una session
		Session session = SessionFactoryService.get().openSession(); 
		//arrangar transaccion
		session.beginTransaction();

		//Operacion real
		List<Professor> profs = session.createQuery("from Professor").list();

		//cerrar la transaccion y session
		session.getTransaction().commit();
		session.close();
		return profs;

	}

	@SuppressWarnings("unchecked")
	@Override
	public Professor login(String email, String password) {
		// TODO Auto-generated method stub
		//abrir una session
		Session session = SessionFactoryService.get().openSession(); 
		Professor p = null;
		//arrangar transaccion
		session.beginTransaction();

		//Operacion real
		Query q = session.createQuery("select p from Professor p where p.email = :email and p.password = :password");
		q.setParameter("email", email); 
		q.setParameter("password", password); 
		List<Professor> profs = q.getResultList(); 
		if (profs.size() > 0)
			p = (Professor) (q.getResultList().get(0));
		//Prueba de modelos


		//cerrar la transaccion y session
		session.getTransaction().commit();
		session.close();
		return p;
	}

}
