/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;



import org.springframework.data.annotation.Id;

/**
 *
 * @author jgalv
 */
public class Producto {
    @Id
    private Integer id, stock;
    private String nombre, codigo;
    private Double precio;

    
    //Estructura :
    //01,20,"Manzana","A23",850
   
    public Producto(){

    }
    public Producto(Integer idd,Integer stockc, String nom, String cod, Double prec){
        this.id = idd;
        this.stock = stockc;
        this.nombre = nom;
        this.codigo = cod;
        this.precio= prec;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
    
    
    public String toString(){
        return String.format(
        "Producto[id=%s, stock =%s , nombre ='%s',codigo = '%s',precio =%s]",
                id,stock,nombre,codigo,precio);
        
    }
}
