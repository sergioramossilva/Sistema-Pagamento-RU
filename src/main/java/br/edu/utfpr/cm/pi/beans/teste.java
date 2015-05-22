package br.edu.utfpr.cm.pi.beans;

import br.edu.utfpr.cm.pi.daos.CargoDao;

public class teste {

	public static void main(String[] args) {
		
		Cargo cargo = new Cargo();
		cargo.setNome("Cozinheira");
		cargo.setAdmin(false);
		
		CargoDao dao = new CargoDao();
		
		dao.save(cargo);
		
		
	}

}
