package br.com.alura.jpa.modelo;

public class MediaComData {

    private Double valor;
    private Integer mes;
    private Integer dia;

    public MediaComData(Double valor, Integer mes, Integer dia) {
      this.valor = valor;
      this.dia = dia;
      this.mes = mes;
    }

    public Double getValor() {
      return valor;
    }
      
    public Integer getMes() {
      return mes;
    }

    public Integer getDia() {
      return dia;
    }
      

}
