/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.console;

import java.util.Scanner;
import model.validations.UserDataValidations;

/**
 *
 * @author sandropegman
 */
public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        sc.useDelimiter("\n");
        String opcion;
        do {
            System.out.println("TESTER FUNCIONES UserDataValidations:");
            System.out.println("1.-testCheckId");
            System.out.println("2.-testCheckFormatDate");
            System.out.println("3.-testCalculateAge");
            System.out.println("4.-testCheckPostalCode");
            System.out.println("5.-testIsNumeric");
            System.out.println("6.-testIsAlphabetic");
            System.out.println("7.-testCheckEmail");
            System.out.println("8.-testCheckName");
            System.out.println("z.-EXIT");

            System.out.println("Opcion: ");
            opcion = sc.next();

            switch (opcion) {
                case "1":
                    testCheckId();
                    break;

                case "2":
                    testCheckFormatDate();
                    break;

                case "3":
                    testCalculateAge();
                    break;

                case "4":
                    testCheckPostalCode();
                    break;

                case "5":
                    testIsNumeric();
                    break;

                case "6":
                    testIsAlphabetic();
                    break;

                case "7":
                    testCheckEmail();
                    break;

                case "8":
                    testCheckName();
                    break;
                case "z":
                    System.out.println("Hasta pronto!!");
                    break;

                default:
                    System.out.println("No es correcta la opcion");
            }
        } while (!opcion.equals("z"));
    }

    static void testCheckId() {
        System.out.println("Enter your ID: ");
        String nif = sc.next();
//        Boolean Salida = UserDataValidations.checkId(1, nif);
//        if (Salida == true) {
//            System.out.println("El NIF " + nif + " es correcto");
//        } else {
//            System.out.println("El NIF " + nif + " no es correcto");
//        }
    }

    static void testCheckFormatDate() {
        System.out.println("Enter data: (dd/mm/aaaa)");
        String str = sc.next();
        Boolean Salida = UserDataValidations.checkFormatDate(str);
        if (Salida == true) {
            System.out.println("La fecha " + str + " es correcta");
        } else {
            System.out.println("La fecha " + str + " no es correcta");
        }
    }

    static void testCalculateAge() {
        System.out.println("Enter birth date: (dd/mm/aaaa");
        String birthDate = sc.next();
        int Salida = UserDataValidations.CalculateAge(birthDate);
        System.out.println("Tiene " + Salida + " años");
    }

    static void testCheckPostalCode() {
        System.out.println("Enter your Postal Code : ");
        String CP = sc.next();
        Boolean Salida = UserDataValidations.checkPostalCode(CP);
        if (Salida == true) {
            System.out.println("El Codigo Postal " + CP + " es correcto");
        } else {
            System.out.println("El Codigo Postal " + CP + " no es correcto");
        }
    }

    static void testIsNumeric() {
        System.out.println("Enter numbers : ");
        String Num = sc.next();
        Boolean Salida = UserDataValidations.isNumeric(Num);
        if (Salida == true) {
            System.out.println(Num + " es numerico");
        } else {
            System.out.println(Num + " no es numerico");
        }
    }

    static void testIsAlphabetic() {
        System.out.println("Enter word : ");
        String letra = sc.next();
        Boolean Salida = UserDataValidations.isAlphabetic(letra);
        if (Salida) {
            System.out.println(letra + " es correcto");
        } else {
            System.out.println(letra + " contiene numeros");
        }
    }

    static void testCheckEmail() {
        System.out.println("Enter email : ");
        String correo = sc.next();
        Boolean Salida = UserDataValidations.CheckEmail(correo);
        if (Salida == true) {
            System.out.println(correo + "  es correcto");
        } else {
            System.out.println(correo + " es incorrecto");
        }
    }

    static void testCheckName() {
        System.out.println("Enter name : ");
        String nombre = sc.next();
//        Boolean Salida = UserDataValidations.CheckName(nombre);
//        if (Salida == true) {
//            System.out.println(nombre + " es correcto");
//        } else {
//            System.out.println(nombre + " contiene numeros o supera el limite normal");
//        }
    }
}
