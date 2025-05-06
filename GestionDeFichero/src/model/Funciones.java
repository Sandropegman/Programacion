/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author sandropegman
 */
public class Funciones {

    /**
     * Crea una carpeta en el fichero del programa
     *
     * @param date deben introducir el nombre del archivo
     * @return
     *
     */
    public static void createFolder(String fileName) throws IOException {
        String path = System.getProperty("user.dir");
        String separador = File.separator;
        String rutaCarpeta = path + separador + fileName;

        File carpeta = new File(rutaCarpeta);
        if (!carpeta.exists()) {
            carpeta.mkdir();
        }
    }

    /**
     * Crea un fichero en la carpeta que quiera el usuario
     *
     * @param date deben introducir el nombre de la carpeta donde quiere crear
     * el archivo
     * 
     *
     */
    public static void createFile(String path, String fileName, String content) throws IOException {

        String separador = File.separator;
        String rutaFile = path + separador;
        File file = new File(rutaFile);

        File fichero = new File(file, fileName);

        FileWriter fw = new FileWriter(fichero, true);

        BufferedWriter bw = new BufferedWriter(fw);

        bw.write(content);
        bw.newLine();
        bw.flush();
        bw.close();
    }

    /**
     * Enseña una lista de los archivos de una carpeta
     *
     * @param date deben introducir el path
     * @return enseña la lista de documentos
     *
     */
    public static String[] showListFiles(String rutaCarpeta) throws IOException {
        File carpeta = new File(rutaCarpeta);
        String[] listaDocumentos = carpeta.list();

        return listaDocumentos;
    }

    /**
     * Enseña el contenido de un archivo
     *
     * @param date deben introducir el path y el nombre del archivo
     * @return devuelve el contenido del archivo
     *
     */
    public static String showFile(String path, String fileName) throws IOException {
        String separador = File.separator;
        File fichero = new File(path + separador + fileName);
        Scanner scan = new Scanner(fichero);
        scan.useDelimiter("\\Z");

        String contenido = scan.next();
        scan.close();

        return contenido;
    }

    /**
     * Puede sobreescribir un documento txt
     *
     * @param date debe introducir el path , nombrefichero y el contenido nuevo
     * @return devuelve true si se ha modificado y false si no se ha podido modificar
     *
     */

    public static boolean overWriteFile(String path, String fileName, String newContent) throws IOException {
        String separador = File.separator;
        File fichero = new File(path + separador + fileName);

        if (!fichero.exists()) {
            return false; 
        }

        FileWriter writer = new FileWriter(fichero, false);
        writer.write(newContent);
        writer.close();

        return true;
    }

    /**
     * Elimina el archivo 
     *
     * @param date debe introducir el path , nombrefichero
     * @return elimina el fichero
     *
     */
    public static void deleteFile(String path, String fileName) {
        String separador = File.separator;
        File fichero = new File(path + separador + fileName);
        fichero.delete();
    }
    /**
     * Cuenta los characteres que tiene el documento
     *
     * @param date debe introducir el path , nombrefichero
     * @return devuelve la cantidad de characteres
     *
     */
    public static int countChars(String path, String fileName) throws FileNotFoundException {
        String separador = File.separator;
        File fichero = new File(path + separador + fileName);
        Scanner scan = new Scanner(fichero);
        scan.useDelimiter("\\Z");
        String contenido = scan.next();
        scan.close();

        return contenido.length();
    }
    /**
     * Cuenta la cantidad de palabras que tiene el documento
     *
     * @param date debe introducir el path , nombrefichero
     * @return devuelve la cantidad de palabras
     *
     */
    public static int countWords(String path, String fileName) throws FileNotFoundException {

        String separador = File.separator;
        File fichero = new File(path + separador + fileName);
        Scanner scan = new Scanner(fichero);
        int contador = 0;
        while (scan.hasNext()) {
            scan.next();
            contador++;
        }

        scan.close();
        return contador;
    }

}
