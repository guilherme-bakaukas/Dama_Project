package dama_package;

public class Tabuleiro {
    Peca[][] matriz=new Peca[8][8];
    static char colunas_tabuleiro[]={0,1,2,3,4,5,6,7};//utilizados para realizar a transformação de coordenada
    static char colunas[]={'a','b','c','d','e','f','g','h'};
    static char linhas_tabuleiro[]={0,1,2,3,4,5,6,7};
    static char linhas[]={'8','7','6','5','4','3','2','1'};

    Tabuleiro(){
        for (int linha=0;linha<8;linha++){
            for(int coluna=0;coluna<8;coluna++){
                switch(linha){
                    case 0:
                    case 2:
                        if ((coluna%2)!=0){
                            matriz[linha][coluna]=new Peca_comum('P');
                        }
                        break;
                    case 1:
                        if ((coluna%2)==0){
                            matriz[linha][coluna]=new Peca_comum ('P');
                        }
                        break;
                    case 5:
                    case 7:
                        if ((coluna%2)==0){
                            matriz[linha][coluna]=new Peca_comum('B');
                        }
                        break;
                    case 6:
                        if ((coluna%2)!=0){
                            matriz[linha][coluna]=new Peca_comum ('B');
                        }
                        break;
                }

            }
        }
    }

    public void deletar(int linha, int coluna){
        matriz[linha][coluna] = null;
    }

    public void print_tabuleiro(){
        for (int linha=0;linha<8;linha++){
            System.out.print((8-linha)+" ");
            for (int coluna=0;coluna<8;coluna++){
                if (matriz[linha][coluna]!=null){
                    if (matriz[linha][coluna].is_dama==true){
                        if (matriz[linha][coluna].equipe=='P') System.out.print("Q ");
                        if (matriz[linha][coluna].equipe=='B') System.out.print(("C "));
                    }
                    else System.out.print(matriz[linha][coluna].equipe+" ");
                }
                else System.out.print("- ");
            }
            System.out.println();
        }
        System.out.println("  a b c d e f g h ");
    }
    public void upgrade(char cor, int[] vetorPosicao){
        deletar(vetorPosicao[2], vetorPosicao[3]);
        Dama nova = new Dama(cor);
        matriz[vetorPosicao[2]][vetorPosicao[3]] = nova;

    }

    public int[] transformar_coordenadas(String jogada){
        int vetor_pos[]= new int[4];
        for (int i=0;i<8;i++){
            if (jogada.charAt(1)==linhas[i]) vetor_pos[0]=linhas_tabuleiro[i];//linha da posição inicial
            if (jogada.charAt(0)==colunas[i]) vetor_pos[1]=colunas_tabuleiro[i];//coluna da posição inicial
            if (jogada.charAt(4)==linhas[i]) vetor_pos[2]=linhas_tabuleiro[i];//linha do posição final
            if (jogada.charAt(3)==colunas[i]) vetor_pos[3]=colunas_tabuleiro[i];//coluna da posição final
        }
        return vetor_pos;
    }

    public void altera_posicao_norm(int[] vetor_pos) {
        int linha_inicial = vetor_pos[0];
        int coluna_inicial = vetor_pos[1];
        int linha_final = vetor_pos[2];
        int coluna_final = vetor_pos[3];

        if (matriz[linha_inicial][coluna_inicial] == null) {
            System.out.println("posição acessada é vazia");
        }
        else {
            if (matriz[linha_final][coluna_final] != null) {
                System.out.println("posição final do pino a ser movimentado está ocupada ");
            }
            else {
                matriz[linha_final][coluna_final] = matriz[linha_inicial][coluna_inicial];
                matriz[linha_inicial][coluna_inicial] = null;
                if (linha_final - linha_inicial > 1 || linha_final - linha_inicial < - 1 ) {

                    int linha_dead = (linha_final + linha_inicial) / 2;
                    int coluna_dead = (coluna_final + coluna_inicial) / 2;


                    matriz[linha_dead][coluna_dead] = null;
                }
            }


        }
    }
    public void altera_posicao_dama(int[] vetor_pos) {
        int linha_inicial = vetor_pos[0];
        int coluna_inicial = vetor_pos[1];
        int linha_final = vetor_pos[2];
        int coluna_final = vetor_pos[3];
        matriz[linha_final][coluna_final] = matriz[linha_inicial][coluna_inicial];
        matriz[linha_inicial][coluna_inicial] = null;

        int linha_dead;
        int coluna_dead;
        if (linha_final < linha_inicial & coluna_final < coluna_inicial){
            for (int i = 0 ; i < linha_inicial - linha_final ; i++){
                linha_dead = linha_inicial - i;
                coluna_dead = coluna_inicial - i;
                matriz[linha_dead][coluna_dead] = null;
            }
        }
        else if (linha_final < linha_inicial & coluna_final > coluna_inicial){
            for (int i = 0 ; i < linha_inicial - linha_final ; i++){
                linha_dead = linha_inicial - i;
                coluna_dead = coluna_inicial + i;
                matriz[linha_dead][coluna_dead] = null;
            }
        }
        else if (linha_final > linha_inicial & coluna_final < coluna_inicial){
            for (int i = 0 ; i < linha_final - linha_inicial ; i++){
                linha_dead = linha_inicial + i;
                coluna_dead = coluna_inicial - i;
                matriz[linha_dead][coluna_dead] = null;
            }
        }
        else{
            for (int i = 0 ; i < linha_final - linha_inicial ; i++){
                linha_dead = linha_inicial + i;
                coluna_dead = coluna_inicial + i;
                matriz[linha_dead][coluna_dead] = null;
            }
        }






    }
}



