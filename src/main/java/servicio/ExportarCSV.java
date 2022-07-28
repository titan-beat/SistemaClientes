package servicio;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import modelo.Cliente;

public class ExportarCSV extends Exportador {

	@Override
	public void exportar(ArrayList<Cliente> clientes) {
		// logica de exportacion
		Scanner sc = new Scanner(System.in);
		System.out.println("Exportar Datos");
		System.out.println("Ingresa la ruta en donde desea exportar el archivo productos.cvs:");
		String ruta = sc.nextLine();

		File archivo = new File(ruta + "/productos.Csv");
 
		if (!archivo.exists()) {
			try {
				if (archivo.createNewFile()) {
					System.out.println("archivo creado");
					// ya creado el archivo, debemos escribir en el
					FileWriter fw = new FileWriter(archivo);
					BufferedWriter bw = new BufferedWriter(fw);

					for (Cliente c : clientes) {
						bw.write(c.getRutCliente());
						bw.write(",");
						bw.write(c.getNombreCliente());
						bw.write(",");
						bw.write(c.getApellidoCliente());
						bw.write(",");
						bw.write(c.getAniosCliente());
						bw.write(",");
						bw.write(c.getNombreCategoria().getEstado());
						bw.newLine();

					}
					bw.close();

				} else {
					System.out.println("no se pudo crear el archivo");
				}
			} catch (IOException e) {
				System.out.println("Error al crear el archivo");
				e.printStackTrace();
			}
		} else {
			System.out.println("El archivo ya existia.");
		}
	}

}
