package br.inatel.cdg.model;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Principal {
    public static void main(String[] args) {
        List<Jogo> listaJogo = new ArrayList<>();

        Reader reader = null;
        try {
            reader = Files.newBufferedReader(Paths.get("vendas-games.csv"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        CsvToBean<Jogo> csvToBean = new CsvToBeanBuilder(reader)
                .withType(Jogo.class)
                .withIgnoreLeadingWhiteSpace(true)
                .build();
        listaJogo = csvToBean.parse();
    }

}
public class ServiceGame {

    public static List<Jogo> getListByPlatform(List<Jogo> jogos, Jogo platform){
        List<Jogo> gamesByPlatform = new ArrayList<>();

        Jogos.stream().filter((game ->
                        game.getPlatform().equals(platform.name()))).
                forEach(game -> gamesByPlatform.add(game));

        return gamesByPlatform;

    }


    public static List<Game> getByPuBlisher(List<Game> games ,
                                            Publisher publisher){
        List<Game> gamesByPublisher = new ArrayList<>();

        games.stream().filter((game ->
                        game.getPublisher().replaceAll("\\s+", "").equals(publisher.name()))).
                forEach(game -> gamesByPublisher.add(game));

        return gamesByPublisher;
    }
