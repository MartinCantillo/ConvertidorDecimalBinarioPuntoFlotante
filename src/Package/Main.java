/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Package;

import Controller.Control;
import View.Vista;

/**
 *
 * @author marti
 */
public class Main {

    public static void main(String[] args) {
        Vista v = new Vista();
        Control control = new Control(v);
        control.iniciar(v);

    }
}
