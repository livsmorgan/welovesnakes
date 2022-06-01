# Computer Science Quarter 4 Final: Snake Game
Developers: Chhaya Maurya and Liv Morgan
### Game Description
This game is derived from the Google snake game. In this snake game, the user attempts to control the snake and collect food. For every food obtained, the score increases by 1 and the snake's body length increases by 1 as well. The snake can "eat" the food when the two objects collide. The game is over if the snake collides with either the walls of the game or its own body. <br>
![ezgif com-gif-maker (4)](https://user-images.githubusercontent.com/89156607/171342616-36c2ef21-8c84-4183-b602-7db5228619c4.gif)
<img width="320" alt="snakeGame" src="https://user-images.githubusercontent.com/89156607/171342742-df502455-006f-4c84-a2fd-84d22c4fcba4.png"> <br>

### Usage / Game Play
wasd keys or arrow keys: controls the direction of the snake(up, down, left, right) <br>
space bar: start the snake game <br>
return/enter key: holdd down to display instructions panel for snake game <br>
number keys(1, 2, 3): adjusts the speed of the snake(1: fast, 2: normal, 3: slow) <br>
plus and minus sign keys: increase or decrease the size of the board <br>
delete: reset all the settings back to default <br>
### Classes
#### Background
In this class, we created the checkerboard pattern for the game board, using fillRect to make the square in light purple and a darker light purple color. We used for loops to code the alternating colored blocks with fillRect. <br>
<img width="300" alt="backgroundnoncode" src="https://user-images.githubusercontent.com/89156607/171343711-c7a63c96-421a-41d6-b740-75fd15cf451c.png"> 
<img width="340" alt="backgroundsnake" src="https://user-images.githubusercontent.com/89156607/171343870-94d74c34-19dd-4c61-bef0-a9943d64f97f.png"> 


#### Frame
<br>
Majority of the action is going on in the frame. This has all of the methods needed to play the game. It also invokes the creation of the snake and the of the food.
We have also included the instructions on how to play the game in this class as well as the method for painting the objects.




