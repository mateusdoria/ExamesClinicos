package ExamesClinicos;

import javax.swing.*;
import java.util.ArrayList;

public class ExamesClinicos {
    private ArrayList<Exames> exame;

    public ExamesClinicos() {
        this.exame = new ArrayList<Exames>();
    }

    public String[] leValores(String[] dadosIn) {
        String[] dadosOut = new String[dadosIn.length];

        for (int i = 0; i < dadosIn.length; i++)
            dadosOut[i] = JOptionPane.showInputDialog("Entre com " + dadosIn[i] + ": ");

        return dadosOut;
    }

    public Radiografia leRadiografia() {

        String[] valores = new String[3];
        String[] nomeVal = {"Nome do Paciente", "Convenio", "Nome do Medico"};
        valores = leValores(nomeVal);


        Radiografia radiografia = new Radiografia(valores[0], valores[1], valores[2]);
        return radiografia;
    }

    public Sangue leSangue() {

        String[] valores = new String[3];
        String[] nomeVal = {"Nome do Paciente", "Convenio", "Nome do Medico"};
        valores = leValores(nomeVal);


        Sangue sangue = new Sangue(valores[0], valores[1], valores[2]);
        return sangue;
    }

    public Ecografia ecografia() {

        String[] valores = new String[3];
        String[] nomeVal = {"Nome do Paciente", "Convenio", "Nome do Medico"};
        valores = leValores(nomeVal);


        Ecografia ecografia = new Ecografia(valores[0], valores[1], valores[2]);
        return ecografia;
    }
}
