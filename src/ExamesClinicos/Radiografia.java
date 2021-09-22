package ExamesClinicos;

public class Radiografia extends Exames {
    private static final long serialVersionUID = 1L;

    public Radiografia(String nome_do_medico, String convenio, String nome_do_paciente) {
        super(nome_do_medico, convenio, nome_do_paciente);
        this.exame= "Radiografia";
    }}

