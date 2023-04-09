/**
 * Classe repositório de resumos. Cria, manipula e armazena uma quantidade limitada de resumos
 * @author Yohan Lopes
 */
public class RegistroResumos {
    /**
     * Controla a quantidade de resumos já registrados. Quando a classe atinge capacidade máxima,
     * esse atributo para de ser atualizado.
     */
    private int quantidadeDeResumosRegistrados = 0;
    private Resumo[] resumos;

    /**
     * Constrói um RegistroResumos limitando a quantidade máxima de resumos que podem ser armazenados.
     * @param numeroDeResumos int máximo de resumos que podem ser armazenados na instância.
     */
    public RegistroResumos(int numeroDeResumos) {
        this.resumos = new Resumo[numeroDeResumos];
    }

    /**
     * Lida com a organização e adição à coleção de resumos. Caso a coleção esteja lotada, o resumo mais
     * antigo é apagado (que se encontra no primeiro indice) e todos os subsequentes são deslocados
     * uma posição para a esquerda, resultando em um espaço vago ao final do array, que é preenchido
     * com o novo resumo a ser inserido.
     * @param tema String titulo/tema do resumo
     * @param resumo String conteúdo textual do resumo
     */
    public void adiciona(String tema, String resumo) {
        if(this.quantidadeDeResumosRegistrados >= this.resumos.length) {
            for(int i = 0; i < this.resumos.length - 1; i++) {
                this.resumos[i] = this.resumos[i + 1];
            }

            this.resumos[this.resumos.length - 1] = new Resumo(tema, resumo);
        } else {
            this.resumos[this.quantidadeDeResumosRegistrados] = new Resumo(tema, resumo);
            this.quantidadeDeResumosRegistrados += 1;
        }
    }

    public int conta() { return quantidadeDeResumosRegistrados; }

    public String[] pegaResumos() {
        String[] resumosToString = new String[this.quantidadeDeResumosRegistrados];
        for(int i = 0; i < this.quantidadeDeResumosRegistrados; i++) { resumosToString[i] = this.resumos[i].toString(); }
        return resumosToString;
    }

    /**
     * Cria representação visual em string dos temas de resumos cadastrados
     * @return String de temas de resumos
     */
    private String stringifyTemasCadastrados() {
        String baseString = "- ";

        for(int i = 0; i < this.quantidadeDeResumosRegistrados; i++) {
            if(i == 0) baseString += this.resumos[i].getTema();
            else baseString += " | " + this.resumos[i].getTema();
        }
        return baseString;
    }

    public String imprimeResumos() {
        String quantidadeDeResumosRegistrados = "- " + this.quantidadeDeResumosRegistrados + " resumo(s) cadastrado(s)\n";
        String temas = this.stringifyTemasCadastrados();
        return quantidadeDeResumosRegistrados + temas;
    }

    public boolean temResumo(String tema) {
        for(Resumo resumo : this.resumos) {
            if(resumo == null) return false;
            if(resumo.getTema().equals(tema)) return true;
        }
        return false;
    }
}
