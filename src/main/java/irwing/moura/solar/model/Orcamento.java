package irwing.moura.solar.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Orcamento {


    @Id
    @Column(name = "id")
    private Long id;

    private Timestamp createdAt;
    private Timestamp expiresAt;
    private boolean done;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_cpf", unique = true, nullable=false)
    private Cliente cliente;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contratante_cnpj", unique = true, nullable=false)
    private Contratante contratante;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(mappedBy = "orcamento")
    private List<Pergunta> perguntas;



}
