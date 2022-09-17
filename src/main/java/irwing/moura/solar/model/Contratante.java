package irwing.moura.solar.model;

import irwing.moura.solar.request.ContratanteCadastroRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Contratante {

    @Id
    @Column(name = "cnpj")
    private String cnpj;
    private String nome;
    private String email;
    private String senha;
    private String numCelular;

    @ManyToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    @OneToOne(mappedBy = "contratante", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Orcamento contratante;


    public Contratante(ContratanteCadastroRequest request, Endereco endereco) {
        this.cnpj = request.getCnpj();
        this.nome = request.getNome();
        this.email = request.getEmail();
        this.senha = request.getSenha();
        this.numCelular = request.getCelular();
        this.endereco = endereco;
    }
}
