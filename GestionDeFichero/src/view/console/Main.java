/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.console;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Funciones;

/**
 *
 * @author sandropegman
 */
public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        sc.useDelimiter("\n");
        String opcion = "";
        do {
            System.out.println("MENU");
            System.out.println("1.- Crear Carpeta");
            System.out.println("2.- Crear Fichero");
            System.out.println("3.- Enseñar listado de ficheros");
            System.out.println("4.- Enseñar Fichero");
            System.out.println("5.- overWriteFile");
            System.out.println("6.- Eliminar fichero");
            System.out.println("7.- CountChars");
            System.out.println("8.- CountWord");
            System.out.println("z.- Salir");

            System.out.println("Opcion: ");
            opcion = sc.next();

            switch (opcion) {
                case "1":
                    System.out.println("Nombre de la carpeta: ");
                    String nombreArchivo = sc.next();
                    try {
                        Funciones.createFolder(nombreArchivo);
                    } catch (IOException ex) {
                        System.out.println("ERROR:" + ex.getMessage());
                    }
                    break;
                case "2":
                    System.out.println("Nombre de la ruta (Carpeta): ");
                    String path = sc.next();
                    System.out.println("Nombre dewl archivo (.txt)");
                    String fileName = sc.next();
                    System.out.println("Contenido del archivo");
                    String content = sc.next();
                    try {
                        Funciones.createFile(path, fileName, content);
                    } catch (IOException ex) {
                        System.out.println("ERROR:" + ex.getMessage());
                    }
                    break;

                case "3":
                    System.out.println("Introduce el nombre de la ruta: ");
                    String rutaCarpeta = sc.next();
                    try {
                        String[] list = Funciones.showListFiles(rutaCarpeta);
                        System.out.println(Arrays.toString(list));
                    } catch (IOException ex) {
                        System.out.println("ERROR:" + ex.getMessage());
                    }
                    break;

                case "4":
                    System.out.println("Pon el path");
                    path = sc.next();
                    System.out.println("Pon el nombre del archivo");
                    fileName = sc.next();
                    try {
                        String resultado = Funciones.showFile(path, fileName);
                        System.out.println(resultado);
                    } catch (IOException ex) {
                        System.out.println("ERROR:" + ex.getMessage());
                    }
                    break;
                case "5":
                    System.out.println("Pon el path");
                    path = sc.next();
                    System.out.println("Pon el nombre del archivo");
                    fileName = sc.next();
                    System.out.println("Añade nuevo contenido");
                    String newContent = sc.next();
                    try {

                        boolean resultados = Funciones.overWriteFile(path, fileName, newContent);
                        if (resultados) {
                            System.out.println("El archivo ha sido actualizado");
                        } else {
                            System.out.println("ERROR, No ha sido actualizado");
                        }
                    } catch (IOException ex) {
                        System.out.println("ERROR:" + ex.getMessage());
                    }
                    break;
                case "6":
                    System.out.println("Pon el path");
                    path = sc.next();
                    System.out.println("Pon el nombre del archivo");
                    fileName = sc.next();

                    Funciones.deleteFile(path, fileName);
                    break;
                case "7":
                    System.out.println("Pon el path");
                    path = sc.next();
                    System.out.println("Pon el nombre del archivo");
                    fileName = sc.next();
                    try {
                        int totalcaracteres = Funciones.countChars(path, fileName);
                        System.out.println("Hay un total de " + totalcaracteres + " Characteres.");
                    } catch (IOException ex) {
                        System.out.println("ERROR:" + ex.getMessage());
                    }
                    break;
                case "8":
                    System.out.println("Pon el path");
                    path = sc.next();
                    System.out.println("Pon el nombre del archivo");
                    fileName = sc.next();
                    try {
                        int totalPalabras = Funciones.countWords(path, fileName);
                        System.out.println(totalPalabras + " Total de palabras");
                    } catch (FileNotFoundException ex) {
                        System.out.println("ERROR:" + ex.getMessage());
                    }
                    break;

                case "z":
                    System.out.println("Adios");
                    break;

                default:
                    System.out.println("Opcion incorrecta");
            }

        } while (!opcion.equals("z"));

    }
}
