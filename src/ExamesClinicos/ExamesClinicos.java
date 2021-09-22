package ExamesClinicos;

import javax.swing.*;
import java.util.ArrayList;

public class ExamesClinicos {
    private ArrayList<Exames> exame;

    public ExamesClinicos() {
        this.exame = new ArrayList<Exames>();
    }
    public String[] leValores (String [] dadosIn){
        String [] dadosOut = new String [dadosIn.length];

        for (int i = 0; i < dadosIn.length; i++)
            dadosOut[i] = JOptionPane.showInputDialog  ("Entre com " + dadosIn[i]+ ": ");

        return dadosOut;
    }
}
