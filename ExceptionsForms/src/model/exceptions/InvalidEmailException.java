/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.exceptions;

/**
 *
 * @author sandr
 */
public class InvalidEmailException extends Exception {
    public InvalidEmailException(String message) {
        super(message);
    }
}