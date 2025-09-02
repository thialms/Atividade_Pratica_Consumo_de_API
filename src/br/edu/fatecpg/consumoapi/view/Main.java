package br.edu.fatecpg.consumoapi.view;

import br.edu.fatecpg.consumoapi.controller.EnderecoController;
import br.edu.fatecpg.consumoapi.model.Endereco;
import br.edu.fatecpg.consumoapi.service.BuscaEndereco;
import com.google.gson.Gson;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner sc = new Scanner(System.in);

        EnderecoController enderecoController = new EnderecoController();

        int opcao = 0;

        while (opcao != 3){

            System.out.println("1 - Consultar CEP");
            System.out.println("2 - Listar CEP'S Salvos");
            System.out.println("3 - Finalizar programa");

            System.out.println();

            System.out.print("Digite a opção desejada: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao){
                case 1:
                    System.out.print("Digite o cep: ");
                    String cep = sc.nextLine();

                    try {
                        BuscaEndereco buscaEndereco = new BuscaEndereco();
                        Gson gson = new Gson();
                        String endereco = buscaEndereco.getEndereco(cep);
                        Endereco novoEndereco = gson.fromJson(endereco,Endereco.class);
                        System.out.println(novoEndereco);

                        System.out.print("Deseja salvar este endereço no Banco de Dados (s/n)? ");
                        char op = sc.nextLine().toLowerCase().charAt(0);

                        if(op == 's'){
                            System.out.println(enderecoController.insertEndereco(novoEndereco));
                        }
                        else if(op == 'n'){
                            break;
                        }
                    } catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println(enderecoController.selectEndereco());
                    break;
            }
        }
    }
}
