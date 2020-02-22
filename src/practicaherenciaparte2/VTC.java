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
public class VTC extends Vehiculo {

    private int maximoHoras;
    private int radioMaximo;
    private String ciudad;

    //constructor con parametros
    public VTC(int maximoHoras, int radioMaximo, String ciudad, int id, String matriula, String vehiculo, int potencia) {
        super(id, matriula, vehiculo, potencia);
        this.maximoHoras = maximoHoras;
        this.radioMaximo = radioMaximo;
        this.ciudad = ciudad;
    }

    //constructor vacio
    public VTC() {
    }

    //constructor copia
    public VTC(VTC aux) {
        this.setMatriula(aux.getMatriula());
        this.setModelo(aux.getModelo());
        this.setPotencia(aux.getPotencia());
        this.maximoHoras = maximoHoras;
        this.radioMaximo = radioMaximo;
        this.ciudad = ciudad;
    }
    //setters y getters

    public int getMaximoHoras() {
        return maximoHoras;
    }

    public void setMaximoHoras(int maximoHoras) {
        Scanner lector = new Scanner(System.in);
        boolean salir=false;
        
        while (salir==false) {//he añadido la condición de que las horas tienen que ser mayour que 0
            if (maximoHoras<=24 && maximoHoras>0) {
                this.maximoHoras=maximoHoras;
                salir=true;
            }else{
                System.out.println("El maximo de horas es 24 vuelve a introducir"
                        + "el valor");
                maximoHoras=lector.nextInt();
            }
        }
        this.maximoHoras = maximoHoras;
    }

    public int getRadioMaximo() {
        return radioMaximo;
    }

    public void setRadioMaximo(int radioMaximo) {
        boolean salir=false;
        Scanner lector = new Scanner(System.in);
        while (salir==false) {
            if (radioMaximo<=50) {
                this.radioMaximo=radioMaximo;
                salir=true;
            }else{
                System.out.println("El radio maximo no puede ser mas grande"
                        + "que 50 introducelo de nuevo");
                radioMaximo=lector.nextInt();
            }
        }
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    
    @Override
    public void solicitarDatos(){
        Scanner lector = new Scanner(System.in);
        
        super.solicitarDatos();
        System.out.println("Introduce la ciudad: ");
        this.setCiudad(lector.next());
        System.out.println("Introduce el maximo de horas");
        this.setMaximoHoras(lector.nextInt());
        System.out.println("Introduce el radio maximo: ");
        this.setRadioMaximo(lector.nextInt());
        
    }
    
    @Override
    public void mostrarAtributos(){
        super.mostrarAtributos();
        System.out.println(" Ciudad: "+this.getCiudad()+" Maximo horas: "+
                this.getMaximoHoras()+ " Radio Maximo: "+this.getRadioMaximo());
    }
}
