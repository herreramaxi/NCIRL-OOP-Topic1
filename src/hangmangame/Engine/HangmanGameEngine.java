/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangmangame.Engine;

import hangmangame.Interfaces.IObserver;
import hangmangame.Interfaces.ISubject;
import java.util.ArrayList;

/**
 *
 * @author Maximiliano Herrera
 */
public class HangmanGameEngine implements ISubject {

    private String _charactersEntered;
    private String _secretWord;
    private String _guessedWord;
    private int _lives;
    private int _guesses;
    private Boolean _hasGuessedTheWord;
    private Boolean _initialized;
    private final ArrayList<IObserver> _observers = new ArrayList<>();

    public int getLives() {
        return _lives;
    }

    public int getGuesses() {
        return _guesses;
    }

    public Boolean getHasGuessedTheWord() {
        return _hasGuessedTheWord;
    }

    public String getGuessedWord() {
        return _guessedWord;
    }

    public boolean getIsGameOver() {
        return this.getHasGuessedTheWord() || this.getLives() == 0 || this.getGuesses() == 0;
    }

    public HangmanGameEngine() {
        _charactersEntered = null;
        _guessedWord = null;
        _secretWord = null;
        _lives = 0;
        _guesses = 0;
        _hasGuessedTheWord = false;
        _initialized = false;
    }

    public void setSecretWord(String secretWord) throws IllegalArgumentException {
        if (secretWord == null) {
            throw new IllegalArgumentException("Secret word parameter is null");
        }
        _secretWord = secretWord;
        _guessedWord = "";
        _charactersEntered = "";

        for (int i = 0; i < _secretWord.length(); i++) {
            _guessedWord += "*";
        }

        _lives = 5;
        _guesses = 10;
        _hasGuessedTheWord = false;
        _initialized = true;

        this.Notify();
    }

    public GuessResult guessLetter(Character character) {
        String characterAsString = character.toString().toLowerCase();

        try {
            if (!_initialized) {
                return GuessResult.BuildFailed("Game not initialized", this, true);
            }

            if (_lives == 0) {
                return GuessResult.BuildFailed("There are no remaining lives", this, true);
            }

            if (_guesses == 0) {
                return GuessResult.BuildFailed("There are no remaining guesses", this, true);
            }

            if (_charactersEntered.contains(characterAsString)) {
                return GuessResult.BuildFailed("Character already entered: " + characterAsString, this);
            }

            _charactersEntered += characterAsString;
            _guesses--;

            if (_secretWord.contains(characterAsString)) {
                StringBuilder sb = new StringBuilder(_guessedWord);

                char c = characterAsString.charAt(0);
                for (int i = 0; i < _secretWord.length(); i++) {
                    if (_secretWord.charAt(i) == c) {
                        sb.setCharAt(i, c);
                    }
                }

                _guessedWord = sb.toString();
            } else {
                _lives--;
            }

            _hasGuessedTheWord = !_guessedWord.contains("*");

            String errorMessage = "";
            if (_lives == 0 || _guesses == 0) {
                errorMessage = _lives == 0 ? "There are no remaining lives" : "There are no remaining guesses";
            }

            this.Notify();
            return GuessResult.BuildSuccessFul(this).SetErrorMessage(errorMessage);

        } catch (Exception exception) {
            //log.Error("There was an error when trying to guess the word", exception);
            return GuessResult.BuildFailed("There was an error when trying to guess the word. Character entered: " + characterAsString, this, true);
        }
    }

    @Override
    public void Attach(IObserver observer) {
        _observers.add(observer);
    }

    @Override
    public void Notify() {
        for (IObserver observer : _observers) {
            observer.update();
        }
    }
}
