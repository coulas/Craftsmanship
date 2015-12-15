## Bowling Game
[From Uncle Bob himself](http://butunclebob.com/ArticleS.UncleBob.TheBowlingGameKata) author of clean code and source of enlightenment for many of us ;-)

Write a program to score a game of Ten-Pin Bowling.

<table>
<tr><td>knocked down pins</td><td>1 | 4</td><td>4 | 5</td><td>6 | /</td><td>5 | /</td><td>X</td><td>0 | 1</td><td>7 | /</td><td>6 | /</td><td>X</td><td>2 | / || 6</td></tr>
<tr><td>score</td><td>5</td><td>14</td><td>29</td><td>49</td><td>60</td><td>61</td><td>77</td><td>97</td><td>117</td><td>133</td></tr>
</table>

The game consists of 10 frames as shown above.  In each frame the player has
two opportunities to knock down 10 pins.  The score for the frame is the total
number of pins knocked down, plus bonuses for strikes and spares.

A spare is when the player knocks down all 10 pins in two tries.  The bonus for
that frame is the number of pins knocked down by the next roll.  So in frame 3
above, the score is 10 (the total number knocked down) plus a bonus of 5 (the
number of pins knocked down on the next roll.)

A strike is when the player knocks down all 10 pins on his first try.  The bonus
for that frame is the value of the next two balls rolled.

In the tenth frame a player who rolls a spare or strike is allowed to roll the extra
balls to complete the frame.  However no more than three balls can be rolled in
tenth frame.

1. Write a class named “Game” that has two methods
    - roll(pins : int) is called each time the player rolls a ball.  The argument is the number of pins knocked down.
    - score() : int is called only at the very end of the game.  It returns the total score for that game.

Examples:

* X indicates a strike
* / indicates a spare
* \- indicates a miss
* | indicates a frame boundary
* The characters after the || indicate bonus balls

X|X|X|X|X|X|X|X|X|X||XX

Ten strikes on the first ball of all ten frames.
Two bonus balls, both strikes.
Score for each frame == 10 + score for next two 
balls == 10 + 10 + 10 == 30
Total score == 10 frames x 30 == 300


9-|9-|9-|9-|9-|9-|9-|9-|9-|9-||

Nine pins hit on the first ball of all ten frames.
Second ball of each frame misses last remaining pin.
No bonus balls.
Score for each frame == 9
Total score == 10 frames x 9 == 90


5/|5/|5/|5/|5/|5/|5/|5/|5/|5/||5

Five pins on the first ball of all ten frames.
Second ball of each frame hits all five remaining
pins, a spare.
One bonus ball, hits five pins.
Score for each frame == 10 + score for next one
ball == 10 + 5 == 15
Total score == 10 frames x 15 == 150


X|7/|9-|X|-8|8/|-6|X|X|X||81

Total score == 167
