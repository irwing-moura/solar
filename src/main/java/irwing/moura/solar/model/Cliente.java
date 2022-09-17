package irwing.moura.solar.model;

import irwing.moura.solar.request.ClienteCadastroRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Cliente {

    @Id
    @Column(name = "cpf")
    private String cpf;

    private String nome;
    private String email;
    private String cnpj;
    private String senha;
    private String numCelular;

    private String segmento;


    @ManyToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

    @OneToOne(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Orcamento orcamento;


    public Cliente(ClienteCadastroRequest request, Endereco endereco) {
        this.cpf = request.getCpf();
        this.nome = request.getNome();
        this.email = request.getEmail();
        this.cnpj = request.getCnpj();
        this.senha = request.getSenha();
        this.numCelular = request.getCelular();
        this.segmento = request.getSegmento().name();
        this.endereco = endereco;
    }
}
