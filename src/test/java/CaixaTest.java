
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CaixaTest {
	
	private Caixa caixa = new Caixa();
	
	@BeforeEach
	public void init() {
		caixa.getContar().clear();
		caixa.addConta(new Conta(1, 1, "Cor 1", 10));
		caixa.addConta(new ContaEspecial(2, 2, "Cor 2", 10, 500));
		caixa.addConta(new ContaUniversitaria(3, 3, "Cor 3", 10));
	}
	
	@Test
	public void transf1() {
		Conta cor = caixa.getContar().get(0);
		ContaUniversitaria uni = (ContaUniversitaria)caixa.getContar().get(2);
		caixa.transferencia(10, cor, uni);
		assertEquals(0, cor.getSaldo());
		assertEquals(20, uni.getSaldo());
	}
	@Test
	public void transf2() {
		Conta cor = caixa.getContar().get(0);
		ContaUniversitaria uni = (ContaUniversitaria)caixa.getContar().get(2);
		caixa.deposito(1990, uni);
		assertEquals(2000, uni.getSaldo());
		caixa.transferencia(10, cor, uni);
		assertEquals(10, cor.getSaldo());
		assertEquals(2000, uni.getSaldo());
	}

}
