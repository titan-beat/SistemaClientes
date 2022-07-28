package servicio;

import modelo.CategoriaEnum;
import modelo.Cliente;
import utilidades.Utilidad;

import java.util.*;

public class ClienteServicio {

	ArrayList<Cliente> listaCliente = new ArrayList<Cliente>();
    Scanner scanner= new Scanner(System.in);
	public ClienteServicio() {
	
	}
	public ArrayList<Cliente> getListaCliente() {
		return listaCliente;
		}
	public Cliente editarCliente(Cliente clienteEditar) {
        System.out.println("----Actualizando datos del Cliente-----");
        System.out.println("1. El RUT del Cliente es: " + clienteEditar.getRutCliente());
        System.out.println("2. El Nombre del Cliente es: " + clienteEditar.getNombreCliente());
        System.out.println("3. El Apellido del Cliente es: " + clienteEditar.getApellidoCliente());
        System.out.println("4. Los a�os como Cliente son: " + clienteEditar.getAniosCliente());
        System.out.println("Ingrese opcion a editar de los datos del cliente: ");
        String opcion = scanner.nextLine();
        switch (opcion) {
        case "1":
            System.out.println("Ingrese el nuevo RUN del cliente:");
            clienteEditar.setRutCliente(scanner.nextLine());
            break;
        case "2":
            System.out.println("Ingrese el nuevo Nombre del cliente:");
            clienteEditar.setNombreCliente(scanner.nextLine());
            break;
        case "3":
            System.out.println("Ingrese el nuevo Apellido del cliente:");
            clienteEditar.setApellidoCliente(scanner.nextLine());
            break;
        case "4":
            System.out.println("Ingrese los A�os como cliente:");
            clienteEditar.setAniosCliente(scanner.nextLine());
            break;
        default:
            Utilidad.limpiarConsola();
            System.out.print("Opci�n no valida.");
        }
        Utilidad.limpiarConsola();
        System.out.print("Datos cambiados con exito");
        return clienteEditar;
    }
	
	public void listarCliente() {
        
		if(listaCliente.size()>0) {
		for (Cliente cliente : listaCliente) {
                    System.out.println("-------------Datos del Cliente-------------");
                    System.out.println("RUN del Cliente: " + cliente.getRutCliente());
                    System.out.println("Nombre del Cliente: "+ cliente.getNombreCliente());
                    System.out.println("Apellido del Cliente: "+ cliente.getApellidoCliente());
                    System.out.println("A�os como Cliente: "+ cliente.getAniosCliente() + " a�os");
                    System.out.println("Categor�a del Cliente: "+ cliente.getNombreCategoria());
                    System.out.println("-------------------------------------------");
                    
        }
		}else{
			System.out.println("no Hay Clientes en la lista");
		}
    }
    public void agregarCliente(String RutCliente, String nombreCliente, String apellidoCliente, String aniosCliente) {
        Cliente cliente = new Cliente(RutCliente, nombreCliente, apellidoCliente, aniosCliente, CategoriaEnum.ACTIVO);
        listaCliente.add(cliente);
    }
	public void editarEstadoCliente(Cliente c) {
		System.out.println("-----Actualizando estado del Cliente----");
        System.out.println("El estado actual es: " + c.getNombreCategoria().getEstado());
        System.out.println("1.- Si desea cambiar el estado del Cliente a Inactivo");
        System.out.println("2.- Si desea cambiar el estado del cliente a Activo");
        System.out.print("\nIngrese opci�n: ");
        String opcion = scanner.nextLine();
        switch (opcion) {
        case "1":
            c.setNombreCategoria(CategoriaEnum.INACTIVO);
            System.out.println("El estado del cliente se ha cambiado.");
            break;
        case "2":
            c.setNombreCategoria(CategoriaEnum.ACTIVO);
            System.out.println("El estado del cliente se ha cambiado.");
            break;
        default:
            System.out.print("Opci�n no valida.");
        }
		
	}
}
