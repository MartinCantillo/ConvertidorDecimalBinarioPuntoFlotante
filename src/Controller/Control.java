/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import View.Vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author marti
 */
public class Control implements ActionListener {

    Vista vi = new Vista();

    public Control(Vista v) {
        this.vi = v;
        v.btconver.addActionListener(this);
        v.btreset.addActionListener(this);

    }

    public void iniciar(Vista vs) {
        vs.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vi.btconver) {

            if (vi.TxtDecimal.getText().equalsIgnoreCase("")) {
                JOptionPane.showMessageDialog(null, "Por favor verifique");
            } else {

                int dec = 0, aux = 0, mod = 0, mod3 = 0, mod4 = 0;
                String bin = "", auxv = "", bin3 = "", bin4 = "";
                double resto = 0, num1, numtotal, total;
                boolean bandera = false;
//            char vector[] = null;
                char vector2[] = null;
                String c = "";
                int signo = 0;
                char vector1[] = vi.TxtDecimal.getText().toCharArray();
                //String texto = vi.TxtDecimal.getText();
                int bitsnum = vi.TxtDecimal.getText().length();
                //creo vector
                char[] auxbinn;
                String Subcadena = "";
                int j = 0, contpunto = 0;//lo empiezo en dos porque para contar los caracteres le llevan 2 de mas;
                if (vector1[0] == '-') {
                    Subcadena = vi.TxtDecimal.getText().substring(1, bitsnum);
                    vector2 = Subcadena.toCharArray();
                    signo = 1;

                } else {
                    vector2 = vi.TxtDecimal.getText().toCharArray();
                }

                for (int i = 0; i < vi.TxtDecimal.getText().length(); i++) {

                    if (vector2[i] == '.') {

                        break;
                    } else {

                        c += vector2[i];
                    }

                }

                dec = Integer.parseInt(c);
                while (dec != 0 || dec > 0) {
                    mod = (dec % 2);
                    bin = mod + bin;
                    dec /= 2;
                }
                auxbinn = bin.toCharArray();
                String b = String.valueOf(vector2);
                //aqui obtengo el exponente
                contpunto = bin.length() - 1;
//            vi.txtbin.setText(String.valueOf(bin));
                numtotal = Double.parseDouble(b);//14.63
                num1 = Double.parseDouble(c);//14.0
                total = (numtotal - num1);
                //14.63 -14.0=0.63

                while (bandera != true) {
                    total = (total * 2);

                    if (total == 0.0) {
//                        System.out.println("entro");
                        bandera = true;
                    }
                    String auxbin = "";
                    auxbin += total;

//                    System.out.println("aux bin" + auxbin);
                    char vector[] = auxbin.toCharArray();

                    auxv += vector[0];

                    if (vector[0] == '0') {

                    } else if (vector[0] == '1') {
                        total = total - 1.0;

                    }

                }
                j = auxv.length();
                vi.TxtNumbit.setText(String.valueOf(bin.length() + signo + j));
                if (signo == 0) {
                    vi.txtbin.setText(String.valueOf(bin + "." + auxv));

                } else {
                    vi.txtbin.setText(String.valueOf("-" + bin + "." + auxv));

                }
                int cont2 = -1;
                //identificar el primer1
                for (int i = 0; i < auxbinn.length; i++) {
                    if (auxbinn[i] == '1') {
                        cont2++;
                    } else {

                    }
                }

//                System.out.println("el primer 1 esta  en la pos" + cont2);
//                System.out.println("se han rodado " + contpunto + "a la izqq");
                vi.Txtexpdecimal.setText(String.valueOf(contpunto));
                // ya lo identifique , ahora voy a convertirlo a binario(el exponente)
                System.out.println(contpunto);
//                while (contpunto != 0 || contpunto > 0) {
//                    mod3 = (contpunto % 2);
//                    bin3 = mod3 + bin3;
//                    contpunto /= 2;
//                }
//                
                vi.txtexpbin.setText(String.valueOf(bin3));
                vi.TxtBitsexpbin.setText(String.valueOf(auxv.length() + bin3));
                //voy hallar el exponente le sumo siempre 127 lal exponente en decimal  para que me de un digito de 8 bits
                int r = (127 + contpunto);
                while (r != 0 || r > 0) {
                    mod4 = (r % 2);
                    bin4 = mod4 + bin4;
                    r /= 2;
                }
                // vi.txtmantisa.setText(auxv);
                vi.txtexpbin.setText(String.valueOf(bin4));
                vi.TxtBitsexpbin.setText("8 Bits");
                // char mantiza[]=bin.toCharArray();

                String extraerdecimal = bin;
                String subcnueva = extraerdecimal.substring(1, bin.length());
//                System.out.println("quito el 1= " + subcnueva);

                // ahora voy hallar la mantisa para eso obtengo el primer 1 de la parte entera
                vi.TxtBina.setText("1." + subcnueva + auxv);

                String extraerdecimal2 = vi.TxtBina.getText();
                String subcnueva2 = extraerdecimal2.substring(2, vi.TxtBina.getText().length());
//                System.out.println("quito el 1= "+subcnueva );
//                System.out.println("mantiza normal="+subcnueva2);
                vi.txtmantisa.setText(subcnueva2);
                vi.TxtBitsmantisa.setText(String.valueOf(subcnueva2.length()));
                vi.TxtNumbit.setText(String.valueOf(vi.TxtBina.getText().length()));
                // System.out.println("auxv"+auxv);
                //quede por aqui 3:54 pm 26 de febrero , ahora lo que voy hacer es agrupar la  mantiza y la parte entera 
                // a binario(etiqueta ) luego voy a comparar hasta donde este el punto antes de eso pasare elpunto al primer 1 en el txfield y luego ya sacare la 
                //mantisa y el numero de bits de la mantiza y ya luego el signo me tocaria colocar 0 si es positivo y 1 si es negativo y ya
//               vi.TxtBina.setText(b);
            }
        } else {
            vi.txtbin.setText("");
            vi.TxtDecimal.setText("");
            vi.TxtNumbit.setText("");
            vi.txtmantisa.setText("");
            vi.TxtBitsmantisa.setText("");
            vi.TxtNumbit.setText("");
            vi.TxtBina.setText("");
            vi.txtexpbin.setText("");
            vi.TxtBitsexpbin.setText("");
            vi.TxtBitsexpbin.setText("");
            vi.Txtexpdecimal.setText("");

//            JOptionPane.showMessageDialog(null, "no entro");
        }

    }

}
