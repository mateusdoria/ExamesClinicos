package ExamesClinicos;

import java.io.Serializable;

public abstract class Exames implements Serializable {

    private static final long serialVersionUID = 1L;
    private   String nome_do_medico;
    private   String convenio;
    private   String nome_do_paciente;
    public String exame;

    public Exames(String nome_do_medico, String convenio, String nome_do_paciente) {
        this.nome_do_medico = nome_do_medico;
        this.convenio = convenio;
        this.nome_do_paciente = nome_do_paciente;
    }
    public String toString() {
        String retorno = "";
        retorno += "Nome do Médico: "     + this.nome_do_medico     + "\n";
        retorno += "Convenio: "    + this.convenio    + " \n";
        retorno += "Nome do Paciente: "     + this.nome_do_paciente     + "\n";
        retorno += "Especie: "  + this.especie  + "\n";
        retorno += "Barulho: "  + soar()        + "\n";
        return retorno;
    }
}
