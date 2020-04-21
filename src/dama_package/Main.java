package dama_package;

public class Main {
    public static void main(String[] args){
        Tabuleiro tab=new Tabuleiro();
        tab.print_tabuleiro();
        CSVReader csv = new CSVReader();
        csv.setDataSource("C:/Users/vitor/IdeaProjects/Dama_Project/src/dama_package/Data.csv");
        String commands[] = csv.requestCommands();
    }
}
