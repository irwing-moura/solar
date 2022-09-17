package irwing.moura.solar.service;

import irwing.moura.solar.model.Contratante;
import irwing.moura.solar.model.Endereco;
import irwing.moura.solar.repository.ContratanteRepository;
import irwing.moura.solar.repository.EnderecoRepository;
import irwing.moura.solar.request.ContratanteCadastroRequest;
import irwing.moura.solar.response.ContratanteResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContratanteService {

    private final ContratanteRepository repository;
    private final EnderecoRepository enderecoRepository;

    @Autowired
    public ContratanteService(ContratanteRepository repository, EnderecoRepository enderecoRepository) {
        this.repository = repository;
        this.enderecoRepository = enderecoRepository;
    }

    public Contratante cadastrar(ContratanteCadastroRequest request) throws Exception {

        String cnpjNoMask = request.getCnpj().replaceAll("\\p{Punct}", "");
        Optional<Endereco> endereco = enderecoRepository.findById(request.getIdEndereco());

        if (endereco.isPresent()) {

            if(repository.findById(cnpjNoMask).isPresent()){
                throw new Exception("Usuário já cadastrado com este cnpj.");
            }

            return repository.save(new Contratante(request, endereco.get()));
        }

        throw new Exception("Endereco não existente.");
    }

    public ContratanteResponse buscarPorCnpj(String cnpj) throws Exception {
        Optional<Contratante> contratante = repository.findById(cnpj);

        if (contratante.isPresent()){
            return new ContratanteResponse(contratante.get().getNome(),
                    contratante.get().getCnpj(),
                    contratante.get().getEmail(),
                    contratante.get().getNumCelular());
        }

        throw new Exception("Contratante não existe para o cnpj passado.");
    }


    public List<ContratanteResponse> listarContratantes(String uf, String cidade) {
        if(cidade != null)
            return repository.recuperarContratantesPorUfCidade(uf, cidade);
        return repository.recuperarContratantesPorUf(uf);
    }




}
