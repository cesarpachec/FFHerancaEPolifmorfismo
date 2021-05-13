package entities;

public class PessoaJuridica extends Pessoa{

	private int qtdeFuncionarios;
	
	public PessoaJuridica() {
		super();
	}

	public PessoaJuridica(String nome, double rendaAnual, int qtdeFuncionarios) {
		super(nome, rendaAnual);
		this.qtdeFuncionarios = qtdeFuncionarios;
	}

	public int getQtdeFuncionarios() {
		return qtdeFuncionarios;
	}

	public void setQtdeFuncionarios(int qtdeFuncionarios) {
		this.qtdeFuncionarios = qtdeFuncionarios;
	}

	@Override
	public double impostoPago() {
		if (qtdeFuncionarios < 10) {
			return getRendaAnual() * 0.16;
		} else {
			return getRendaAnual() * 0.14;
		}
	}

}
