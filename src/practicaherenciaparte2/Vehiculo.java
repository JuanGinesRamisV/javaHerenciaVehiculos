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
public class Vehiculo {

    private static int contadorId;
    private int id;
    private String matriula;
    private String modelo;
    private int potencia;

    //constructor con parametros
    public Vehiculo(int id, String matriula, String vehiculo, int potencia) {
        this.id = id;
        this.matriula = matriula;
        this.modelo = vehiculo;
        this.potencia = potencia;
    }

    //constructor vacio
    public Vehiculo() {
    }

    //constructor copia
    public Vehiculo(Vehiculo aux) {
        this.id = aux.id;
        this.matriula = aux.matriula;
        this.modelo = aux.modelo;
        this.potencia = aux.potencia;
    }

    //setters y getters
    public static int getContadorId() {
        return contadorId;
    }

    public static void setContadorId(int contadorId) {
        Vehiculo.contadorId = contadorId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMatriula() {
        return matriula;
    }

    public void setMatriula(String matriula) {
        this.matriula = matriula.toUpperCase();
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        String aux = modelo.substring(0, 1).toUpperCase()
                + modelo.substring(1).toLowerCase();
        this.modelo = aux;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        Scanner lector = new Scanner(System.in);
        boolean salir = false;
        while (salir == false) {
            if (potencia > 0) {
                this.potencia = potencia;
                salir=true;
            } else {
                System.out.println("La potencia no puede ser 0 o negativa introduce"
                        + "la potencia de nuevo");
                potencia=lector.nextInt();
            }
        }

    }

    public void solicitarDatos() {
        Scanner lector = new Scanner(System.in);
        contadorId++;

        System.out.println("Introduce el modelo del vehiculo:");
        this.setModelo(lector.next());
        System.out.println("Introduce la matricula del vehiculo:");
        this.setMatriula(lector.next());
        System.out.println("Introduce la potencia del vehiculo:");
        this.setPotencia(lector.nextInt());
        this.setId(getContadorId());
    }

    public void mostrarAtributos() {
        System.out.print("id: " + this.getId() + " modelo: " + this.getModelo()
                + " potencia: " + this.getPotencia() + " matricula: " + this.getMatriula());
    }

    public static int buscarPorId(ArrayList<Vehiculo> lista, int id) {
        boolean salir = false;
        int i = 0;
        int resultado = -1;
        //devuelve si se ha encontrado o no el objeto
        while (salir == false) {
            if (lista.get(i).getId() == id) {
                resultado = lista.get(i).getId() - 1;
                salir = true;
            } else if (i == lista.size() - 1 && salir == false) {
                resultado = -1;
                salir = true;
            } else {
                i++;
            }
        }
        return resultado;
    }

    public static int buscarPorMatricula(ArrayList<Vehiculo> lista, String matricula) {
        boolean salir = false;
        int i = 0;
        int resultado = -1;

        while (salir == false) {
            if (lista.get(i).getMatriula().equals(matricula)) {
                System.out.println("hola");
                resultado = lista.get(i).getId() - 1;
                salir = true;
            } else if (i == lista.size() - 1) {
                resultado = -1;
                salir = true;
            } else {
                i++;
            }
        }
        return resultado;
    }
}
