/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaherenciaparte2;

import java.util.Scanner;

/**
 *
 * @author juang
 */
public class Autobus extends Vehiculo {

    private int numeroPlazas;
    private int NumeroParadas;

    //constructor con parametros
    public Autobus(int numeroPlazas, int NumeroParadas, int id, String matriula, String modelo, int potencia) {
        super(id, matriula, modelo, potencia);
        this.numeroPlazas = numeroPlazas;
        this.NumeroParadas = NumeroParadas;
    }

    //constructor vacio
    public Autobus() {
    }

    //constructor copia
    public Autobus(Autobus aux) {
        this.setId(aux.getId());
        this.setMatriula(aux.getMatriula());
        this.setModelo(aux.getModelo());
        this.setPotencia(aux.getPotencia());
        this.numeroPlazas = numeroPlazas;
        this.NumeroParadas = NumeroParadas;
    }
    //getters y setters

    public int getNumeroPlazas() {
        return numeroPlazas;
    }

    public void setNumeroPlazas(int numeroPlazas) {
        this.numeroPlazas = numeroPlazas;
    }

    public int getNumeroParadas() {
        return NumeroParadas;
    }

    public void setNumeroParadas(int NumeroParadas) {
        boolean salir = false;
        Scanner lector = new Scanner(System.in);

        while (salir == false) {
            if (NumeroParadas > 3 && NumeroParadas<=20) {
                this.NumeroParadas = NumeroParadas;
                salir=true;
            } else {
                System.out.println("El numero de paradas no puede ser menor de 3"
                        + "ni mayor que 20 introduce de nuevo el numero de paradas");
                NumeroParadas = lector.nextInt();
            }
        }

    }

    @Override
    public void solicitarDatos() {
        Scanner lector = new Scanner(System.in);

        super.solicitarDatos();
        System.out.println("Introduce el numero de paradas: ");
        this.setNumeroParadas(lector.nextInt());
        System.out.println("Introduce el numero de plazas: ");
        this.setId(lector.nextInt());
    }

    @Override
    public void mostrarAtributos() {
        super.mostrarAtributos();
        System.out.println("Numero de plazas: " + this.getNumeroPlazas() + "Numero"
                + "de paradas: " + this.getNumeroParadas());
    }
}
