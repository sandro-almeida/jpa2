package br.com.alura.jpa.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.dao.MovimentacaoDAO;
import br.com.alura.jpa.modelo.MediaComData;

public class TestaMediaDiariaDasMovimentacoes {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("alura");
        EntityManager em = emf.createEntityManager();
        
        //List<MediaComData> medias = new MovimentacaoDAO(em).getMediaDiariaDasMovimentacoes();
        List<MediaComData> medias = new MovimentacaoDAO(em).getMediaDiariaDasMovimentacoesComNamedQuery();

        for (MediaComData media : medias) {
            System.out.println("A media das movimentacoes do dia " + media.getDia() + "/" + media.getMes() + " eh: " + media.getValor());
        }

    }
}