

/**
*@author Project TLS 2016-2 Ing Software
*/
public class Personas {    
    
    private     int
     cedula;
    
    private     String
     nombre;
    
    private     String
     edad;
        
    public Personas(){
        super();
    }

    public Personas
    (    int
     cedula,    String
     nombre,    String
     edad){
        super();
    
        this.cedula = cedula;
    
        this.nombre = nombre;
    
        this.edad = edad;
    
    }
        
    public     int
     getCedula
    (){
        return this.cedula;
    }
    
    public void setCedula
    (    int
     cedula){
        this.cedula = cedula;
    }
        
    public     String
     getNombre
    (){
        return this.nombre;
    }
    
    public void setNombre
    (    String
     nombre){
        this.nombre = nombre;
    }
        
    public     String
     getEdad
    (){
        return this.edad;
    }
    
    public void setEdad
    (    String
     edad){
        this.edad = edad;
    }
    
}
