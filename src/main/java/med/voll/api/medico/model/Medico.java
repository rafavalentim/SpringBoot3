package med.voll.api.medico.model;

import jakarta.persistence.*;
import lombok.*;
import med.voll.api.endereco.model.Endereco;
import med.voll.api.medico.DadosAtualizacaoMedicos;
import med.voll.api.medico.DadosCadastroMedico;
import med.voll.api.medico.Especialidade;

@Table(name="medicos")
@Entity(name="Medico")
@Getter
@NoArgsConstructor
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;

    private String telefone;
    private String crm;

    private Boolean ativo;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    public Medico(DadosCadastroMedico dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.crm = dados.crm();
        this.endereco = new Endereco(dados.endereco());
        this.especialidade = dados.especialidade();
        this.telefone = dados.telefone();
        this.ativo = true;
    }

    public void atualizarInformacoes(DadosAtualizacaoMedicos dados){

        if(dados.nome() != null){
            this.nome = dados.nome();
        }

        if (dados.telefone() != null) {
            this.telefone = dados.telefone();

        }

        if(dados.endereco() != null){
            this.endereco.atualizarInformacoes(dados.endereco()) ;
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
