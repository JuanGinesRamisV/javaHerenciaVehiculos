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
public class Taxi extends Vehiculo {
    private static int licencias=1000;
    private int numeroLicencia;
    private boolean estado;
    private int numeroTaxistas;

    //constructor con parametros
    public Taxi(int numeroLicencia, boolean estado, int numeroTaxistas, int id, String matriula, String vehiculo, int potencia) {
        super(id, matriula, vehiculo, potencia);
        this.numeroLicencia = numeroLicencia;
        this.estado = estado;
        this.numeroTaxistas = numeroTaxistas;
    }

    //constructor vacio
    public Taxi() {
    }

    public static int getLicencias() {
        return licencias;
    }

    public static void setLicencias(int licencias) {
        Taxi.licencias = licencias;
    }

    //constructor copia
    public Taxi(Taxi aux) {
        this.setId(aux.getId());
        this.setMatriula(aux.getMatriula());
        this.setModelo(aux.getModelo());
        this.setPotencia(aux.getPotencia());
        this.numeroLicencia = numeroLicencia;
        this.estado = estado;
        this.numeroTaxistas = numeroTaxistas;
    }
    
    //getters y setters

    public int getNumeroLicencia() {
        return numeroLicencia;
    }

    public void setNumeroLicencia(int numeroLicencia) {
        this.numeroLicencia = numeroLicencia;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public int getNumeroTaxistas() {
        return numeroTaxistas;
    }

    public void setNumeroTaxistas(int numeroTaxistas) {
        this.numeroTaxistas = numeroTaxistas;
    }
    
    //solicitar datos del taxi
    @Override
    public void solicitarDatos(){
        Scanner lector = new Scanner(System.in);
        super.solicitarDatos(); //llamo al metodo solicitar datos de la clase padre
        this.setEstado(true);
        this.setNumeroLicencia(licencias);
        licencias++;
        System.out.println("Introduce el numero de taxistas que conducen este"
                + "taxi");
        this.setNumeroTaxistas(lector.nextInt());
        
    }
    
    @Override
    public void mostrarAtributos(){
        super.mostrarAtributos();
        System.out.print(" Numero taxistas: "+this.getNumeroTaxistas()+
                "Numero licencia: "+this.getNumeroLicencia());
        if(this.isEstado()==true){
            System.out.println("Estado: disponible");
        }else{
            System.out.println("Estado: no disponible");
        }
    }
    
    public boolean comprobarDisponibilidad(){
        boolean disponibilidad;
        
        if(this.isEstado()==true){
            disponibilidad=true;
        }else{
            disponibilidad=false;
        }
        return disponibilidad;
    }
}
