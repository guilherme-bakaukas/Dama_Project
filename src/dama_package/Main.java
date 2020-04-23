package dama_package;

public class Main {
    public static void main(String[] args){
        Tabuleiro tab=new Tabuleiro();
        System.out.println("Estado inicial:");
        tab.print_tabuleiro();
        System.out.println();
        System.out.println();
        CSVReader csv = new CSVReader();
        csv.setDataSource("C:/Users/vitor/IdeaProjects/Dama_Project/src/dama_package/Data.csv");
        String commands[] = csv.requestCommands();
        char vez = 'B';

        int tamanho = commands.length;
        for (int i = 0 ; i < tamanho ; i++ ){
            System.out.println("   Source: " + commands[i].charAt(0)+ commands[i].charAt(1));
            System.out.println("   Target: " + commands[i].charAt(3)+ commands[i].charAt(4));
            int atual[] = tab.transformar_coordenadas(commands[i]);
            if(vez == tab.matriz[atual[0]][atual[1]].equipe & tab.matriz[atual[0]][atual[1]] != null ){
                Peca patual = tab.matriz[atual[0]][atual[1]];
                patual.movimento(tab.matriz, atual, tab);
                if (patual.equipe == 'B' && !patual.is_dama){
                    if(atual[2] == 0){
                        tab.upgrade('B',atual);
                        patual.posso_continuar = 0;
                    }
                }
                else if (patual.equipe == 'P' && !patual.is_dama){
                    if(atual[2] == 7){
                        tab.upgrade('P',atual);
                        patual.posso_continuar = 0;
                    }
                }
                patual = tab.matriz[atual[2]][atual[3]];
                while(patual.posso_continuar == 1){
                    if(patual.verifica_captura(tab.matriz,atual)){
                        i++;
                        atual = tab.transformar_coordenadas(commands[i]);
                        patual = tab.matriz[atual[0]][atual[1]];
                        patual.movimento(tab.matriz, atual, tab);
                        if (patual.equipe == 'B' && !patual.is_dama){
                            if(atual[2] == 0){
                                tab.upgrade('B',atual);
                                patual.posso_continuar = 0;
                            }
                        }
                        else if (patual.equipe == 'P' && !patual.is_dama){
                            if(atual[2] == 7){
                                tab.upgrade('P',atual);
                                patual.posso_continuar = 0;
                            }
                        }
                    }
                    else{
                        patual.posso_continuar = 0;
                    }

                }
                if(vez == 'B'){
                    vez = 'P';
                }
                else{
                    vez = 'B';
                }
            }
            tab.print_tabuleiro();
            System.out.println();
            System.out.println();

        }
    }
}
