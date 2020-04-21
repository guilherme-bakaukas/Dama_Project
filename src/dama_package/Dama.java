package dama_package;

public class Dama extends Peca {
    Dama(char nome){
        super(nome);
    }

    public boolean verifica_movimento(Peca[][] matriz,int[] vetor_pos){
        int linha_inicial=vetor_pos[0];
        int coluna_inicial=vetor_pos[1];
        int linha_final=vetor_pos[2];
        int coluna_final=vetor_pos[3];
        boolean verificadora=false;
        verificadora=super.verifica_movimento(matriz,vetor_pos);
        if (verificadora==false) return false;
        else{
            int incremento_linha=-1;
            int incremento_coluna=-1;
            if (coluna_inicial<coluna_final) incremento_coluna=1;
            if (linha_inicial<linha_final) incremento_linha=1;
            int linha= linha_inicial;
            int coluna= coluna_inicial;
            while((linha!=linha_final)&(coluna!=coluna_final)){
                linha=linha+incremento_linha;
                coluna=coluna+incremento_coluna;
                if (matriz[linha][coluna]!=null) return false;
        }
            //essa condição abrange apenas o caso de movimentção e não o caso de captura de peças
    }
        return true;
}
}
