/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.crud.model.servicos;

import br.edu.ifpb.crud.model.daos.PessoaDAO;
import br.edu.ifpb.crud.model.entidades.Pessoa;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Claudivan Moreira
 */
public class PessoaService implements BaseService {

    private final PessoaDAO pessoaDAO;

    public PessoaService() {
        this.pessoaDAO = new PessoaDAO();
    }

    @Override
    public String execute(HttpServletRequest request) {
        String proximaPagina = "index.jsp";
        String acao = request.getParameter("acao");
        if (acao != null) {
            if (acao.equals("listar")) {
                request.setAttribute("listaPessoas", listaPessoas());
                proximaPagina = "listagem.jsp";
            } else if (acao.equals("add")) {
                cadastraPessoa(request);
                proximaPagina = "cadastro.jsp";
            } else if (acao.equals("remover")) {
                removePessoa(request);
                proximaPagina = "index.jsp";
            } else if (acao.equals("selecinar")) {
                proximaPagina = "edita.jsp";
                request.setAttribute("pessoa", getPessoa(request));
            } else if (acao.equals("editar")) {
                proximaPagina = "edita.jsp";
                editaPessoa(request);
            }
        }
        return proximaPagina;
    }

    private void cadastraPessoa(HttpServletRequest request) {
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String id = request.getParameter("id");

        Pessoa novaPessoa = new Pessoa();
        novaPessoa.setNome(nome);
        novaPessoa.setEmail(email);

        try {
            this.pessoaDAO.startTransaction();
            this.pessoaDAO.salvaPessoa(novaPessoa);
            this.pessoaDAO.commitTransaction();
            request.setAttribute("infoMessage", "Cadastro realizado com sucesso!");
        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("errorMessage", "Erro no cadastro: " + ex.getMessage());
        }
    }

    private void editaPessoa(HttpServletRequest request) {

        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String id = request.getParameter("id");

        Pessoa novaPessoa = new Pessoa();
        novaPessoa.setId(Long.parseLong(id));
        novaPessoa.setNome(nome);
        novaPessoa.setEmail(email);
        try {
            this.pessoaDAO.startTransaction();
            this.pessoaDAO.atualizaPessoa(novaPessoa);
            this.pessoaDAO.commitTransaction();
            request.setAttribute("infoMessage", "Cadastro atualizado com sucesso!");
        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("errorMessage", "Erro na atualização: " + ex.getMessage());
        }
    }

    private List<Pessoa> listaPessoas() {
        return this.pessoaDAO.getAllPessoa();
    }

    private void removePessoa(HttpServletRequest request) {
        Long id = Long.parseLong(request.getParameter("id"));

        try {
            Pessoa pessoa = this.pessoaDAO.get(id);
            if (pessoa != null) {
                this.pessoaDAO.startTransaction();
                this.pessoaDAO.removePessoa(pessoa);
                this.pessoaDAO.commitTransaction();
                request.setAttribute("infoMessage", "Exclusão realizada com sucesso!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            request.setAttribute("errorMessage", "Ocorreu um erro durante a exclusão: " + ex.getMessage());
        }
    }

    private Pessoa getPessoa(HttpServletRequest request) {
        Long id = Long.parseLong(request.getParameter("id"));
        return this.pessoaDAO.get(id);
    }

}
