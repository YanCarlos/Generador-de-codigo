

/**
*@author Project TLS 2016-2 Ing Software
*/
public class Estudiantes {    
    
    private     int
     ced;
    
    private     long
     codigo;
        
    public Estudiantes(){
        super();
    }

    public Estudiantes
    (    int
     ced,    long
     codigo){
        super();
    
        this.ced = ced;
    
        this.codigo = codigo;
    
    }
        
    public     int
     getCed
    (){
        return this.ced;
    }
    
    public void setCed
    (    int
     ced){
        this.ced = ced;
    }
        
    public     long
     getCodigo
    (){
        return this.codigo;
    }
    
    public void setCodigo
    (    long
     codigo){
        this.codigo = codigo;
    }
    
}
