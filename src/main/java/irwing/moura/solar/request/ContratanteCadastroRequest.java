package irwing.moura.solar.request;

import irwing.moura.solar.model.Segmento;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
public class ContratanteCadastroRequest {

    @NotNull
    @Size(max = 20, message = "nome suporta o máximo de 20 caracteres")
    private String nome;
    @NotNull
    private String email;
    @NotNull
    @Size(max = 16, message = "celular suporta o máximo de 14 caracteres")
    private String celular;
    @NotNull
    private Long idEndereco;
    @Size(max = 20, message = "cnpj suporta o máximo de 14 caracteres")
    private String cnpj;
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$",
            message = "senha deve conter pelo menos 1 digito [0-9], " +
                    " 1 caractere minusculo [a-z], 1 caractere maiusculo [A-Z]," +
                    " 1 caractere especial [!@#&] e tamanho entre 8 e 20 caracteres.")
    private String senha;

}
