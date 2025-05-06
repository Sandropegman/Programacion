/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.validations;

import model.exceptions.IdFormatException;
import model.exceptions.InvalidNameException;

/**
 *
 * @author sandropegman
 */
public class UserDataValidations {

    /**
     * Debe validar si el documento indetificativo recibido es correcto o no.
     *
     * @param typeDoc indica el tipo de documento indetificativo (NIF -1 , ....)
     * @param id contiene el documento indentificativo a validar
     * @return Devuelve true en caso que el documento es correcto y false si no
     * lo es
     */
    public static boolean checkId(int typeDoc, String id) throws IdFormatException {
        boolean idOk = false;
        int Todo = 9;
        String letras[] = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"};
        String numeros = id.substring(0, 8);
        int numerosN = Integer.parseInt(numeros);
        int resultado = 0;
        if (typeDoc != 1) {
            idOk = false;
        }

        if (id.length() == 9) {
            for (int i = 0; i < 7; i++) {
                if (Character.isDigit(numeros.charAt(i))) {
                    for (int j = 0; j < letras.length; j++) {
                        if (letras[j].equals(id.substring(8, id.length()))) {
                            resultado = numerosN % 23;
                            if (letras[resultado].equals(id.substring(8, id.length()))) {

                                idOk = true;
                            }
                        }

                    }
                }
            }
        } else {

            throw new IdFormatException("NIF incorrecto, porfavor escribe bien");
        }
        //validaciones (no prints)
        return idOk;
    }

    /**
     * Debe validar si el documento indetificativo recibido es correcto o no.
     *
     * @param date es la fecha que introduce el ususario
     * @return Devuelve true en caso que la fecha sea correcta y este todo el
     * los parametros de las fechas
     *
     */
    public static boolean checkFormatDate(String date) {
        boolean dateOk = false;
 
        int diasMes[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] numeros;

        int dia, mes, año;
        if (date.length() == 10) {
            numeros = date.split("/");
            dateOk = false;

            dia = Integer.parseInt(numeros[0]);
            mes = Integer.parseInt(numeros[1]);
            año = Integer.parseInt(numeros[2]);
            if (numeros[0].length() != 2 || numeros[1].length() != 2 || numeros[2].length() != 4) {
                dateOk = false;
            } else if (mes >= 1 && mes <= 12) {
                if (dia >= 1 && dia <= diasMes[mes - 1]) {
                    dateOk = true;
                }
            }
        } else {
            dateOk = false;
        }

        return dateOk;
    }

    /**
     * Debe validar si el documento indetificativo recibido es correcto o no.
     *
     * @param birthDate contiene la fecha de nacimiento
     * @return Devuelve en caso de que la fecha sea correcta la edad que
     * corresponde
     */
    public static int CalculateAge(String birthDate) {
        int añoact = 2025;
        int age = 0;
        int mesact = 01;
        int diaact = 27;
        String numeros[];
        int diasMes[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int dia, mes, año;
        boolean data = UserDataValidations.checkFormatDate(birthDate);
        if (data == false) {//
            age = -1;
            System.out.println("La fecha no coincide con lo pedido");
        } else {
            numeros = birthDate.split("[/|/|\"]");

            dia = Integer.parseInt(numeros[0]);
            mes = Integer.parseInt(numeros[1]);
            año = Integer.parseInt(numeros[2]);

            if (dia <= diaact && mes <= mesact) {
                age = (añoact - año);
            } else {
                age = (añoact - año) - 1;

            }
            if (age <= 0){
                age = -1;
            }

        }

        return age;
    }

    /**
     * Debe validar si el documento indetificativo recibido es correcto o no.
     *
     * @param zip contiene el codigo postal
     * @return Devuelve true en caso de que el codigo postal sea correcto y
     * false en caso de que no lo sea
     */
    public static boolean checkPostalCode(String zip) {
        int NUMCP = 5;
        boolean CPOk = false;
        if (zip.length() == NUMCP) {
            CPOk = true;
            for (int i = 0; i < NUMCP; i++) {
                if (!Character.isDigit(zip.charAt(i))) {  //! hace el contrario encuentra caracteres no int
                    CPOk = false;
                    break;
                }
            }
        }
        return CPOk;
    }

    /**
     * Debe validar si el documento indetificativo recibido es correcto o no.
     *
     * @param str contiene los numeros escrito por el usuario
     * @return Devuelve true en caso de que no hay letras ni caracteres y false
     * en caso de que si
     */
    public static boolean isNumeric(String str) {
        boolean Nok = true;

        Nok = true;
        for (int i = 0; i < str.length(); i++) {
            if (Character.isDigit(str.charAt(i))) {
                Nok = false;
                break;
            }
        }

        return Nok;
    }

    /**
     * Debe validar si el documento indetificativo recibido es correcto o no.
     *
     * @param str contiene las letras/palabras que el usuario ha introducido
     * @return Devuelve verdadero en caso de que sea todo letras y false en caso
     * de que no lo sea
     */
    public static boolean isAlphabetic(String str) {
        boolean Nok = true;

        for (int i = 0; i < str.length(); i++) {
            if (!Character.isLetter(str.charAt(i))) {
                Nok = false;
            }
        }

        return Nok;
    }

    /**
     * Debe validar si el documento indetificativo recibido es correcto o no.
     *
     * @param email contiene el email del usuario
     * @return Devuelve verdadero en caso de que el correo este bien escrito
     */

    public static boolean CheckEmail(String email) {
        boolean Nok = false;
        if (email.contains("@") && email.contains(".")) {
            System.out.println("1");
            String emailpartes[] = email.split("@");
            if (emailpartes.length == 2 && emailpartes[0].isEmpty() == false && emailpartes[1].isEmpty() == false) {
                System.out.println("2");
                if (emailpartes[1].contains(".")) {
                    System.out.println("3");
                    String com[] = emailpartes[1].split("\\.");
                    Nok = true;
                }
            }
        }
        return Nok;
    }

    /**
     * Debe validar si el documento indetificativo recibido es correcto o no.
     *
     * @param name contiene el nombre que introduzca el usuario
     * @return Devuelve true en caso que sean todo letras y no supere 20 letras
     */
    public static boolean CheckName(String name) throws InvalidNameException {
        boolean Nok = false;
        if (isAlphabetic(name) && name.length() <= 20) {
            throw new InvalidNameException("Nombre incorrecto. Solo letras y hasta 20 caracteres.");
        }
        return Nok;
    }
}
