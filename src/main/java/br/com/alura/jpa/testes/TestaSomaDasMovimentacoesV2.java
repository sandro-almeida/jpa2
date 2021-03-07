package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.dao.MovimentacaoDAO;

public class TestaSomaDasMovimentacoesV2 {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
        EntityManager em = emf.createEntityManager();
        
        MovimentacaoDAO movimentacaoDAO = new MovimentacaoDAO(em);

        System.out.println("A soma das movimentacoes eh: " + movimentacaoDAO.somaDasMovimentacoes());
    }
}