package dama_package;

public class Peca {
    char equipe;
    int posso_continuar;
    boolean is_dama;
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

    public boolean verifica_captura(Peca[][] matriz, int[] vetor_pos) {
        int linha_inicial = vetor_pos[0];
        int coluna_inicial = vetor_pos[1];
        int linha_final = vetor_pos[2];
        int coluna_final = vetor_pos[3];
        return true;
    }

    public boolean movimento(Peca[][] matriz, int[] vetor_pos, Tabuleiro tab){
        if (verifica_captura(matriz, vetor_pos)){
            if (tab.matriz[vetor_pos[0]][vetor_pos[1]].is_dama){tab.altera_posicao_dama(vetor_pos);}
            else{tab.altera_posicao_norm(vetor_pos);}
            matriz[vetor_pos[2]][vetor_pos[3]].posso_continuar = 1;
            return true;
        }
        else if (verifica_movimento(matriz, vetor_pos)){
            if (tab.matriz[vetor_pos[0]][vetor_pos[1]].is_dama){tab.altera_posicao_dama(vetor_pos);}
            else{tab.altera_posicao_norm(vetor_pos);}
            matriz[vetor_pos[2]][vetor_pos[3]].posso_continuar = 0;
            return true;
        }
        else{
            return false;
        }


    }



}