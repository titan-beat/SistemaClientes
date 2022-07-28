package servicio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import modelo.*;
import utilidades.Utilidad;

public class ArchivoServicio extends Exportador{

	@Override
	public void exportar(ArrayList<Cliente> clientes) {

	}

	public void cargarDatos(String fileName, ClienteServicio servicio) {
		File miArchivoTexto = new File(fileName + "/DBClientes.csv");
		if (miArchivoTexto.exists()) {
			try {
				FileReader fr = new FileReader(miArchivoTexto);
				BufferedReader br = new BufferedReader(fr);
				String miLinea = "";
				while ((miLinea = br.readLine()) != null) {
					String[] atributosCliente = miLinea.split(",");
					Cliente miNuevoCliente = new Cliente(atributosCliente[0], atributosCliente[1], atributosCliente[2],
							atributosCliente[3], CategoriaEnum.valueOf(atributosCliente[4].toUpperCase()));
					servicio.getListaCliente().add(miNuevoCliente);
				}
				Utilidad.limpiarConsola();
				System.out.print("Datos cargados correctamente en la lista");
				br.close();

			} catch (Exception e) {
				Utilidad.limpiarConsola();
				System.out.print("Error al leer archivo");

			}
		} else {
			Utilidad.limpiarConsola();
			System.out.print("No se encuentra el archivo");
		}

	}

}
