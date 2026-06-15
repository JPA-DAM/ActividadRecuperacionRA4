package AnalisisCodigo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SetUtils {
    public static void main(String[] args) throws FileNotFoundException {
        /*String texto = "Esto es un ejemplo de como extraer palabras del texto texto Texto";
        String[] tokens = texto.split(" ");
        System.out.println(Arrays.toString(tokens));
        Set<String> setWords = new HashSet<>();
        for (String word : tokens)
            setWords.add(word);
        System.out.println(setWords);
        System.out.println("=========DESDE FICHEROS===========");
        Set<String> setWordsFromFile = setWords("ficheros/texto.txt");
        System.out.println(setWordsFromFile);
        List<Integer> list = List.of(1, 2, 1, 2, 3, 3, 4, 4, 4, 5, 5);
        System.out.println(getListWithoutDuplicates(list));
        Set<Integer> setA = Set.of(1, 2, 3, 4);
        Set<Integer> setB = Set.of(2, 3, 5, 6);
        System.out.println(getIntesectionOfSets(setA, setB));
        System.out.println(getDijuntionOfSets(setA, setB));
        System.out.println(getDijuntionOfSets(setB, setA));*/
        showSet();

    }
    public static Set<String> setWords (String path) throws FileNotFoundException {
        Set<String> setUniqueWords = new HashSet<>();
        Scanner scanner = new Scanner(new File(path));
        /*String linea = scanner.nextLine();
        System.out.println(linea);
        linea = scanner.nextLine();
        System.out.println(linea);*/
        String linea = "";
        int countLine = 0;
        int countWords = 0;
        while (scanner.hasNextLine()) {
            linea = scanner.nextLine().toLowerCase().replaceAll("[.,;]", "");
            //System.out.println(linea);
            countLine++;
            String[] tokens = linea.split(" ");
            countWords += tokens.length;
            for (String word : tokens)
                setUniqueWords.add(word);
            System.out.println(Arrays.toString(tokens));
        }
        System.out.printf("Nº de líneas leídas: %d%n", countLine);
        System.out.printf("Nº de palabras leídas: %d%n", countWords);
        System.out.printf("Nº de palabras no repetidas: %d%n", setUniqueWords.size());
        return setUniqueWords;
    }
    public static List<Integer> getListWithoutDuplicates (List<Integer> list) {
        Set<Integer> set = new HashSet<>();
        for (int number : list ) {
            set.add(number);
        }
        return new ArrayList<>(set);
    }
    public static Set<Integer> getIntesectionOfSets (Set<Integer> setA, Set<Integer> setB) {
        Set<Integer> resultSet = new HashSet<>();
        for (int number : setA) {
            if (setB.contains(number)){
                resultSet.add(number);
            }
        }
        return resultSet;
    }
    public static Set<Integer> getDijuntionOfSets (Set<Integer> set1, Set<Integer> set2) {
        Set<Integer> resultSet = new HashSet<>();
        for (int number : set1) {
            if (!set2.contains(number)){
                resultSet.add(number);
            }
        }
        return resultSet;
    }
    public static void showSet() {
        Set<Integer> setHash = new HashSet<>();
        Set<Integer> setTree = new TreeSet<>();
        Random random = new Random();
        for (int i = 0; i < 200; i++) {
            int rd = random.nextInt(30_000);
            System.out.printf("Número: %d  ", rd);
            setHash.add(rd);
            setTree.add(rd);
        }
        System.out.println();
        System.out.println(setHash);
        System.out.println(setTree);
    }
}
