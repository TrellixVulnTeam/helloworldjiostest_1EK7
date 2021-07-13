/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listaGenericaLLS;

/**
 *
 * @author nina.valdivia
 */
public class Nodo<T> {
    private T info;
    private Nodo<T> link;
    
    public Nodo(){
        this.info=null;
        this.link= null;
    }
    public Nodo( T e){
        this.info=e;
        this.link=null;
    }
    public Nodo(Nodo<T> nodo){
        this.info= nodo.info;
        this.link= nodo.link;
    }
    
    @Override
    public String toString(){
        return info.toString() + "-->";
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public Nodo<T> getLink() {
        return link;
    }

    public void setLink(Nodo<T> link) {
        this.link = link;
    }
    
    
}
