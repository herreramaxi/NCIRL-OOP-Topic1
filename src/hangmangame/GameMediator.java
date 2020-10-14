/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangmangame;

import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author Maximiliano Herrera
 */
public class GameMediator {

    static final String EMPTY_STRING = "";
    ;    private HangmanGameEngine _gameEngine;
    private RandomWordGenerator _wordGenerator;
    private MainJFrame _mainFrame;
    private JTextField _guessedWordControl;
    private JTextField _livesControl;
    private JTextField _guessesControl;
    private JButton _buttonStartControl;

    GameMediator() {
        _gameEngine = new HangmanGameEngine();
        _wordGenerator = new RandomWordGenerator();
    }

    void SetInitialState() {
        _buttonStartControl.setEnabled(true);
        _mainFrame.DisableKeyboard();

        _livesControl.setText(EMPTY_STRING);
        _guessesControl.setText(EMPTY_STRING);
        _guessedWordControl.setText(EMPTY_STRING);
    }

    GuessResult GuessLetter(Character c) {
        GuessResult result = _gameEngine.guessLetter(c);

        this.UpdateControls();

        if (result.getIsGameOver()) {

            if (result.getHasGuessedTheWord()) {
                _mainFrame.ShowMessageDialog("Congratulations, you win!");

            } else if (result.getIsGameOver()) {
                _mainFrame.ShowMessageDialog("Game over...");
            }

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
