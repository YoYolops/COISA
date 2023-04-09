public class Descanso {
    /**
    * Atributo de configuração, não deve mudar nunca durante a execução do programa sob
    * pena de comportamento imprevisível
    */
    public final int META_DESCANSO_SEMANAL = 26;

    private int horasDescansadas = 0;
    private int semanasDecorridas = 0;

    /**
     * Classe descanso lida sempre com medidas de tempo. Por isso verificam-se se os valores
     * inputados são válidos (positivos ou zero), visto que pra essa implementação,
     * tempo negativo não faz sentido
     * @param valor inteiro representando quantidade de horas
     * @return se o valor é válido ou não, através de boolean
     */
    private boolean valorValido(int valor) {
        if(valor < 0) return false;
        return true;
    }

    public void defineHorasDescanso(int valor) {
        if(this.valorValido(valor)) this.horasDescansadas = valor;
        else throw new Error("Descanso: Valor de horas de descanso deve ser positivo");
    }

    public void defineNumeroSemanas(int valor) {
        if(this.valorValido(valor)) this.semanasDecorridas = valor;
        else throw new Error("Descanso: Valor de número de semanas deve ser positivo");
    }

    /**
     * Verifica se a quantidade de horas descansadas é a ideal, baseado no atributo META_DESCANSO_SEMANAL
     * @return uma respresentação em string, "descansado" em caso afirmativo ou "cansado" caso contrário
     */
    public String getStatusGeral() {
        if(horasDescansadas == 0 || semanasDecorridas == 0) return "cansado";
        if((horasDescansadas/semanasDecorridas) >= META_DESCANSO_SEMANAL) return "descansado";
        return "cansado";
    }
}
