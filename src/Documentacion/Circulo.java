package Documentacion;

import java.util.List;
import java.util.Random;

/**
 * Una clase que crea un objeto circulo, y que tambien puede calcular el radio de mayor area y
 * que tambien puede generar circulos de manera totalmente aleatoria
 * @author Jaime
 * @version 1.0.0
 */

public class Circulo {
    private double radio;
    private static int numeroCirculos = 0;
    public Circulo() {
        numeroCirculos++;
    }

    public Circulo(double radio) {
        this.radio = radio;
        numeroCirculos++;
    }

    public static int getNumeroCirculos() {
        return numeroCirculos;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    /**
     * Añadimos multiples datos para que luego los añada a un array y nos muestre el de mayor
     * area de entre todos.
     * @param circulos
     * @return Array de areas de Circulos.
     */

    public static Circulo getCirculoMayorArea(List<Circulo> circulos){
        double radioGrande = 0;
        Circulo circuloGrande = null;
        for (Circulo circulo : circulos) {
            if (circulo.getRadio() > radioGrande){
                radioGrande = circulo.getRadio();
                circuloGrande = circulo;
            }
        }
        return circuloGrande;
    }

    /**
     * Al añadirle un parametro, este mismo nos devolvera multiples circulos
     * @param circulos
     * @return Array de circulos aleatorios
     */

    public static Circulo[] getArrayAleatorioCirculos(List<Circulo> circulos){
        int numeroCirculos = circulos.size();
        switch (numeroCirculos) {
            case 0 -> {
                return new Circulo[]{};
            }
            case 1 -> {
                return new Circulo[]{circulos.get(0)};
            }
            case 2 -> {
                return new Circulo[]{circulos.get(0), circulos.get(1)};
            }
            case 3 -> {
                return new Circulo[]{circulos.get(0), circulos.get(1), circulos.get(2)};
            }
            default -> {
                Random random = new Random();
                Circulo[] circuloArray = new Circulo[3];
                for (int i = 0; i < 3; i++) {
                    int posicion = random.nextInt(numeroCirculos);
                    circuloArray[i] = circulos.get(posicion);
                    circulos.remove(posicion);
                    numeroCirculos--;
                }
                return circuloArray;
            }
        }

    }
    /**
     * Con todos los datos que hemos añadido, aqui nos mostrara el resultado total.
     * @return toString
     */

    @Override
    public String toString() {
        return "Documentacion.Circulo{" +
                "radio=" + radio +
                '}';
    }
}