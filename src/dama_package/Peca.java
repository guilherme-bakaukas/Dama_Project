package dama_package;

public class Peca {
    char equipe;
    Peca(char nome){
        if (nome=='P') this.equipe='P';
        else if (nome=='B') this.equipe = 'B';
    }

    public boolean verifica_movimento(Peca[][] matriz, int[] vetor_pos) {
        int linha_inicial=vetor_pos[0];
        int coluna_inicial=vetor_pos[1];
        int linha_final=vetor_pos[2];
        int coluna_final=vetor_pos[3];
        if (matriz[linha_final][coluna_final] == null) {
            return true;
        }
        else return false;//posição está ocupada
    }

}
