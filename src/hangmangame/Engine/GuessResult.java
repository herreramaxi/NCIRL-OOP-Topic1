/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangmangame.Engine;

/**
 *
 * @author Maximiliano Herrera
 */
public class GuessResult {

    private String _guessedWord;
    private int _remainingLives;
    private int _remainingGuesses;
    private ResultType _resultType;
    private String _errorMessage;
    private boolean _hasGuessedTheWord;
    private boolean _isGameOver;

    public String getGuessedWord() {
        return _guessedWord;
    }

    public int getRemainingLives() {
        return _remainingLives;
    }

    public int getRemainingGuesses() {
        return _remainingGuesses;
    }

    public ResultType getResultType() {
        return _resultType;
    }

    public String getErrorMessage() {
        return _errorMessage;
    }

    public boolean getHasGuessedTheWord() {
        return _hasGuessedTheWord;
    }

    public boolean getIsGameOver() {
        return _isGameOver;
    }

    static GuessResult BuildFailed(String errorMessage, HangmanGameEngine engine) {
        GuessResult result = new GuessResult(ResultType.Failed,
                errorMessage,
                engine.getLives(),
                engine.getGuesses(),
                engine.getGuessedWord(),
                engine.getHasGuessedTheWord(),
                false);

        return result;
    }

    static GuessResult BuildFailed(String errorMessage, HangmanGameEngine engine, boolean isGameOver) {
        GuessResult result = new GuessResult(ResultType.Failed,
                errorMessage,
                engine.getLives(),
                engine.getGuesses(),
                engine.getGuessedWord(),
                engine.getHasGuessedTheWord(),
                isGameOver);

        return result;
    }

    static GuessResult BuildSuccessFul(HangmanGameEngine engine) {
     
        GuessResult result = new GuessResult(ResultType.Successful,
                null,
                engine.getLives(),
                engine.getGuesses(),
                engine.getGuessedWord(),
                engine.getHasGuessedTheWord(),
                engine.getHasGuessedTheWord() || engine.getLives() == 0 || engine.getGuesses() == 0);

        return result;
    }
    
    public GuessResult SetErrorMessage(String errorMessage){
        _errorMessage = errorMessage;
        
        return this;
    }
    
    private GuessResult(ResultType resultType, String errorMessage, int lives, int guesses, String guessedWord, Boolean hasGuessedTheWord, boolean isGameOver) {

        _resultType = resultType;
        _errorMessage = errorMessage;
        _remainingLives = lives;
        _remainingGuesses = guesses;
        _guessedWord = guessedWord;
        _hasGuessedTheWord = hasGuessedTheWord;
        _isGameOver = isGameOver;
    }
}
