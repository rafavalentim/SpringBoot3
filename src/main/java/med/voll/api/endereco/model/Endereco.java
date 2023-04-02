package med.voll.api.endereco.model;

import jakarta.persistence.Embeddable;
import lombok.*;
import med.voll.api.endereco.DadosEndereco;

@Embeddable
@Getter
@NoArgsConstructor
@Setter
@AllArgsConstructor
public class Endereco {
    private String logradouro;
    private String bairro;
    private String cep;
    private String numero;
    private String complemento;
    private String cidade;
    private String uf;

    public Endereco(DadosEndereco endereco) {
        this.logradouro = endereco.logradouro();
        this.bairro = endereco.bairro();
        this.cep = endereco.cep();
        this.numero = endereco.numero();
        this.complemento = endereco.complemento();
        this.cidade = endereco.cidade();
        this.uf = endereco.uf();
    }

    public void atualizarInformacoes(Endereco dados) {
        if(dados.logradouro != null){
            this.logradouro = dados.getLogradouro();
        }
        if(dados.bairro != null){
            this.bairro = dados.getBairro();
        }
        if(dados.cep != null){
            this.cep = dados.getCep();
        }
        if(dados.numero != null){
            this.numero = dados.getNumero();
        }
        if(dados.complemento != null){
            this.complemento = dados.getComplemento();
        }
        if(dados.cidade != null){
            this.cidade = dados.getCidade();
        }
        if(dados.uf != null){
            this.uf = dados.getUf();
        }
    }
}
