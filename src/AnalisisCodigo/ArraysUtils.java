package AnalisisCodigo;

import java.util.Arrays;

/**
 * <p>Es una clase que contiene métodos para tratar arrays de números enteros</p>
 * @author manuel
 * @version 1.0
 */
public class ArraysUtils {
    private ArraysUtils() {}
    /**
     * <p>Método que nos devuelve la suma de los elementos</p>
     * <p>de un array de números enteros</p>
     * @param array es la colección de tipo array sobre la que va a actuar el método
     * @return <p>un número entero con la suma de los números que contiene el array</p>
     *          <p>en el caso de un array vacío devuelve 0</p>
     *          <p>en el caso de que la referencia del array sea null devuelve null</p>
     */

    public static Integer sumItemsOfArray (int[] array) {
        if (array == null)
            return  null;
        int sum = 0;
        for (int item : array) {
            sum += item;
        }
        return sum;
    }

    /**
     *
     * @param array
     * @return
     */
    public static int[] getMinimumMaximumOfArray (int[] array) {
        if (array == null)
            return null;
        if (array.length == 0)
            return new int[]{};
        int[] values = new int[2];
        int min = array[0];
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min)
                min = array[i];
            else if (array[i] > max)
                max = array[i];
        }
        values[0] = min;
        values[1] = max;
        return values;
    }

    /**
     * <p>Método que devuelve un array de números enteros sin duplicados y ordenado</p>
     * <p>Ejemplo [1,2,5,5,4] devuelve el array [1,2,4,5]</p>
     * <p>En el caso que el array tenga un solo elemento, devuelve el mismo array</p>
     * <p>En el caso que el array está vacio, devuelve un array vacío</p>
     * <p>En el caso que reciba un null, devuelve un null</p>
     * @param array, es un array de números enteros
     * @return el array ordenado sin duplicados ó array vacío ó null
     */
    public static int[] getArrayWithoutDuplicates(int[] array) {
        if (array == null)
            return null;
        if (array.length == 0)
            return array;  //está vacío
        Arrays.sort(array); //arrayordenado
        int sizeArrayWD = array.length;
        for (int i = 1; i < array.length; i++) {
            if (array[i] == array[i - 1])
                sizeArrayWD--;
        }
        int[] arrayWD = new int[sizeArrayWD];
        arrayWD[0] = array[0];
        int duplicates = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] == array[i - 1])
                duplicates++;
            else{
                arrayWD[i - duplicates] = array[i];
            }
        }
        return arrayWD;
    }

    /**
     *
     * @param array
     * @param position
     * @return
     */
    public static int[] rotatePositionsInArrays (int[] array, int position){

        if (array == null || array.length == 0) return array;

        int sizeOfArray = array.length;

        // Normalizar posiciones
        position = position % sizeOfArray;
        if (position < 0) {
            position = sizeOfArray + position; // convertir rotación negativa en equivalente positiva
        }

        // Si no hay rotación, devolver el mismo array
        if (position == 0) return array;

        // Crear array resultado
        int[] newArray = new int[sizeOfArray];

        // Copiar la parte final al inicio
        System.arraycopy(array, sizeOfArray - position, newArray, 0, position);

        // Copiar la parte inicial al final
        System.arraycopy(array, 0, newArray, position, sizeOfArray - position);

        return newArray;
    }
}
