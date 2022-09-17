package irwing.moura.solar.repository;

import irwing.moura.solar.model.Endereco;
import irwing.moura.solar.response.EnderecoResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    @Query("select new irwing.moura.solar.response.EnderecoResponse(e.id, e.uf, e.cidade) " +
            "from Endereco e " +
            "where e.uf = :uf " +
            "order by e.cidade asc")
    List<EnderecoResponse> listarCidadesPorUf(@Param("uf") String uf);

}
