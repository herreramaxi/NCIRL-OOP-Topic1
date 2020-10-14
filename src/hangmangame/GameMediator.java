/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangmangame;

import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author user
 */
public class GameMediator {

    private final String _emptyString;
    private HangmanGameEngine _gameEngine;
    private RandomWordGenerator _wordGenerator;
    private MainJFrame _mainFrame;
    private JTextField _guessedWordControl;
    private JTextField _livesControl;
    private JTextField _guessesControl;
    private JButton _buttonStartControl;

    GameMediator() {
        this._emptyString = "         ";
        _gameEngine = new HangmanGameEngine();
        _wordGenerator = new RandomWordGenerator();
    }

    public void DisableComponents() {
        _buttonStartControl.setEnabled(false);
        _mainFrame.DisableKeyboard();
    }

    void SetInitialState() {
        _buttonStartControl.setEnabled(true);
        _mainFrame.DisableKeyboard();

        _livesControl.setText(_emptyString);
        _guessesControl.setText(_emptyString);
        _guessedWordControl.setText(_emptyString);
    }

    GuessResult GuessLetter(Character c) {
        GuessResult result = _gameEngine.guessLetter(c);

        this.UpdateControls();
        if (result.getHasGuessedTheWord()) {

            _mainFrame.ShowMessageDialog("Congratulations, you win!");
            this.SetInitialState();
        } else if (result.getIsGameOver()) {
            _mainFrame.ShowMessageDialog("Game over...");
            this.SetInitialState();
        }
        return result;
    }

    void Start() {
        _gameEngine.setSecretWord(_wordGenerator.GetNextWord());
        _mainFrame.EnableKeyboard();
        _buttonStartControl.setEnabled(false);

        UpdateControls();
    }

    public void UpdateControls() {
        _livesControl.setText(String.valueOf(_gameEngine.getLives()));
        _guessesControl.setText(String.valueOf(_gameEngine.getGuesses()));
        _guessedWordControl.setText(String.valueOf(_gameEngine.getGuessedWord()));
    }    

//
//    public void Play() {
//
//        try {
//            while (InicializeOrContinueGame()) {
//                InformUserLivesAndGuesses();
//
//                GuessResult result = this.AskUserForALetter();
//
//                while (!result.getIsGameOver() && !result.getHasGuessedTheWord()) {
//                    InformUserWordGuessed(result);
//                    result = this.AskUserForALetter();
//                }
//
//                InformUserGameResult(result);
//            }
//        } catch (Exception e) {
//            //log.Error("Unexpected error when running the game", e);
//            System.out.println("Unexpected error when running the game");
//        }
//    }
    
//    private GuessResult AskUserForALetter() {
//        System.out.println("Please guess a letter:");
//        char character = _scanner.next().charAt(0);
//        return _gameEngine.guessLetter(character);
//    }
//
//    private void InformUserWordGuessed(GuessResult result) {
//
//        if (result.getResultType() == ResultType.Successful) {
//            System.out.println(result.getGuessedWord());
//            System.out.println("Lives availables: " + _gameEngine.getLives() + ", guesses availables: " + _gameEngine.getGuesses());
//        } else {
//            System.out.println(result.getErrorMessage() + ", please try again");
//        }
//    }
//
//    private void InformUserLivesAndGuesses() {
//        System.out.println("Lives availables: " + _gameEngine.getLives() + ", guesses availables: " + _gameEngine.getGuesses());
//        System.out.println("Word to be guessed: " + _gameEngine.getGuessedWord());
//    }
//
//    private void InformUserGameResult(GuessResult result) {
//        if (result.getHasGuessedTheWord()) {
//            System.out.println("Congratulations, you win!");
//        } else {
//            System.out.println("Game over: " + result.getErrorMessage());
//        }
//    }

    void AttachGuessedWordControl(JTextField guessedWordControl) {
        _guessedWordControl = guessedWordControl;
    }

    void AttachLivesControl(JTextField livesControl) {
        _livesControl = livesControl;
    }

    void AttachGuessesControl(JTextField guessesControl) {
        _guessesControl = guessesControl;
    }

    void AttachStartButton(JButton buttonStartControl) {
        _buttonStartControl = buttonStartControl;
    }

    void AttachMainFrame(MainJFrame mainFrame) {
        _mainFrame = mainFrame;
    }

}
