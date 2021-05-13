package entities;

public class PessoaFisica extends Pessoa {

	private double gastosSaude;

	public PessoaFisica() {
		super();
	}

	public PessoaFisica(String nome, double rendaAnual, double gastosSaude) {
		super(nome, rendaAnual);
		this.gastosSaude = gastosSaude;
	}

	public double getGastosSaude() {
		return gastosSaude;
	}

	public void setGastosSaude(double gastosSaude) {
		this.gastosSaude = gastosSaude;
	}

	@Override
	public double impostoPago() {

		double impostoPago = 0;
		if (getRendaAnual() < 20000.0) {
			impostoPago = getRendaAnual() * 0.15;
			if (gastosSaude > 0.0) {
				impostoPago -= gastosSaude * 0.5;
			}
		} else {
			impostoPago = getRendaAnual() * 0.25;
			if (gastosSaude > 0.0) {
				impostoPago -= gastosSaude * 0.5;
			}
		}

		return impostoPago;
	}

}
