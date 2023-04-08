public class Descanso {
    public final int META_DESCANSO_SEMANAL = 26;

    private int horasDescansadas = 0;
    private int semanasDecorridas = 0;

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

    public String getStatusGeral() {
        if(horasDescansadas == 0 || semanasDecorridas == 0) return "cansado";
        if((horasDescansadas/semanasDecorridas) >= META_DESCANSO_SEMANAL) return "descansado";
        return "cansado";
    }
}
