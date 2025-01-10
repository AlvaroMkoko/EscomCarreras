package com.ipn.mx;

import com.ipn.mx.modelo.entidades.Carrera;
import com.ipn.mx.modelo.repositorio.CarreraRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EscomCarrerasApplication implements CommandLineRunner {
	@Autowired
	CarreraRepositorio dao;

	//Aqui jugamos con la base :D
	@Override
	public void run(String... args) throws Exception {
		Carrera c = new Carrera();
		c.setIdCarrera(1L);
		c.setNombreCarrera("IIA");
		c.setDescripcionCarrera("La IA");
		c.setDuracionCarrera(12);

		dao.save(c);
	}



	public static void main(String[] args){
		SpringApplication.run(EscomCarrerasApplication.class, args);
	}

}
