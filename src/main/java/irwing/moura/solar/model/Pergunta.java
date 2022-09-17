package irwing.moura.solar.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pergunta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column
    private String texto;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "pergunta")
    private List<Resposta> respostas;

    @ManyToOne
    @JoinColumn(name = "orcamento_id")
    private Orcamento orcamento;

}
