package modelo;

public class Animal {

	private Long id;
	private String tipo;
	private String nome;
	private String raca;

	public Animal(String tipo, String nome, String raca) {
		this.tipo = tipo;
		this.nome = nome;
		this.raca = raca;
	}

	public Animal() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRaca() {
		return raca;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getraca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	@Override
	public String toString() {
		return " Animal ; " + " Tipo : " + tipo + "---- " + "Nome: " + nome + "  Raça : " + raca;
	}

}
