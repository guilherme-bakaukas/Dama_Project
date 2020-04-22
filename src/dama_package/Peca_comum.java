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

    public boolean verifica_captura(Peca[][] matriz, int[] vetor_pos){
        int linha_inicial = vetor_pos[0];
        int coluna_inicial = vetor_pos[1];
        int linha_final = vetor_pos[2];
        int coluna_final = vetor_pos[3];
        boolean verificadora=super.verifica_movimento(matriz,vetor_pos);
        if (verificadora==false) return false;
        else{
            int diferenca_linha=linha_final-linha_inicial;
            int diferenca_coluna=coluna_final-coluna_inicial;
            if (((diferenca_coluna!=2) & (diferenca_coluna!=-2))||((diferenca_linha!=2)&(diferenca_linha!=-2))){
                return false;
            }
            else{
                int linha_dead;
                int coluna_dead;
                if (linha_final>linha_inicial) linha_dead=linha_inicial+1;
                else linha_dead=linha_inicial-1;
                if (coluna_final>coluna_inicial) coluna_dead=coluna_inicial+1;
                else coluna_dead=coluna_inicial-1;
                if (matriz[linha_dead][coluna_dead].equipe!=this.equipe) return true;// se a peça for da equipe inimiga, deve ser possível realizar a captura
            }
        }
        return false;
    }
}
