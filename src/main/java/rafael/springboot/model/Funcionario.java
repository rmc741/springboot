package rafael.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "funcionario")
public class Funcionario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "funcionario_nome")
	private String funcionarioNome;
	
	@Column(name = "funcionario_cpf")
	private String funcionarioCpf;
	
	@Column(name = "funcionario_email")
	private String funcionarioEmail;
	
	@Column(name = "funcionario_saldo")
	private Double funcionarioSaldo;

	
	
	public Funcionario() {
		super();
	}

	public Funcionario(String funcionarioNome, String funcionarioCpf, String funcionarioEmail,
			Double funcionarioSaldo) {
		super();
		this.funcionarioNome = funcionarioNome;
		this.funcionarioCpf = funcionarioCpf;
		this.funcionarioEmail = funcionarioEmail;
		this.funcionarioSaldo = funcionarioSaldo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFuncionarioNome() {
		return funcionarioNome;
	}

	public void setFuncionarioNome(String funcionarioNome) {
		this.funcionarioNome = funcionarioNome;
	}

	public String getFuncionarioCpf() {
		return funcionarioCpf;
	}

	public void setFuncionarioCpf(String funcionarioCpf) {
		this.funcionarioCpf = funcionarioCpf;
	}

	public String getFuncionarioEmail() {
		return funcionarioEmail;
	}

	public void setFuncionarioEmail(String funcionarioEmail) {
		this.funcionarioEmail = funcionarioEmail;
	}

	public Double getFuncionarioSaldo() {
		return funcionarioSaldo;
	}

	public void setFuncionarioSaldo(Double funcionarioSaldo) {
		this.funcionarioSaldo = funcionarioSaldo;
	}

	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", funcionarioNome=" + funcionarioNome + ", funcionarioCpf=" + funcionarioCpf
				+ ", funcionarioEmail=" + funcionarioEmail + ", funcionarioSaldo=" + funcionarioSaldo + "]";
	}
	
	
	

}
