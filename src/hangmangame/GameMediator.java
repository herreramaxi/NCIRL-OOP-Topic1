/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangmangame;

import hangmangame.Engine.HangmanGameEngine;
import hangmangame.Interfaces.IObserver;
import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author Maximiliano Herrera
 */
public class GameMediator implements IObserver {

    static final String EMPTY_STRING = "";
    private final HangmanGameEngine _gameEngine;
    private final RandomWordGenerator _wordGenerator;
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

    public void GuessLetter(Character c) {
        _gameEngine.guessLetter(c);
    }

    void Start() {
        _gameEngine.setSecretWord(_wordGenerator.GetNextWord());
        _mainFrame.EnableKeyboard();
        _buttonStartControl.setEnabled(false);
    }

    void AttachGuessedWordControl(JTextField guessedWordControl) {
        UIComponentObserver guessedWordObserver = new UIComponentObserver(() -> {
            guessedWordControl.setText(String.valueOf(_gameEngine.getGuessedWord()));
        });

        _guessedWordControl = guessedWordControl;
        _gameEngine.Attach(guessedWordObserver);   
    }

    void AttachLivesControl(JTextField livesControl) {
        UIComponentObserver livesObserver = new UIComponentObserver(() -> {
            livesControl.setText(String.valueOf(_gameEngine.getLives()));
        });

        _gameEngine.Attach(livesObserver);
        _livesControl = livesControl;
    }

    void AttachGuessesControl(JTextField guessesControl) {
        UIComponentObserver guessesObserver = new UIComponentObserver(() -> {
            guessesControl.setText(String.valueOf(_gameEngine.getGuesses()));
        });

        _gameEngine.Attach(guessesObserver);
        _guessesControl = guessesControl;
    }

    void AttachStartButton(JButton buttonStartControl) {
        _buttonStartControl = buttonStartControl;
    }

    void AttachMainFrame(MainJFrame mainFrame) {
        _mainFrame = mainFrame;
        _gameEngine.Attach(this);
    }

    @Override
    public void update() {

        if (_gameEngine.getIsGameOver()) {

            if (_gameEngine.getHasGuessedTheWord()) {
                _mainFrame.ShowMessageDialog("Congratulations, you win!");

            } else if (_gameEngine.getIsGameOver()) {
                _mainFrame.ShowMessageDialog("Game over...");
            }

            this.SetInitialState();
        }
    }
}
