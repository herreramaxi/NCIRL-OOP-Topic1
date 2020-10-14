
import hangmangame.Engine.GuessResult;
import hangmangame.Engine.HangmanGameEngine;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class HangmanGameEngineTestCases {

    public HangmanGameEngineTestCases() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void WhenGuessingALetterTheAsteriskIsReplacedByIt() {
        HangmanGameEngine g = new HangmanGameEngine();
        g.setSecretWord("happiness");
        assertThat(g.getGuesses(), is(10));
        assertThat(g.getLives(), is(5));

        assertThat("*********", is(g.getGuessedWord()));
        assertThat(false, is(g.getHasGuessedTheWord()));

        GuessResult result = g.guessLetter('a');
        assertThat(false, is(g.getHasGuessedTheWord()));
        assertThat(result.getGuessedWord(), is("*a*******"));
        assertThat(g.getLives(), is(5));
        assertThat(g.getGuesses(), is(9));

        result = g.guessLetter('p');
        assertThat(false, is(g.getHasGuessedTheWord()));
        assertThat(result.getGuessedWord(), is("*app*****"));
        assertThat(g.getLives(), is(5));
        assertThat(g.getGuesses(), is(8));

        result = g.guessLetter('s');
        assertThat(false, is(g.getHasGuessedTheWord()));
        assertThat(result.getGuessedWord(), is("*app***ss"));
        assertThat(g.getLives(), is(5));
        assertThat(g.getGuesses(), is(7));

        result = g.guessLetter('e');
        assertThat(false, is(g.getHasGuessedTheWord()));
        assertThat(result.getGuessedWord(), is("*app**ess"));
        assertThat(g.getLives(), is(5));
        assertThat(g.getGuesses(), is(6));

        result = g.guessLetter('i');
        assertThat(false, is(g.getHasGuessedTheWord()));
        assertThat(result.getGuessedWord(), is("*appi*ess"));
        assertThat(g.getLives(), is(5));
        assertThat(g.getGuesses(), is(5));

        result = g.guessLetter('n');
        assertThat(false, is(g.getHasGuessedTheWord()));
        assertThat(result.getGuessedWord(), is("*appiness"));
        assertThat(g.getLives(), is(5));
        assertThat(g.getGuesses(), is(4));

        result = g.guessLetter('h');
        assertThat(true, is(g.getHasGuessedTheWord()));
        assertThat(result.getGuessedWord(), is("happiness"));
        assertThat(g.getLives(), is(5));
        assertThat(g.getGuesses(), is(3));
    }

    @Test
    public void WhenFailingOnGuessingALetterNoAsteriskIsReplaced(){
        HangmanGameEngine g = new HangmanGameEngine();
        g.setSecretWord("thoughtful");
        assertThat(g.getGuesses(), is(10));
        assertThat(g.getLives(), is(5));

        assertThat(false, is(g.getHasGuessedTheWord()));
        assertThat("**********", is(g.getGuessedWord()));

        GuessResult result = g.guessLetter('z');
        assertThat(false, is(g.getHasGuessedTheWord()));
        assertThat(result.getGuessedWord(), is("**********"));
        assertThat(g.getLives(), is(4));
        assertThat(g.getGuesses(), is(9));

        result = g.guessLetter('y');
        assertThat(false, is(g.getHasGuessedTheWord()));
        assertThat(result.getGuessedWord(), is("**********"));
        assertThat(g.getLives(), is(3));
        assertThat(g.getGuesses(), is(8));

        result = g.guessLetter('x');
        assertThat(false, is(g.getHasGuessedTheWord()));
        assertThat(result.getGuessedWord(), is("**********"));
        assertThat(g.getLives(), is(2));
        assertThat(g.getGuesses(), is(7));

        result = g.guessLetter('w');
        assertThat(false, is(g.getHasGuessedTheWord()));
        assertThat(result.getGuessedWord(), is("**********"));
        assertThat(g.getLives(), is(1));
        assertThat(g.getGuesses(), is(6));

        result = g.guessLetter('a');
        assertThat(false, is(g.getHasGuessedTheWord()));
        assertThat(result.getGuessedWord(), is("**********"));
        assertThat(g.getLives(), is(0));
        assertThat(g.getGuesses(), is(5));
    }

//    @Test
//    public void WhenGuessingTheSecretWordTheGameStops() {
//        HangmanGameEngine g = new HangmanGameEngine();
//        g.setSecretWord("sun");
//        assertThat(g.getGuesses(), is(10));
//        assertThat(g.getLives(), is(5));
//
//        assertThat(false, is(g.getHasGuessedTheWord()));
//        assertThat("***", is(g.getGuessedWord()));
//
//        String result = g.guessLetter('s');
//        assertThat(false, is(g.getHasGuessedTheWord()));
//        assertThat(result, is("s**"));
//        assertThat(g.getLives(), is(5));
//        assertThat(g.getGuesses(), is(9));
//
//        result = g.guessLetter('n');
//        assertThat(false, is(g.getHasGuessedTheWord()));
//        assertThat(result, is("s*n"));
//        assertThat(g.getLives(), is(5));
//        assertThat(g.getGuesses(), is(8));
//
//        result = g.guessLetter('s');
//        assertThat(true, is(g.getHasGuessedTheWord()));
//        assertThat(result, is("sun"));
//        assertThat(g.getLives(), is(5));
//        assertThat(g.getGuesses(), is(7));
//          
//        
//        
//        
//        
//             result = g.guessLetter('a');
//        
//        assertThat(true, is(g.getHasGuessedTheWord()));
//        assertThat(result, is("sun"));
//        assertThat(g.getLives(), is(5));
//        assertThat(g.getGuesses(), is(7));
//    }
}
