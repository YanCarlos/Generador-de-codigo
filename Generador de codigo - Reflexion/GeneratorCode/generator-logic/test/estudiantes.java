import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;

/**
*@author Project TLF 2016-2 Ing Software
*/
@Entity
@Table(name="estudiantes")
public class Estudiantes {    
                @Id
            @Column(name="ced",length = 10,nullable =     false
    )
    private     int
     ced;
                    @Column(name="codigo",length = 19,nullable =     false
    )
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
