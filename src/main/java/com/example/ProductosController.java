/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

/**
 *
 * @author jgalv
 */
import com.example.Producto;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;
import javax.measure.quantity.Mass;
import static javax.measure.unit.SI.KILOGRAM;
import javax.sql.DataSource;
import org.jscience.physics.amount.Amount;
import org.jscience.physics.model.RelativisticModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
public class ProductosController {
   
    @Autowired
  private DataSource dataSource;

  
    @GetMapping("/Producto")
    public String ProductoForm(Model model){
        model.addAttribute("Producto", new Producto());
        return "Producto";
                
    }
    
    @PostMapping("/Producto")
    public String ProductoSubmit(@ModelAttribute Producto Producto,Model model){
        model.addAttribute("Producto",Producto);
        return "result";
    }

      @RequestMapping("/")
        String index() {
         return "index";
  }
  
  @RequestMapping("/hello")
    String hello(Map<String, Object> model) {
        RelativisticModel.select();
        String energy = System.getenv().get("ENERGY");
         if (energy == null) {
           energy = "12 GeV";
        }
     Amount<Mass> m = Amount.valueOf(energy).to(KILOGRAM);
     model.put("science", "E=mc^2: " + energy + " = "  + m.toString());
    return "hello";
}
//Codigo Para Prueba 1, que consiste crear una lista generica de nombres online usando la listaGenericaLLS



  @RequestMapping("/db")
  String db(Map<String, Object> model) {
    try (Connection connection = dataSource.getConnection()) {
      Statement stmt = connection.createStatement();
      stmt.executeUpdate("CREATE TABLE IF NOT EXISTS ticks (tick timestamp)");
      stmt.executeUpdate("INSERT INTO ticks VALUES (now())");
      ResultSet rs = stmt.executeQuery("SELECT tick FROM ticks");

      ArrayList<String> output = new ArrayList<String>();
      while (rs.next()) {
        output.add("Read from DB: " + rs.getTimestamp("tick"));
      }

      model.put("records", output);
      return "db";
    } catch (Exception e) {
      model.put("message", e.getMessage());
      return "error";
    }
  }
 
}
