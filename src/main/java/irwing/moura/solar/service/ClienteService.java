package irwing.moura.solar.service;

import irwing.moura.solar.model.Cliente;
import irwing.moura.solar.model.Endereco;
import irwing.moura.solar.repository.ClienteRepository;
import irwing.moura.solar.repository.EnderecoRepository;
import irwing.moura.solar.request.ClienteCadastroRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {


    private final ClienteRepository repository;
    private final EnderecoRepository enderecoRepository;

    @Autowired
    public ClienteService(ClienteRepository repository, EnderecoRepository enderecoRepository) {
        this.repository = repository;
        this.enderecoRepository = enderecoRepository;
    }

    public Cliente cadastrar(ClienteCadastroRequest request) {
        try {

            Optional<Endereco> endereco = enderecoRepository.findById(request.getIdEndereco());

            if(endereco.isPresent()){
                return repository.save(new Cliente(request, endereco.get()));
            }

            throw new Exception("Endereco não existente.");

        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
