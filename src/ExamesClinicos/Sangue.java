package ExamesClinicos;

public class Sangue extends Exames {

    private static final long serialVersionUID = 1L;

    public Sangue(String nome_do_medico, String convenio, String nome_do_paciente) {
        super(nome_do_medico, convenio, nome_do_paciente);
        this.exame = "Sangue";
    }
}
