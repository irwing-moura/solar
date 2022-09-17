package irwing.moura.solar.service;

import irwing.moura.solar.model.Endereco;
import irwing.moura.solar.repository.EnderecoRepository;
import irwing.moura.solar.response.EnderecoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository repository;


    public List<EnderecoResponse> listarCidadesPorUf(String uf) {
        return repository.listarCidadesPorUf(uf);
    }

}
