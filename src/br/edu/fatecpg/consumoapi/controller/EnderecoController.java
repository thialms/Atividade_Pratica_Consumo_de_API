package br.edu.fatecpg.consumoapi.controller;

import br.edu.fatecpg.consumoapi.model.Endereco;
import br.edu.fatecpg.consumoapi.service.Banco;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EnderecoController {

    public String insertEndereco(Endereco endereco){

        String query = "INSERT INTO tb_endereco(cep, rua, bairro, localidade, estado) VALUES(?, ?, ?, ?, ?)";

        try(var conexao = Banco.connection()){
            PreparedStatement stmt = conexao.prepareStatement(query);
            stmt.setString(1, endereco.getCep());
            stmt.setString(2, endereco.getRua());
            stmt.setString(3, endereco.getBairro());
            stmt.setString(4, endereco.getLocalidade());
            stmt.setString(5, endereco.getEstado());

            stmt.execute();
            return "Endereço salvo com sucesso!";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String selectEndereco(){

        List<Endereco> enderecos = new ArrayList<>();

        String query = "SELECT * FROM tb_endereco";

        try(var conexao = Banco.connection()){
            PreparedStatement stmt = conexao.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                enderecos.add(new Endereco(rs.getInt("id"),rs.getString("cep"), rs.getString("rua"),rs.getString("bairro"), rs.getString("localidade"), rs.getString("estado")));
            }

            StringBuilder sb = new StringBuilder();
            for (Endereco endereco : enderecos) {
                sb.append(endereco.toString());
                sb.append("\n");
            }

            return sb.toString();

        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
