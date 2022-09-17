package irwing.moura.solar.controller;

import irwing.moura.solar.request.ClienteCadastroRequest;
import irwing.moura.solar.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/cliente")
public class ClienteController {


    private final ClienteService service;

    @Autowired
    public ClienteController(ClienteService service) {
        this.service = service;
    }

    @PostMapping("/")
    public void cadastrarCliente(@Valid @RequestBody ClienteCadastroRequest cliente) {
        service.cadastrar(cliente);
    }

}
