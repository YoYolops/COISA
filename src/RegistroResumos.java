public class RegistroResumos {
    private Resumo[] resumos;
    private int quantidadeDeResumosRegistrados = 0;

    public RegistroResumos(int numeroDeResumos) {
        this.resumos = new Resumo[numeroDeResumos];
    }

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
