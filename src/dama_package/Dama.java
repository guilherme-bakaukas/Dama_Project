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
        int diferenca_linha=linha_final-linha_inicial;
        int diferenca_coluna=coluna_final-coluna_inicial;

        if ((diferenca_coluna!=diferenca_linha)&(diferenca_coluna!=((-1)*diferenca_linha))) return false;// caso as posições não estejam na diagonal retornar falso

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

    public int[] verifica_captura(Peca[][] matriz, int[] vetor_pos){

        int[] vetor={-1,-1};
        int linha_dead=-1;
        int coluna_dead=-1;

        int linha_inicial=vetor_pos[0];
        int coluna_inicial=vetor_pos[1];
        int linha_final=vetor_pos[2];
        int coluna_final=vetor_pos[3];
        int diferenca_linha=linha_final-linha_inicial;

        int diferenca_coluna=coluna_final-coluna_inicial;

        if ((diferenca_coluna!=diferenca_linha)&(diferenca_coluna!=((-1)*diferenca_linha))) return vetor;// caso as posições não estejam na diagonal retornar falso

        if (matriz[linha_final][coluna_final]!=null) return vetor;

        else{
            int incremento_linha=-1;
            int incremento_coluna=-1;
            if (coluna_inicial<coluna_final) incremento_coluna=1;
            if (linha_inicial<linha_final) incremento_linha=1;
            int linha= linha_inicial;
            int coluna= coluna_inicial;
            int count=0;// serve para contabilizar o numero de peças no meio do caminho da dama

            while((linha!=linha_final)&(coluna!=coluna_final)){
                linha=linha+incremento_linha;
                coluna=coluna+incremento_coluna;
                if (matriz[linha][coluna]!=null){

                    count++;
                    linha_dead=linha;//guardar as posições do elemento a ser capturado
                    coluna_dead=coluna;

                    if (matriz[linha][coluna].equipe==this.equipe) {
                        return vetor;// caso seja da mesma equipe n deve capturar
                    }
                    else{
                        if (matriz[linha+incremento_linha][coluna+incremento_coluna]!=null) return vetor;//caso não haja uma casa livre após a peça n deve haver captura
                    }
                }
            }
            if (count>1) return vetor;// se houver mais de uma peça no percurso, n deve ser feita a captura

        }
        vetor[0]=linha_dead;
        vetor[1]=coluna_dead;
        return vetor;
    }
}