package irwing.moura.solar.repository;

import irwing.moura.solar.model.Contratante;
import irwing.moura.solar.response.ContratanteResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContratanteRepository extends JpaRepository<Contratante, String> {

    @Query("select new irwing.moura.solar.response.ContratanteResponse(c.nome, c.cnpj, c.email, c.numCelular) " +
            "from Contratante c " +
            "where c.endereco.uf = :uf")
    List<ContratanteResponse> recuperarContratantesPorUf(@Param("uf") String uf);


    @Query("select new irwing.moura.solar.response.ContratanteResponse(c.nome, c.cnpj, c.email, c.numCelular) " +
            "from Contratante c " +
            "where c.endereco.uf = :uf " +
            "and c.endereco.cidade = :cidade")
    List<ContratanteResponse> recuperarContratantesPorUfCidade(@Param("uf") String uf, @Param("cidade") String cidade);

}
