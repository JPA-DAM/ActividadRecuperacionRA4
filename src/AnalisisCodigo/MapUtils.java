package AnalisisCodigo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * <p>Clase con distintos métodos estáticos para trabajar con Maps</p>
 * @author manuel
 * @version 1.0.0
 */
public class MapUtils {
    private MapUtils() {
    }

    /**
     * Método que dado una ruta de un fichero, guarda cada palabra en una lista
     * @param path ruta del fichero a analizar
     * @return una lista de tipo String, que contiene cada una de las palabras del fichero.
     * @throws FileNotFoundException excepeción que se lanza si la ruta no contiene un fichero válido
     */
    public static List<String> listWords (String path) throws FileNotFoundException {
        List<String> setWords = new ArrayList<>();
        Scanner scanner = new Scanner(new File(path));
        String linea = "";
        int countLine = 0;
        int countWords = 0;
        while (scanner.hasNextLine()) {
            linea = scanner.nextLine().toLowerCase().replaceAll("[.,;]", "");
            countLine++;
            String[] tokens = linea.split(" ");
            countWords += tokens.length;
            for (String word : tokens)
                setWords.add(word);
        }
        return setWords;
    }
    public static Map<String, Integer> createMaps(String path) throws FileNotFoundException {
        Map<String, Integer> mapWords = new TreeMap<>();
        return mapWords;
    }
    //solicitamos el  numero de datos
    //recepcionamos los datos
    //relleanamos el map
    //devolvemos el map
    public static Map<String, String > createPhoneList() {
        Map<String, String> mapPhoneList = new TreeMap<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el número de contactos");
        int numberOfContacts = scanner.nextInt();
        scanner.nextLine(); //limpiamos el scanner
        for (int i = 0; i < numberOfContacts; i++) {
            System.out.println("Introduce teléfono:");
            String phoneNumber = scanner.next();
            scanner.nextLine();//limpiamos el sacanner
            System.out.println("Introduce nombre completo");
            String name =  scanner.nextLine();
            mapPhoneList.put(phoneNumber, name);
        }
        return mapPhoneList;
    }
    //métodos CRUD C: CREATE, R: BUSCAR, U:MODIFICAT, D: ELIMINAR
    public static String removeContactByNumberPhone(String numberPhone, Map<String, String> phoneList) {
        return phoneList.remove(numberPhone);
    }
    public static boolean findContactByNumberPhone (String numberPhone, Map<String, String> phoneList) {
        return phoneList.containsKey(numberPhone);
    }
    public static String updateContact( String numberPhone, String newName, Map<String, String> phoneList) {
        return phoneList.replace(numberPhone, newName);
    }
    public static String addNewContact (String numberPhone, String name, Map<String, String> phoneList) {
        return phoneList.put(numberPhone, name);

    }

    /*public static void main(String[] args) throws FileNotFoundException {
     *//*Map<String, Integer> mapWords = createMaps("ficheros/texto.txt");
        System.out.println(mapWords);*//*
        Map<String, String> mapPhoneList = createPhoneList();
        System.out.println(mapPhoneList);
        boolean existContact = findContactByNumberPhone("12345678", mapPhoneList);
        System.out.printf("¿Existe el nº 12345678, %B%n", existContact);
        existContact = findContactByNumberPhone("1", mapPhoneList);
        System.out.printf("¿Existe el nº 1, %B%n", existContact);
        String oldName = updateContact("12345678", "isabel gonzález", mapPhoneList);
        System.out.println(mapPhoneList);
        String newContact = addNewContact("000000", "emergencias", mapPhoneList);
        System.out.printf("Añadido el contacto de %S%n", newContact);
        System.out.println(mapPhoneList);
        String oldContact = removeContactByNumberPhone("000000", mapPhoneList);
        System.out.printf("Elimiando el contacto de %S%n", oldContact);
        System.out.println(mapPhoneList);


    }*/



}
