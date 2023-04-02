package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medico.DadosAtualizacaoMedicos;
import med.voll.api.medico.DadosCadastroMedico;
import med.voll.api.medico.DadosListagemMedico;
import med.voll.api.medico.model.Medico;
import med.voll.api.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados){

        repository.save(new Medico(dados));
    }

    @GetMapping
    public Page<DadosListagemMedico> listar( @PageableDefault(size=10, page=0, sort={"nome"}) Pageable paginacao){
        //return repository.findAll(paginacao).stream().map(DadosListagemMedico:: new).toList();

        //return repository.findAll(paginacao).map(DadosListagemMedico:: new)

        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico:: new);

        /*
        * Ao criar um método com paginação com os atributos: http://localhost:8080/medicos?size=1&page=2
        * size é a quantidade de itens por página
        * page é qual página você deve buscar
        *
        * http://localhost:8080/medicos?sort=nome,asc&size=3&page=0
        * A atributo sort serve para ordenar, neste caso ordenou os dados pelo nome. O asc ou desc são usados para ordenar
        * de forma crescente ou descrescente.
        * */
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoMedicos dados){

        var medico = repository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);
    }


    @DeleteMapping("/{id}")
    @Transactional
    public void excluir( @PathVariable Long id){

        //repository.deleteById(id); //Excluindo tudo do banco de dados.

        var medico = repository.getReferenceById(id);
        medico.excluir(); //Exclusão lógica.
    }

}
