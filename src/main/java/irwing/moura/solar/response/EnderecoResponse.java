package irwing.moura.solar.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoResponse {
    private Long id;
    private String uf;
    private String cidade;
}
