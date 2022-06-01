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
<img width="340" alt="backgroundsnake" src="https://user-images.githubusercontent.com/89156607/171343870-94d74c34-19dd-4c61-bef0-a9943d64f97f.png"> <br>
#### Frame
The majority of the action is going on in the frame. This has all of the methods needed to play the game. It also invokes the creation of the snake and the creation of the food. <br>
##### Snake
The snake is created when the boolean variable, playing, is true. The snake is created using for loops which encode the fillRect squares to make the snake's head and snake's length. The colors between the head and the body of the snake are deffering. <br>
<img width="500" alt="Screen Shot 2022-06-01 at 12 04 09 AM" src="https://user-images.githubusercontent.com/89156607/171346917-c975c58f-cf71-4fe4-b894-58e755c57c3e.png"> <br>
##### Food
The food is just a circle that is created when the game is running. When the snake collides with the food, the score and snake's body length each increases by 1.  <br>
<img width="90" alt="Screen Shot 2022-06-01 at 10 03 46 AM" src="https://user-images.githubusercontent.com/89156607/171460592-2140503f-4efe-4899-97cf-9b91499e3d68.png"> 
<img width="500" alt="Screen Shot 2022-06-01 at 12 03 58 AM" src="https://user-images.githubusercontent.com/89156607/171346885-2e1447ad-fec9-40e3-95cf-c9c4817c33dc.png"> <br>
###### Randomization of the Food
This causes the food to randomize on another location on the 2 1d arrays and set an circle for food in a block. This occurs after the snake has collided with a food. <br>
<img width="500" alt="Screen Shot 2022-06-01 at 12 03 41 AM" src="https://user-images.githubusercontent.com/89156607/171346833-5270e7f7-b31d-4b6d-a335-a5395b1c2dec.png"> <br>
##### Display Panel
This was created to help the users understand how the game works and how to play the game. When the user holds down on the enter/return key, the instructions appear. <br>
<img width="500" alt="Screen Shot 2022-06-01 at 12 03 28 AM" src="https://user-images.githubusercontent.com/89156607/171346810-76431ecb-7035-43c7-a4e3-f5cce20e1045.png"> <br>
##### Run 
The snake is able to move through this run method and a timer is what actually invokes the movement of the snake. However, the changes in directions for the snake are induced by switch-case statements. <br>
<img width="500" alt="Screen Shot 2022-05-31 at 11 59 03 PM" src="https://user-images.githubusercontent.com/89156607/171346092-0f53dd8b-6713-4bb4-b738-702731ef7c4b.png"> <br>
Using switch-case statements with the key codes give the user the opoortunites to change the direction of the snkae through either the arrow keys or the wasd keys. <br>
<img width="500" alt="Screen Shot 2022-05-31 at 10 58 50 PM" src="https://user-images.githubusercontent.com/89156607/171345791-33a7fda3-5920-4777-af0a-75cb6807735a.png"> <br>
##### Collision
###### Collision Between Snake and Food
When the snake collids with the food, then the snake's body length increases by 1 and the score increass by 1 as well. As soon as the snake collids, the food is randomzied to another location on the 2 1d array boards. <br>
<img width="500" alt="Screen Shot 2022-05-31 at 11 58 12 PM" src="https://user-images.githubusercontent.com/89156607/171345959-4b057c74-679c-43e2-87d3-672e9883b9cd.png"> <br>
###### Collision of Snake to End Game
When the snake's head collides with the walls of the board(top, bottom,left, or right), then the game immediately ends and the playing boolean variable becomes false. The same goes for when the snake's head collides with any part of it's body, the game immediately ends. <br>
<img width="500" alt="Screen Shot 2022-05-31 at 11 58 02 PM" src="https://user-images.githubusercontent.com/89156607/171345938-3af11ece-bd46-42e4-9d8d-270ab18521b0.png"> <br>
##### Needed Actions
When the game begins playing, certain method actions are immediately needed for the ensurance of a working game. The checks for collison between the snake and the food, the checks for collision between the boundaries and the body itself, and the running of the snake all need to be working hence the action events.  <br>
<img width="300" alt="Screen Shot 2022-05-31 at 10 57 04 PM" src="https://user-images.githubusercontent.com/89156607/171345840-aa176603-c91e-4616-a2f2-353e3432f0c8.png"> <br>
### Acknowledgements
The snake and the food were created by Chhaya Maurya and Liv Morgan. The Snake Game was coded by Chhaya Maurya and Liv Morgan. This game was inspired by the Google Snake Game. <br>
