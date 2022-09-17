package irwing.moura.solar.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable=false)
    private Long id;
    private String uf;
    private String cidade;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "endereco")
    private List<Cliente> clientes;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "endereco")
    private List<Contratante> contratantes;


    public Endereco(String uf, String cidade) {
        this.uf = uf;
        this.cidade = cidade;
    }


}
