package br.com.alura.jpa.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Conta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titular;
	private Integer agencia;
	private Integer numero;
	private Double saldo;

	// mappedBy evita que seja criada uma tabela de relacionamento entre conta e movimentacao, 
	// e cria um relacionamento bi-direcional.
	// O valor default do atributo fetch para relacionamentos @..ToMany é LazyLoading
	//
	@OneToMany (mappedBy = "conta", fetch = FetchType.EAGER) 
	private List<Movimentacao> movimentacoes;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public Integer getAgencia() {
		return agencia;
	}

	public void setAgencia(Integer agencia) {
		this.agencia = agencia;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public List<Movimentacao> getMovimentacoes() {
		return movimentacoes;
	}

	@Override
	public String toString() {
		return "Conta: [id=" + this.id +
			"; titular=" + this.titular +
			"; agencia=" + this.agencia +
			"; numero=" + this.numero +
			"; saldo=" + this.saldo +
			"]";
	}

}
