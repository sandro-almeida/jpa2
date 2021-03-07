package br.com.alura.jpa.testes;


import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class TestaSomaDasMovimentacoes {

    public static void main(String[] args) {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
        EntityManager em = emf.createEntityManager();
        
        // Calcula a soma
        //
        String jpql = "select sum(m.valor) from Movimentacao m";

        TypedQuery<BigDecimal> query = em.createQuery(jpql, BigDecimal.class);
        BigDecimal soma = query.getSingleResult();

        System.out.println("A soma das movimentacoes eh: " + soma);

        // Calcula a media: retorno da funcao avg() eh do tipo Double
        //
        jpql = "select avg(m.valor) from Movimentacao m";

        TypedQuery<Double> query2 = em.createQuery(jpql, Double.class);
        Double media = query2.getSingleResult();

        System.out.println("A media das movimentacoes eh: " + media);

        em.close();
    }
}