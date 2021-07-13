/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 *
 * @author jgalv
 */
@SpringBootApplication
public class AccessingDataMongodbApplication implements CommandLineRunner {

  @Autowired
  private ProductosRepository repository;

  public static void main(String[] args) {
    SpringApplication.run(AccessingDataMongodbApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {

    repository.deleteAll();

    // save a couple of customers
     //Estructura :
    //01,20,"Manzana","A23",850
    repository.save(new Producto(01,20,"Manzana","A23",850.0));
    repository.save(new Producto(02,15,"Pera","B24",650.0));

    // fetch all customers
    System.out.println("Producto encontrado por findAll():");
    System.out.println("-------------------------------");
    for (Producto producto : repository.findAll()) {
      System.out.println(producto);
    }
    System.out.println();

    // fetch an individual customer
    System.out.println("Customer found with findByFirstName('Alice'):");
    System.out.println("--------------------------------");
    System.out.println(repository.findByName("Manzana"));

    System.out.println("Customers found with findByLastName('Smith'):");
    System.out.println("--------------------------------");
    for (Producto producto : repository.findBycode("B24")) {
      System.out.println(producto);
    }

  }

}
