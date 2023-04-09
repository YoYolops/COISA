/**
 * Representação de um resumo, armazenando seu tema e conteúdo,
 * fornecendo um modelo de visualização padrão com toString
 */
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
