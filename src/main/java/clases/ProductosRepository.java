/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.util.List;
import com.example.Producto;

import org.springframework.data.mongodb.repository.MongoRepository;
/**
 *
 * @author jgalv
 */
public interface ProductosRepository extends MongoRepository<Producto, String>{
    public Producto findByName(String nombre);
    public List<Producto> findBycode(String codigo);
    
}
