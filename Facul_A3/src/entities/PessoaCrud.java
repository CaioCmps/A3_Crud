package entities;

import java.util.ArrayList;
import java.util.List;

public class PessoaCrud {
    private List<Pessoa> pessoas;

    public PessoaCrud() {
        this.pessoas = new ArrayList<>();
    }

    // Create
    public void addPessoa(Pessoa pessoa) {
        pessoas.add(pessoa);
    }

    // Read
    public Pessoa getPessoa(String nome) {
        for (Pessoa pessoa : pessoas) {
            if (pessoa.getNome().equals(nome)) {
                return pessoa;
            }
        }
        return null;
    }

    // Update
    public void updatePessoa(String nome, Pessoa dadosAtualizados) {
        Pessoa pessoa = getPessoa(nome);
        if (pessoa != null) {
            pessoa.setNome(dadosAtualizados.getNome());
            if (pessoa instanceof PessoaFisica) {
                ((PessoaFisica) pessoa).setCpf(((PessoaFisica) dadosAtualizados).getCpf());
            } else if (pessoa instanceof PessoaJuridica) {
                ((PessoaJuridica) pessoa).setCnpj(((PessoaJuridica) dadosAtualizados).getCnpj());
            }
        }
    }

    // Delete
    public void deletePessoa(String nome) {
        Pessoa pessoa = getPessoa(nome);
        if (pessoa != null) {
            pessoas.remove(pessoa);
        }
    }
}
