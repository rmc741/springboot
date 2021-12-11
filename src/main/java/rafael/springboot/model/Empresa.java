package rafael.springboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "empresa")
public class Empresa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "empresa_nome")
	private String empresaNome;
	
	@Column(name = "empresa_cnpj")
	private String empresaCnpj;
	
	@Column(name = "empresa_email")
	private String empresaEmail;
	
	@Column(name = "empresa_saldo")
	private Double empresaSaldo;
	
	
	
	public Empresa() {
		super();
	}
	public Empresa(String empresaNome, String empresaCnpj, String empresaEmail , Double empresaSaldo) {
		super();
		this.empresaNome = empresaNome;
		this.empresaCnpj = empresaCnpj;
		this.empresaEmail = empresaEmail;
		this.empresaSaldo = empresaSaldo;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmpresaNome() {
		return empresaNome;
	}
	public void setEmpresaNome(String empresaNome) {
		this.empresaNome = empresaNome;
	}
	public String getEmpresaCnpj() {
		return empresaCnpj;
	}
	public void setEmpresaCnpj(String empresaCnpj) {
		this.empresaCnpj = empresaCnpj;
	}
	public String getEmpresaEmail() {
		return empresaEmail;
	}
	public void setEmpresaEmail(String empresaEmail) {
		this.empresaEmail = empresaEmail;
	}
	public Double getEmpresaSaldo() {
		return empresaSaldo;
	}
	public void setEmpresaSaldo(Double empresaSaldo) {
		this.empresaSaldo = empresaSaldo;
	}
	@Override
	public String toString() {
		return "Empresa [id=" + id + ", empresaNome=" + empresaNome + ", empresaCnpj=" + empresaCnpj + ", empresaEmail="
				+ empresaEmail + ", empresaSaldo=" + empresaSaldo + "]";
	}
	
	
	

}
