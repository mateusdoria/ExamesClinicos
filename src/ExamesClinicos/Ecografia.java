package ExamesClinicos;

public class Ecografia extends Exames{
    private static final long serialVersionUID = 1L;

    public Ecografia(String nome_do_medico, String convenio, String nome_do_paciente) {
        super(nome_do_medico, convenio, nome_do_paciente);
        this.exame= "Ecografia";
}}
