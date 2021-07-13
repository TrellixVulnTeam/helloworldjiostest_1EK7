/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listaGenericaLLS;

import java.util.Iterator;

/**
 *
 * @author nina.valdivia
 * @param <T>
 */
public class Lista <T> implements Iterable<T> {
    private Nodo<T> lista;
    
    public Lista(){
        lista=null;
    }
    
    public Lista(int n){
        lista=null;
    }
    
    public boolean add(T e){
        Nodo<T> p= new Nodo<>(e);
        p.setLink(lista);
        lista= p;
        return true;
    }
    
    
    
    @Override
    public String toString(){
       StringBuilder s= new StringBuilder();
        Nodo<T> r;
        r= lista;
        
        while(r!=null){
            s.append(r.getInfo().toString());
            s.append("\n");
            r = r.getLink();
        }
        
        return s.toString();
    }
    
    public boolean addLast(T e){
        Nodo<T> p= new Nodo(e);
        
        if(lista==null){
            lista= p;
        }
        else{
            Nodo<T> t;
            Nodo<T> q;
            
            t= lista;
            q= t;
            
            while(t!=null){
                q= t;
                t= t.getLink();                
            }
            
            q.setLink(p);
        }
        return true;
    }
    
    public boolean remove(T e){
        Nodo<T> t;
        Nodo<T> q;
        boolean encontrado= false;
        t= lista;
        q=t;
        
        while (t!=null && !encontrado){
            if(e.equals(t.getInfo())){
                encontrado=true;
                //eliminar
                if(q==t){
                    lista=t.getLink();
                }else{
                    q.setLink(t.getLink());
                }
            }
            else{
                q=t;
                t= t.getLink();
            }
            
        }
        
        return encontrado;
    }
    
    
    
    public boolean isEmpty(){
        return lista==null;
    }
    
   
    
    public int indexOf(T e){
        //retorna -1 si el elemento NO está
        //El primero se encuentra en la posición 0
        //if (lista==null)
        boolean existe=false;
        int pos=0;
        Nodo<T> p= lista;
        while(p!=null && !existe){
            if (e.equals(p.getInfo())){
                existe=true;
            }
            else{
                p= p.getLink();
                pos++;
            }
        }
        
        if (existe){
            return pos;
        }
        return -1;      
    }
    
    @Override
    public Iterator<T> iterator(){
        return new MiClase();       
    }
    
    public class MiClase implements Iterator<T>{
        private Nodo<T> inicio;
        
        public MiClase(){
            inicio=lista;
        }
        
        @Override
        public boolean hasNext(){
           return  inicio!=null;
        }
        
        @Override
        public T next(){
            T e= inicio.getInfo();
            inicio= inicio.getLink();
            return e;
        }
    }
    
 
    public int size(){
        int total=0;
        Nodo<T> r;
        r= lista;
        
        while(r!=null){
            total++;
            r = r.getLink();
        }
        
        return total;
    }
    

    //Asigna el elemento en la posición i (0 es la primera pos.)
    //Debe cuidar que i esté dentro de los límites de la lista
    public void set(int i, T e){
        int pos=0;
        Nodo<T> p= lista;
        while (p!=null  && pos<i){
            p= p.getLink();
            pos++;
        }
        if (p!=null){  //Posición encontrada
            p.setInfo(e);
        }
    }
    

    //Retorna el i-esimo elemento de la lista.
    public T get(int i){
        int pos=0;
        Nodo<T> p= lista;
        while(p!=null && pos<i){
            p= p.getLink();
            pos++;
        }
        if (p!=null){
            return p.getInfo();
        }
        return null;
    }
    
    
    public void clear(){
        lista=null;
    }
    
    
    //Elimina último elemento agregado con add(e)
    public T remove(){
        T e = lista.getInfo();
        lista=  lista.getLink();
        return e;
    }
    
    public T peek(){
        return lista.getInfo();
    }
    
}
