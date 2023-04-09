public class RegistroTempoOnline {
    private String nomeDisciplina;
    private int tempoOnlineEsperado;
    private int quantidadeHorasRegistradas = 0;

    /**
     * Constrói Registro com valores padrões
     * @param nomeDisciplina
     */
    public RegistroTempoOnline(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
        this.tempoOnlineEsperado = 120;
    }

    /**
     * Constrói Registro com valor personalizado de horas esperadas, dispara erro caso quantidade de horas
     * inválida (inferior a zero)
     * @param nomeDisciplina 
     * @param tempoOnlineEsperado
     */
    public RegistroTempoOnline(String nomeDisciplina, int tempoOnlineEsperado) {
        if(tempoOnlineEsperado < 0) throw new Error("RegistroTempoOnline: Quantidade de horas deve ser um valor positivo");
        this.nomeDisciplina = nomeDisciplina;
        this.tempoOnlineEsperado = tempoOnlineEsperado;
    }

    public void adicionaTempoOnline(int horas) { this.quantidadeHorasRegistradas += horas; }

    public boolean atingiuMetaTempoOnline() { return quantidadeHorasRegistradas >= tempoOnlineEsperado; }

    public String toString() { return nomeDisciplina + " " + quantidadeHorasRegistradas + "/" + tempoOnlineEsperado; }
}
