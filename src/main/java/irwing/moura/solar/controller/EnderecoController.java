package irwing.moura.solar.controller;

import irwing.moura.solar.model.Endereco;
import irwing.moura.solar.response.EnderecoResponse;
import irwing.moura.solar.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService service;


    @GetMapping("/{uf}")
    public List<EnderecoResponse> listarEnderecosPorUf(@PathVariable("uf") String uf) {
        return service.listarCidadesPorUf(uf);
    }


}
