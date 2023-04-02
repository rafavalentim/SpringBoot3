package med.voll.api.paciente;

import jakarta.validation.constraints.NotNull;
import med.voll.api.endereco.model.Endereco;

public record DadosAtualizacaoPaciente(
        @NotNull
        Long id,

        String nome,

        String telefone,

        String email,

        Endereco endereco
) {
}
