package dama_package;

public class Peca_comum extends Peca {
    Peca_comum(char nome) {
        super(nome);
    }

    public boolean verifica_movimento(Peca[][] matriz, int[] vetor_pos) {
        int linha_inicial = vetor_pos[0];
        int coluna_inicial = vetor_pos[1];
        int linha_final = vetor_pos[2];
        int coluna_final = vetor_pos[3];
        boolean verificadora = false;
        verificadora = super.verifica_movimento(matriz, vetor_pos);
        if (verificadora == false) return false;
        else if ((linha_final - linha_inicial == 1) & ((coluna_final - coluna_inicial == 1) || (coluna_final - coluna_inicial == -1))) {
            //essa condição abrange apenas o caso de movimentação não de captura
            return true;
        }
        return false;
    }
}
