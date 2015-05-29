package br.edu.utfpr.cm.pi.beans;

import br.edu.utfpr.cm.pi.daos.CargoDao;

public class teste {

    public static void main(String[] args) {

        Cargo cargo1 = new Cargo();
        cargo1.setNome("Cozinheira");
        cargo1.setAdmin(false);
        Cargo cargo2 = new Cargo();

        CargoDao cargoDao = new CargoDao();
        cargoDao.save(cargo1);
        cargo2 = cargoDao.findById(1L);
        System.out.println(cargo2);

    }
}
