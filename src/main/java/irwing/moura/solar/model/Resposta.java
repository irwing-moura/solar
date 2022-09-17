package irwing.moura.solar.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Resposta {

    @Id
    @Column(name = "id")
    private Long id;

    @Column
    private String opcao1;
    @Column
    private String opcao2;
    @Column
    private String opcao3;
    @Column
    private String opcao4;

    @ManyToOne
    @JoinColumn(name = "pergunta_id")
    private Pergunta pergunta;

}
