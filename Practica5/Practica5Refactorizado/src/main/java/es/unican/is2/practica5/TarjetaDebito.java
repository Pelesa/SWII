package es.unican.is2.practica5;

import java.time.LocalDate;

public class TarjetaDebito extends Tarjeta {
	
	private double saldoDiarioDisponible;

	public TarjetaDebito(String numero, String titular, CuentaAhorro cuenta) { //WMC +1
		super(numero, titular, cuenta);
	}
	
	
	@Override
	public void retirar(double cantidad) throws saldoInsuficienteException, datoErroneoException { //WMC +1
		if (saldoDiarioDisponible<cantidad) { //WMC +1 CCog +1
			throw new saldoInsuficienteException("Saldo insuficiente");
		}
		this.mCuentaAsociada.retirar("Retirada en cajero autom�tico", cantidad);
		saldoDiarioDisponible-=cantidad;
	}
	
	@Override
	public void pagoEnEstablecimiento(String datos, double cantidad) throws saldoInsuficienteException, datoErroneoException { //WMC +1
		if (saldoDiarioDisponible<cantidad) { //WMC +1 CCog +1
			throw new saldoInsuficienteException("Saldo insuficiente");
		}
		this.mCuentaAsociada.retirar("Compra en : " + datos, cantidad);
		saldoDiarioDisponible-=cantidad;
	}
	
	public LocalDate getCaducidadDebito() { //WMC +1
		return this.mCuentaAsociada.getCaducidadDebito();
	}
	
	/**
	 * M�todo invocado autom�ticamente a las 00:00 de cada d�a
	 */
	public void restableceSaldo() { //WMC +1
		saldoDiarioDisponible = mCuentaAsociada.getLimiteDebito();
	}
	
	public CuentaAhorro getCuentaAsociada() { //WMC +1
		return mCuentaAsociada;
	}

}