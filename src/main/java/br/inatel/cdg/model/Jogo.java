package br.inatel.cdg.model;

import lombok.Data;

@Data

public class Jogo {
    private int rank;
    private String name;
    private String platform;
    private int year;
    private String genre;
    private String publisher;
    private double na_sales;
    private double eu_sales;
    private double jp_sales;
    private double outher_sales;
    private double global_sales;
}
