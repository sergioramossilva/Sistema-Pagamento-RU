package br.edu.utfpr.cm.pi.daos;

import br.edu.utfpr.cm.pi.beans.Cargo;

public class CargoDao extends JpaDao<Cargo, Long> {

    public CargoDao() {
        super(Cargo.class);
    }
}