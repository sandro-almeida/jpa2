package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;

public class TestaNativeQuery {

    public static void main(String[] args) {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
        EntityManager em = emf.createEntityManager();
        
        // Executa query SQL nativa
        //
        Query sqlQuery = em.createNativeQuery("select * from movimentacao where conta_id = :pId", Movimentacao.class);
        sqlQuery.setParameter("pId", 2L);
        List<Movimentacao> movimentacoes = sqlQuery.getResultList(); 

        System.out.println("Lista de movimentacoes: " + movimentacoes);
    }
}