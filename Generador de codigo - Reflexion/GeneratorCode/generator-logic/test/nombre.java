import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;

/**
*@author Project TLF 2016-2 Ing Software
*/
@Entity
@Table(name="nombre")
public class Nombre {    
                @Id
            @Column(name="identificador",length = 22,nullable =     false
    )
    private     double
     identificador;
                    @Column(name="nombre",length = 100,nullable =     true )
    private     String
     nombre;
        
    public Nombre(){
        super();
    }

    public Nombre
    (    double
     identificador,    String
     nombre){
        super();
    
        this.identificador = identificador;
    
        this.nombre = nombre;
    
    }
        
    public     double
     getIdentificador
    (){
        return this.identificador;
    }
    
    public void setIdentificador
    (    double
     identificador){
        this.identificador = identificador;
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
    
}
