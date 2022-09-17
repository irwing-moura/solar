package irwing.moura.solar.response;

import irwing.moura.solar.model.Endereco;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContratanteResponse {

    private String nome;
    private String cnpj;
    private String email;
    private String celular;

}
