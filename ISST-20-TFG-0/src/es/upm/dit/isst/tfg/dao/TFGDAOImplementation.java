package es.upm.dit.isst.tfg.dao;

import java.util.Collection;

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

	@Override
	public void create(TFG tfg) {
		// TODO Auto-generated method stub

	}

	@Override
	public TFG read(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(TFG tfg) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(TFG tfg) {
		// TODO Auto-generated method stub

	}

	@Override
	public Collection<TFG> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TFG login(String email, String psd) {
		// TODO Auto-generated method stub
		return null;
	}

}
