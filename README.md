# NCIRL-OOP-Topic1
## Topic 1: Revision 

Develop an application that allows the user to play a Hangman game.  The game should store a secret word (which you can choose and hard code in to a variable) and allow the user to guess the word one letter at a time.  The game should begin by printing a * for every letter in the word. When the user guesses a letter correctly, that letter should replace the appropriate * and the updated string should be printed to the user.   

For example, if the secret word is house, the application first prints *****     and when the user guesses the letter o the output should be *o***. 

## Additional functionality 

* Add the following functionality to your application: (complete each feature before moving on to the next) 

* Add functionality to the app to allow the user to guess a letter 10 times and give the appropriate output each time 

* Add further functionality to check if the user has guessed the word completely.  If they have, stop allowing guesses and output a message “Congratulations, you win!”.  If they have not guessed the full word correctly, continue playing the game until they reach 10 guesses 

* Give the user an instruction at the start of the game to inform them that they have 5 lives.  Each time they guess a letter which is not present in the word one life is lost.  When all lives have gone, the game should end 

* Finally, modify the application so that when the game ends the user is asked would they like to play again. At this point, a new secret word should be chosen and the lives and guesses reset to 5 and 10 

  
