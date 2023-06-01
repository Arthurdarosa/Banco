import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Conta {
	private int nr;
	private int agencia;
	private String cliente;
	protected double saldo;
	
	public boolean deposito (double v1) {
		if (v1 > 0) {
			saldo = getSaldo() + v1;
			return true;
		}
		return true;
	}
	
	public boolean saque (double v1) {
		if(getSaldo() >= v1) {
			saldo = getSaldo() - v1;
			return true;
		}
		return true;
	}
	
	public boolean transferencia (double v1, Conta destino) {
		if(saque(v1)) {
			if(destino.deposito(v1)) {
				return true;
			}else {
				deposito(v1);
				return false;
			}
		}
		return true;
	}
}
