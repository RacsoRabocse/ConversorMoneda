import java.text.DecimalFormat;
import javax.swing.JOptionPane;

//Creado por: Oscar
//Fecha: 07/07/24

public class Conversor {
    public static void main(String[] args) {

//Creando el menu
        Object [] opcion = {"Convertir Divisas ", "Salir"};
        //Usando JoptionPane para crear interfaces predefinidas
        int elige = JOptionPane.showOptionDialog(null, "¿Que quieres hacer?", "Conversor de monedas",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opcion, opcion[0]);

        //Mostrando los mensajes al usuario
        if (elige == 1){
            JOptionPane.showMessageDialog(null, "Finalizando ejecucion");
            System.exit(0);
        }

        if (elige == 0){
            //Dandole formato a la moneda en 2 decimales
            DecimalFormat formatearDivisa = new DecimalFormat("#.##");
            boolean continuar = true;
            while(continuar){
                String [] opciones = {"Dolares a Euros" , "Euros a Dolares", "Dolares a Quetzales", "Dolares a Lempiras"};
                String cambio = (String) JOptionPane.showInputDialog(null,"Eliga una opcion",
                        "Conversos de moneda", JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
                String input = JOptionPane.showInputDialog(null, "Ingrese la cantidad: ");
                //Inicializando variable
                double dolares = 0;
                double euros = 0;
                try{
                    dolares = Double.parseDouble(input);
                    euros = Double.parseDouble(input);
                }catch (NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "Valor no valido");
                }

                switch (cambio) {
                    case "Dolares a Euros" -> {
                        double total = dolares * 0.92;
                        JOptionPane.showMessageDialog(null, dolares +
                                " Dolares son: " + formatearDivisa.format(total) + " Euros.");
                    }
                    case "Euros a Dolares" -> {
                        double total = euros * 1.08;
                        JOptionPane.showMessageDialog(null, euros +
                                " Euros son: " + formatearDivisa.format(total) + " Dolares.");
                    }
                    case "Dolares a Quetzales" -> {
                        double total = dolares * 7.75;
                        JOptionPane.showMessageDialog(null, dolares +
                                " Dolares son: " + formatearDivisa.format(total) + " Quetzales.");
                    }
                    case "Dolares a Lempiras" -> {
                        double total = dolares * 24.70;
                        JOptionPane.showMessageDialog(null, dolares +
                                " Dolares son: " + formatearDivisa.format(total) + " Lempiras.");
                    }
                }

                int confirma = JOptionPane.showConfirmDialog(null, "¿Desea continuar usando el programa?",
                        "Confirmar", JOptionPane.YES_NO_CANCEL_OPTION);
                if (confirma == JOptionPane.NO_OPTION || confirma == JOptionPane.CANCEL_OPTION){
                    continuar = false;
                    JOptionPane.showMessageDialog(null, "Programa finalizado");
                }//If

            }//While
        }//If
    }//Main
}