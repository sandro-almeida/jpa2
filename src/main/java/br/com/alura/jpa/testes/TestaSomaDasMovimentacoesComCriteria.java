package br.com.alura.jpa.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;

import br.com.alura.jpa.modelo.Movimentacao;

public class TestaSomaDasMovimentacoesComCriteria {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
        EntityManager em = emf.createEntityManager();
        
        CriteriaBuilder builder = em.getCriteriaBuilder();
        // createQuery() recebe o tipo do objeto de retorno da query
        //
        CriteriaQuery<BigDecimal> query = builder.createQuery(BigDecimal.class);
        Root<Movimentacao> root = query.from(Movimentacao.class);

        Expression<BigDecimal> expression = builder.sum(root.<BigDecimal>get("valor"));
        query.select(expression);

        TypedQuery<BigDecimal> typedQuery = em.createQuery(query);

        System.out.println("A soma das movimentacoes eh: " + typedQuery.getSingleResult());
    }
}