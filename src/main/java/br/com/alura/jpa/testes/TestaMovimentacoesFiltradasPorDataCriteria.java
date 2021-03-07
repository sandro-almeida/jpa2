package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.dao.MovimentacaoDAO;
import br.com.alura.jpa.modelo.Movimentacao;

public class TestaMovimentacoesFiltradasPorDataCriteria {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
        EntityManager em = emf.createEntityManager();
        
        MovimentacaoDAO movimentacaoDAO = new MovimentacaoDAO(em);
        
        List<Movimentacao> movimentacoes = movimentacaoDAO.getMovimentacoesFiltradasPorData(1, null, 2021);

        for (Movimentacao movimentacao : movimentacoes) {
            System.out.println("Movimentacao: " + movimentacao);
            System.out.println("------------------------------");
        }
    }
}