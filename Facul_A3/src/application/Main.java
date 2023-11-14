package application;

import entities.PessoaCrud;
import entities.PessoaFisica;
import entities.PessoaJuridica;

public class Main {
    public static void main(String[] args) {
        PessoaCrud pessoaCRUD = new PessoaCrud();

        // Create
        PessoaFisica pessoaFisica = new PessoaFisica("Caio", "123456789");
        PessoaJuridica pessoaJuridica = new PessoaJuridica("Companhia", "987654321");

        // Add
        pessoaCRUD.addPessoa(pessoaFisica);
        pessoaCRUD.addPessoa(pessoaJuridica);

        // read
        System.out.println("Pessoa Física: " + pessoaCRUD.getPessoa("Caio").getNome());
        System.out.println("Pessoa Jurídica: " + pessoaCRUD.getPessoa("Companhia").getNome());

        // Update
        pessoaFisica.setNome("Caio Campos");
        pessoaCRUD.updatePessoa("Caio", pessoaFisica);
        System.out.println("Pessoa Física (atualizada): " + pessoaCRUD.getPessoa("Caio Campos").getNome());

        // Delete
        pessoaCRUD.deletePessoa("Companhia");
        System.out.println("Pessoa Jurídica: " + pessoaCRUD.getPessoa("Companhia"));  // Deve retornar null
    }
}
