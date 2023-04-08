public class Resumo {
    String tema;
    String conteudo;

    public Resumo(String tema, String conteudo) {
        this.tema = tema;
        this.conteudo = conteudo;
    }

    public String toString() { return this.tema + ": " + this.conteudo; }

    public String getTema() { return this.tema; }
}
