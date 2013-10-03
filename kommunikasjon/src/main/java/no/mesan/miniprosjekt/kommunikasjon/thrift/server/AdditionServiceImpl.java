package no.mesan.miniprosjekt.kommunikasjon.thrift.server;

import java.util.ArrayList;
import java.util.List;

import org.apache.thrift.TException;


public class AdditionServiceImpl implements AdditionService.Iface  {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public Kaja hent() throws TException {
		Kaja kaja;
		List<Integer> listen = new ArrayList<Integer>();
		listen.add(1);
		listen.add(2);
		listen.add(3);
		kaja = new Kaja(listen);
		return kaja;
	}

}
