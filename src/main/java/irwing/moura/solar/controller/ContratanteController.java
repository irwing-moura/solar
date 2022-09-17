package irwing.moura.solar.controller;

import irwing.moura.solar.request.ContratanteCadastroRequest;
import irwing.moura.solar.response.ContratanteResponse;
import irwing.moura.solar.service.ContratanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/contratante")
public class ContratanteController {

    private final ContratanteService service;

    @Autowired
    public ContratanteController(ContratanteService service) {
        this.service = service;
    }


    @PostMapping("/")
    public void cadastrarContratante(@Valid @RequestBody ContratanteCadastroRequest request) throws Exception {
        service.cadastrar(request);
    }

    @GetMapping("/{cnpj}")
    public ContratanteResponse info(@PathVariable ("cnpj") String cnpj) throws Exception {
        return service.buscarPorCnpj(cnpj);
    }


    @GetMapping("/all/{uf}")
    public List<ContratanteResponse> listarContratantesPorUf(@PathVariable("uf") String uf) {
        return service.listarContratantes(uf, null);
    }

    @GetMapping("/{uf}/{cidade}")
    public List<ContratanteResponse> listarContratantesPorUf(@PathVariable("uf") String uf,
                                                             @PathVariable("cidade") String cidade) {
        return service.listarContratantes(uf, cidade);
    }




}
