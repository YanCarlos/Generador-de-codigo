import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;

/**
*@author Project TLF 2016-2 Ing Software
*/
@Entity
@Table(name="personas")
public class Personas {    
                @Id
            @Column(name="cedula",length = 10,nullable =     false
    )
    private     int
     cedula;
                    @Column(name="nombre",length = 255,nullable =     false
    )
    private     String
     nombre;
                    @Column(name="edad",length = 255,nullable =     false
    )
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
