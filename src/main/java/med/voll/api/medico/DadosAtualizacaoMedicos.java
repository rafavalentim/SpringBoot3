package med.voll.api.medico;

import jakarta.validation.constraints.NotNull;
import med.voll.api.endereco.DadosEndereco;
import med.voll.api.endereco.model.Endereco;

public record DadosAtualizacaoMedicos(
        @NotNull
        Long id,
        String nome,
        String telefone,
        Endereco endereco) {
}
