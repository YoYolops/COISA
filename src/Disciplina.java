/**
 * Representação do progresso em uma determinada disciplina, controlando horas de estudo e notas alcançadas
 * @author Yohan Lopes
 */
public class Disciplina {
    private double[] notas = new double[4];
    private int horasDeEstudo = 0;
    private String nomeDisciplina;

    /**
     * Constrói uma nova disciplina baseado apenas em um nome. Todos os outros atributos são bem definidos/padronizados
     * e começam sempre zerados
     * @param nomeDisciplina String
     */
    public Disciplina(String nomeDisciplina) { this.nomeDisciplina = nomeDisciplina; }

    public void cadastraHoras(int horas) { this.horasDeEstudo += horas; }

    public void cadastraNota(int nota, double valorNota) {
        if(valorNota < 0) throw new Error("Disciplina: valor da nota deve ser positivo ou 0");
        this.notas[nota - 1] = valorNota;
    }

    /**
     * Calcula a média aritmética das notas registradas. Caso hajam notas não registradas ainda, são
     * consideradas como zero e o método retorna uma média parcial
     * @return valor double da média aritmética
     */
    private double calcularMediaDasNotasCadastradas() {
        double somaDasNotas = 0;
        for(double nota : this.notas) { somaDasNotas += nota; }
        return (somaDasNotas/(this.notas.length));
    }

    public boolean aprovado() { return this.calcularMediaDasNotasCadastradas() >= 7; }

    /**
     * Cria uma representação visual das notas armazenadas internamente, para fins de exibição em console.
     * @return String formatada em molde proposto
     */
    private String stringifyNotasCadastradas() {
        String baseString = "[";
        for(int i = 0; i < this.notas.length; i++) {
            baseString += this.notas[i];
            
            if(i == this.notas.length - 1) baseString += "]";
            else baseString += ", ";
        }
        return baseString;
    }

    public String toString() {
        return this.nomeDisciplina+" "+this.horasDeEstudo+" "+this.calcularMediaDasNotasCadastradas()+" "+this.stringifyNotasCadastradas();
    }
}