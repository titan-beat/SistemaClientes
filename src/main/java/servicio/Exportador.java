package servicio;

import java.util.ArrayList;

import modelo.Cliente;

public abstract class Exportador {
	public abstract void exportar(ArrayList<Cliente> clientes);
}

