/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaherenciaparte2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author juang
 */
public class PracticaHerenciaParte2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Vehiculo> Vehiculos = new ArrayList<Vehiculo>();
        Scanner lector = new Scanner(System.in);
        int opcionMenu;
        boolean menuPrincipal = false;

        while (menuPrincipal == false) {
            int opcion;
            boolean salir = false;
            boolean encontrado = false;
            int busquedaId;
            System.out.println("1- Alta taxis");
            System.out.println("2- Alta VCT");
            System.out.println("3- Alta Autobuses");
            System.out.println("4- Buscar vehiculos por id");
            System.out.println("5- Buscar vehiculo por matricula");
            System.out.println("6- buscar primer taxi libre");
            System.out.println("7- buscar taxi concreto por id");
            System.out.println("8. mostrar todos los vehiculos");
            opcion = lector.nextInt();
            
            switch (opcion) {
                case 1:
                    darTaxiAlta(Vehiculos);
                    break;
                case 2:
                    darVTCAlta(Vehiculos);
                    break;
                case 3:
                    darAutobusAlta(Vehiculos);
                    break;
                case 4:
                    System.out.println("Introduce la id del vehiculo");
                    buscarVehiculoId(Vehiculos);
                    break;
                case 5:
                    bucarVehiculoMatricula(Vehiculos);
                    break;
                case 6:
                    buscarPrimerTaxi(Vehiculos);
                    break;
                case 7:
                    buscarTaxiPorId(Vehiculos);
                    break;
                case 8:
                    mostrarVehiculos(Vehiculos);
                    break;
            }
        }

    }

    public static void darTaxiAlta(ArrayList<Vehiculo> lista) {
        Taxi aux = new Taxi();
        aux.solicitarDatos();
        lista.add(aux);
    }

    public static void darVTCAlta(ArrayList<Vehiculo> lista) {
        VTC aux = new VTC();
        aux.solicitarDatos();
        lista.add(aux);
    }

    public static void darAutobusAlta(ArrayList<Vehiculo> lista) {
        Autobus aux = new Autobus();
        aux.solicitarDatos();
        lista.add(aux);
    }

    public static void buscarVehiculoId(ArrayList<Vehiculo> vehiculos) {
        Scanner lector = new Scanner(System.in);

        int id = lector.nextInt();
        int aux = Vehiculo.buscarPorId(vehiculos, id);
        if (aux != -1) {
            System.out.print(vehiculos.get(aux).getClass().getSimpleName() + " ");
            vehiculos.get(aux).mostrarAtributos();
        } else {
            System.out.println("El vehiculo no se encuentra en el sistema");
        }
    }

    public static void bucarVehiculoMatricula(ArrayList<Vehiculo> vehiculos) {
        Scanner lector = new Scanner(System.in);

        System.out.println("Introduce la matricula del vehiculo");
        String matricula = lector.nextLine();
        int aux = Vehiculo.buscarPorMatricula(vehiculos, matricula);
        //imprimir el resultado
        if (aux != -1) {
            System.out.print(vehiculos.get(aux).getClass().getSimpleName());
            vehiculos.get(aux).mostrarAtributos();
        } else {
            System.out.println("El vehiculo no se encuentra en el sistema");
        }
    }

    public static void buscarPrimerTaxi(ArrayList<Vehiculo> lista) {
        boolean salir = false;
        int i = 0;

        while (salir == false) {
            if (lista.get(i) instanceof Taxi && ((Taxi) lista.get(i)).comprobarDisponibilidad() == true) {
                System.out.println("El primer taxi disponible es el siguiente");
                lista.get(i).mostrarAtributos();
                ((Taxi)lista.get(i)).setEstado(false);
                salir = true;
            } else if (i == lista.size() - 1) {
                System.out.println("No hay ningun taxi disponiblre");
                salir = true;
            } else {
                i++;
            }
        }
    }

    public static void buscarTaxiPorId(ArrayList<Vehiculo> lista) {
        boolean salir = false;
        int i = 0;
        int id;
        Scanner lector = new Scanner(System.in);
        
        System.out.println("Introduce la id del taxi");
        id = lector.nextInt();
        while (salir == false) {
            if (lista.get(i) instanceof Taxi && lista.get(i).getId()==id) {
                System.out.print(lista.get(i).getClass().getSimpleName()+" ");
                ((Taxi)lista.get(i)).mostrarAtributos();
                ((Taxi)lista.get(i)).setEstado(true);
                salir=true;
            }else if (i== lista.size()-1) {
                System.out.println("no se ha encontrado el taxi con ese id");
                salir=true;
            }else{
                i++;
            }
        }
    }
    
    public static void mostrarVehiculos(ArrayList<Vehiculo> lista){
        int i;
        for(i=0;i<=lista.size()-1;i++){
            System.out.print(lista.get(i).getClass().getSimpleName()+" ");
            lista.get(i).mostrarAtributos();
        }
    }
}
