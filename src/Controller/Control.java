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

                int dec = 0, aux = 0, mod = 0;
                String bin = "", auxv = "";
                double resto = 0, num1, numtotal, total;
                boolean bandera = false;
//            char vector[] = null;
                String c = "";
                char vector1[] = vi.TxtDecimal.getText().toCharArray();
                for (int i = 0; i < vi.TxtDecimal.getText().length(); i++) {
                    if (vector1[i] == '.') {
                        break;
                    } else {
                        c += vector1[i];
                    }
                }
                dec = Integer.parseInt(c);
                while (dec != 0 || dec > 0) {
                    mod = (dec % 2);
                    bin = mod + bin;
                    dec /= 2;
                }
//            vi.txtbin.setText(String.valueOf(bin));
                numtotal = Double.parseDouble(vi.TxtDecimal.getText());//14.63
                num1 = Double.parseDouble(c);//14.0
                total = (numtotal - num1);
                //14.63 -14.0=0.63

                while (bandera != true) {
                    total = (total * 2);

                    if (total == 0.0) {
                        System.out.println("entro");
                        bandera = true;
                    }
                    String auxbin = "";
                    auxbin += total;
                    System.out.println("aux bin" + auxbin);
                    char vector[] = auxbin.toCharArray();
                    auxv += vector[0];

                    if (vector[0] == '0') {

                    } else if (vector[0] == '1') {
                        total = total - 1.0;

                    }
                }

                vi.txtbin.setText(String.valueOf(bin + "." + auxv));
            }
        } else {
            vi.txtbin.setText("");
            vi.TxtDecimal.setText("");
//            JOptionPane.showMessageDialog(null, "no entro");
        }

    }

}
