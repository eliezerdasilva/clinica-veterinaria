package modelo;

public class Endereco {
	
	private String cep;
	private String rua;
	private String numCasa;
	
	public Endereco() {
		super();
		this.cep = cep;
		this.rua = rua;
		this.numCasa = numCasa;
		
		
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumCasa() {
		return numCasa;
	}

	public void setNumCasa(String numCasa) {
		this.numCasa = numCasa;
	}
	
	
	
	

}
