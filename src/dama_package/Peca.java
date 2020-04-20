package dama_package;

public class Peca {
    char equipe;
    Peca(char nome){
        if (nome=='P') this.equipe='P';
        else if (nome=='B') this.equipe = 'B';
    }
}
