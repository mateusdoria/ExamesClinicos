package ExamesClinicos;

import javax.swing.*;
import java.io.*;
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
    public void salvaExame (ArrayList<Exames> exame){
        ObjectOutputStream outputStream = null;
        try {
            outputStream = new ObjectOutputStream
                    (new FileOutputStream("c:\\temp\\examesClinicos.dados"));
            for (int i=0; i < exame.size(); i++)
                outputStream.writeObject(exame.get(i));
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Imposs�vel criar arquivo!");
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {  //Close the ObjectOutputStream
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    public ArrayList<Exames> recuperaExame (){
        ArrayList<Exames> examesTemp = new ArrayList<Exames>();

        ObjectInputStream inputStream = null;

        try {
            inputStream = new ObjectInputStream
                    (new FileInputStream("c:\\temp\\examesClinicos.dados"));
            Object obj = null;
            while ((obj = inputStream.readObject()) != null) {
                if (obj instanceof Exames) {
                    examesTemp.add((Exames) obj);
                }
            }
        } catch (EOFException ex) { // when EOF is reached
            System.out.println("Fim de arquivo.");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Arquivo com exames N�O existe!");
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {  //Close the ObjectInputStream
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (final IOException ex) {
                ex.printStackTrace();
            }
            return examesTemp;
        }
    }
    private boolean intValido(String s) {
        try {
            Integer.parseInt(s); // M�todo est�tico, que tenta tranformar uma string em inteiro
            return true;
        } catch (NumberFormatException e) { // N�o conseguiu tranformar em inteiro e gera erro
            return false;
        }
    }
    public int retornaInteiro(String entrada) { // retorna um valor inteiro
        int numInt;

        //Enquanto n�o for poss�vel converter o valor de entrada para inteiro, permanece no loop
        while (!this.intValido(entrada)) {
            entrada = JOptionPane.showInputDialog(null, "Valor incorreto!\n\nDigite um n�mero inteiro.");
        }
        return Integer.parseInt(entrada);
    }
    public void menuClinica (){

        String menu = "";
        String entrada;
        int    opc1, opc2;

        do {
            menu = "Controle Clinica\n" +
                    "Opções:\n" +
                    "1. Entrar Exames\n" +
                    "2. Exibir Exames\n" +
                    "3. Limpar Exames\n" +
                    "4. Gravar Exames\n" +
                    "5. Recuperar Exames\n" +
                    "9. Sair";
            entrada = JOptionPane.showInputDialog (menu + "\n\n");
            opc1 = this.retornaInteiro(entrada);

            switch (opc1) {
                case 1:// Entrar dados
                    menu = "Entrada de Exames Clinicos\n" +
                            "Opções:\n" +
                            "1. Radiografia\n" +
                            "2. Sangue\n";

                    entrada = JOptionPane.showInputDialog (menu + "\n\n");
                    opc2 = this.retornaInteiro(entrada);

                    switch (opc2){
                        case 1: exame.add((Exames)leRadiografia());
                            break;
                        case 2: exame.add((Exames)leSangue());
                            break;
                        default:
                            JOptionPane.showMessageDialog(null,"Exame Clinico para entrada NÃO escolhido!");
                    }

                    break;
                case 2: // Exibir dados
                    if (exame.size() == 0) {
                        JOptionPane.showMessageDialog(null,"Entre com exames clinicos primeiramente");
                        break;
                    }
                    String dados = "";
                    for (int i=0; i < exame.size(); i++)	{
                        dados += exame.get(i).toString() + "---------------\n";
                    }
                    JOptionPane.showMessageDialog(null,dados);
                    break;
                case 3: // Limpar Dados
                    if (exame.size() == 0) {
                        JOptionPane.showMessageDialog(null,"Entre com exames clinicos primeiramente");
                        break;
                    }
                    exame.clear();
                    JOptionPane.showMessageDialog(null,"Dados LIMPOS com sucesso!");
                    break;
                case 4: // Grava Dados
                    if (exame.size() == 0) {
                        JOptionPane.showMessageDialog(null,"Entre com exames clinicos primeiramente");
                        break;
                    }
                    salvaExame(exame);
                    JOptionPane.showMessageDialog(null,"Dados SALVOS com sucesso!");
                    break;
                case 5: // Recupera Dados
                    exame = recuperaExame();
                    if (exame.size() == 0) {
                        JOptionPane.showMessageDialog(null,"Sem dados para apresentar.");
                        break;
                    }
                    JOptionPane.showMessageDialog(null,"Dados RECUPERADOS com sucesso!");
                    break;
                case 9:
                    JOptionPane.showMessageDialog(null,"Fim do aplicativo Clinica de Exames");
                    break;
            }
        } while (opc1 != 9);
    }

    public static void main (String [] args){

        ExamesClinicos pet = new ExamesClinicos ();
        pet.menuClinica();
    }
}

