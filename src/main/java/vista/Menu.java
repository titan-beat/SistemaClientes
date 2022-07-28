package vista;

import java.util.Scanner;

import modelo.Cliente;
import servicio.ArchivoServicio;
import servicio.ClienteServicio;
import servicio.ExportarCSV;
import servicio.ExportarTxt;
import utilidades.Utilidad;

public class Menu {

	Scanner sc = new Scanner(System.in);
	ClienteServicio clienteServicio = new ClienteServicio();
	ArchivoServicio archivoServicio = new ArchivoServicio();
	ExportarCSV exportadorCsv = new ExportarCSV();
	ExportarTxt exportadorTxt = new ExportarTxt();

	String fileName = "Cliente";
	String dbFileName = "DBClientes.csv";

//	ExportarTxT exportar = new ExportarTxT();

	boolean datosCompletos = false;

	public void inicio() {

		String op;
		do {
			desplegarMenu();
			op = sc.nextLine();
			switch (op) {
			case "1":
				clienteServicio.listarCliente();
				Utilidad.limpiarConsola();
				Utilidad.esperar();
				break;
			case "2":
				agregarCliente();
				Utilidad.limpiarConsola();
				Utilidad.esperar();
				break;
			case "3":
				editarCliente();
				Utilidad.limpiarConsola();
				Utilidad.esperar();
				break;
			case "4":
				archivoServicio.cargarDatos("src", clienteServicio);
				Utilidad.limpiarConsola();
				Utilidad.esperar();
				break;
			case "5":
				exportarDatos();
				break;
			case "6":
				System.out.println("Abandonando el sistema de productos...");
				System.out.println("Acaba de salir del sistema");
				System.exit(0);
				break;
			default:
				System.out.println("opci�n invalida, vuelva a ingresar");
				break;
			}
		} while (!op.equals("6"));
	}

	public void desplegarMenu() {
		System.out.println("------MENU------" + "\n1 Listar Cliente\n" + "2 Agregar Cliente\n" + "3 Editar Cliente\n"
				+ "4 Cargar Datos\n" + "5 Exportar Datos\n" + "6 Salir\n" + "Ingrese una opcion:");
	}

	public void listarCliente() {
	}

	public void agregarCliente() {

		System.out.println("-------------Crear Cliente-------------");
		System.out.println("Ingresa RUN del Cliente: ");
		String rut = sc.next();
		System.out.println("Ingresa Nombre del Cliente: ");
		String nombre = sc.next();
		System.out.println("Ingresa Apellido del Cliente: ");
		String apellido = sc.next();
		System.out.println("Ingresa a�os como Cliente: ");
		String anios = sc.next();
		System.out.println("---------------------------------------");
		clienteServicio.agregarCliente(rut, nombre, apellido, anios);
		sc.nextLine();
	}

	public void editarCliente() {
		System.out.println("-------------Editar Cliente-------------");
		System.out.println("Seleccione qu� desea hacer:");
		System.out.println("1.-Cambiar el estado del Cliente");
		System.out.println("2.-Editar los datos ingresados del Cliente");
		System.out.println("Ingrese opcion:");		
		String opcion = sc.nextLine();
		System.out.println("----------------------------------------");
		System.out.println("Ingrese RUN del Cliente a editar:");
		System.out.println("----------------------------------------");
		String run = sc.nextLine();
		for (Cliente c : clienteServicio.getListaCliente()) {
			if (c.getRutCliente().equalsIgnoreCase(run)) {

				switch (opcion) {
				case "1":
					Utilidad.limpiarConsola();
					clienteServicio.editarEstadoCliente(c);
					break;
				case "2":
					Utilidad.limpiarConsola();
					clienteServicio.editarCliente(c);
					break;
				default:
					Utilidad.limpiarConsola();
					System.out.print("Opción no valida.");
				}
			}
		}

	}

	public void importarDatos() {
	}

	public void exportarDatos() {
		System.out.println("Seleccione el formato a exportar: " + "\n1.-Formato csv" + "\n2.-Formato txt"
				+ "\nIngrese una opci�n para exportar: ");
		String opcion = sc.nextLine();

		switch (opcion) {
		case "1":
			exportadorCsv.exportar(clienteServicio.getListaCliente());
			System.out.println("Archivo Csv Exportado");
			break;
		case "2":
			exportadorTxt.exportar(clienteServicio.getListaCliente());
			System.out.println("Archivo Txt Exportado");
			break;
		default:
			Utilidad.limpiarConsola();
			System.out.print("Opci�n no valida.");

		}
	}

	public void terminarPrograma() {
	}
}
