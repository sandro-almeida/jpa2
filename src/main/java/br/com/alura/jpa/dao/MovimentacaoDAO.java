package br.com.alura.jpa.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.alura.jpa.modelo.MediaComData;
import br.com.alura.jpa.modelo.Movimentacao;

public class MovimentacaoDAO {

    private EntityManager em;

    public MovimentacaoDAO(EntityManager em) {
        this.em = em;
    }

    public List<MediaComData> getMediaDiariaDasMovimentacoes() {

        // Calcula a media diaria: NECESSARIO usar o new para instanciar um novo objeto
        //
        String jpql = 
            "select new br.com.alura.jpa.modelo.MediaComData(avg(m.valor), month(m.data), day(m.data)) " +
            "from Movimentacao m group by year(m.data), month(m.data), day(m.data)";

        TypedQuery<MediaComData> query = em.createQuery(jpql, MediaComData.class);
        return query.getResultList();
    }


    public List<MediaComData> getMediaDiariaDasMovimentacoesComNamedQuery() {

        TypedQuery<MediaComData> query = em.createNamedQuery("mediaDiariaDasMovimentacoes", MediaComData.class);
        return query.getResultList();
    }


    public BigDecimal somaDasMovimentacoes() {

        // Calcula a soma
        //
        String jpql = "select sum(m.valor) from Movimentacao m";

        TypedQuery<BigDecimal> query = em.createQuery(jpql, BigDecimal.class);
        return query.getSingleResult();
    }


    public List<Movimentacao> getMovimentacoesFiltradasPorData(Integer dia, Integer mes, Integer ano) {

        CriteriaBuilder builder = em.getCriteriaBuilder();
        // createQuery() recebe o tipo de retorno da query
        //
        CriteriaQuery<Movimentacao> query = builder.createQuery(Movimentacao.class);
        Root<Movimentacao> root = query.from(Movimentacao.class);

        List<Predicate> predicates = new ArrayList<Predicate>();

        if (dia != null) {
            // day(m.data)
            //
            Predicate predicate = builder.equal(builder.function("day", Integer.class, root.get("data")), dia);
            predicates.add(predicate);
        }

        if (mes != null) {
            // month(m.data)
            //
            Predicate predicate = builder.equal(builder.function("month", Integer.class, root.get("data")), mes);
            predicates.add(predicate);
        }

        if (ano != null) {
            // year(m.data)
            //
            Predicate predicate = builder.equal(builder.function("year", Integer.class, root.get("data")), ano);
            predicates.add(predicate);
        }

        // 'new Predicate[0]' vai criar um array do exato tamanho da nossa lista,
        // evitando alocar memoria desnecessariamente.
        //
        query.where((Predicate[]) predicates.toArray(new Predicate[0]));

        TypedQuery<Movimentacao> typedQuery = em.createQuery(query);

        return typedQuery.getResultList();

    }

}