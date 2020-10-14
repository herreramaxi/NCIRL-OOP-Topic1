/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangmangame;

import java.util.Random;

/**
 *
 * @author user
 */
public class RandomWordGenerator {

    private Random _random;

    //Generated from https://randomwordgenerator.com/
    private String[] _secretWords = {
        "dream",
         "friend",
         "wording",
         "crew",
         "norm",
         "admission",
         "hurt",
         "call",
         "moon",
         "movie",
         "row",
         "communist",
         "mail",
         "dance",
         "baseball",
         "shower",
         "metal",
         "rebellion",
         "tendency",
         "funeral",
         "herd",
         "roll",
         "card",
         "care",
         "shy",
         "suit",
         "harmful",
         "desire",
         "he",
         "toll",
         "flower",
         "mold",
         "failure",
         "deserve",
         "quit",
         "slide",
         "punch",
         "mystery",
         "diamond",
         "shatter",
         "perform",
         "sale",
         "spot",
         "cellar",
         "ivory",
         "contrast",
         "insist",
         "green",
         "margin",
         "recovery"};

    public RandomWordGenerator() {
        _random = new Random();
    }

    public String GetNextWord() {
        int randomIndex = _random.nextInt(_secretWords.length);
        return _secretWords[randomIndex];
    }
}
