package datatypes;

public class DtHora {
	private int hora;
	private int minutos;

	public DtHora(int hora, int minutos) {
		this.hora = hora;
		this.minutos = minutos;
	}
	public int getHora() {
		return hora;
	}
	public int getMinutos() {
		return minutos;
	}
}