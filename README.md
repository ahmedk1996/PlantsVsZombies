Plants vs Zombies: The Puzzle!
SYSC 3110 - Project Iteration 2
Version: 1.0

Author(s): 
- Aly Khan Barolia: (Tests: PlantStoreTest,SunflowerTest,ShootingPlantTest)(UML:contributed in design)(Contributed to functionality, fixes and MVC)

- Ahmed Khattab: (Tests: LayoutTest,AllTests,turnTest)(UML:contributed in design)(Contributed to functionality, fixes, and MVC)

- Hun Ho: (Tests: CoolDownTest and WalkingZombieTest)(UML:contributed in design)(Contributed to functionality, fixes and MVC)

- Rohan Katkar: (Tests: GameTest and ActionTest)(UML:contributed in design)(Contributed to functionality, fixes and MVC)

Regarding group work distribution, in order to keep the workload distributed evenly, each member was assigned a section of the tests (2-3 test classes each), UML, new milestone implementation (GUI-based game) and fixes to previous milestone. 

Introduction:
The goal of this milestone is to create a base skeletal version of a typical Plants vs Zombies game. In this milestone we were required to create 1 level of the game allowing the user to but plants from the shop and place them on the board. The desired pattern used is the MVC model.

Change Log: 
Milestone 2: Implemented the plantsvszombies project using the MVC design pattern. This also included creating a test package which retains all the tests for our model side.

Next Steps:
The next steps for this project is to add more plants for the user to choose from, along with other types of zombies that have different attack speed, damage, movement speed, etc. In addition, to adding more Plants and Zombies to the board, we will also be implementing a undo/redo method option for the user to click an infinite number of times.

Included Files:
Default Package:
- startEngine.java
Model Package:
- Action.java
- Game.java
- Layout.java
- CoolDown.java
- CoolDownQueue.java
- Turn.java
- PrintGrid.java
Plants Package:
- PlantStrore.java
- Plants.java
- ShootingPlant.java
- SunFlower.java
Zombie Package:
- WalkingZombie.java
- Weapon.java
- Zombies.java
View Package:
- View.java
Controller package:
- Controller.java
Tests Package:
- ActionTest.java
- AllTests.java
- GameTest.java
- LayoutTest.java
- PlantStoreTest.java
- ShootingPlantTest.java
- SunflowerTest.java
- TurnTest.java
- CoolDownTest.java
- WalkingZombieTest.java
- Complete UML diagram (Image File)
- Complete Sequence Diagram (Image File)

Execution/Termination Instructions
Create a project on a desired IDE and import the project. Go to startEngine.java and select dropdown menu near the run icon. Then choose Run as Java Application and follow the prompts on the console.
After running the java file the user is prompted with a level choosing option in which, for now, they can only select easy option which involves only 4 walking zombies during a wave. The higher the level of difficulty is the more zombies introduced to the game there are.
After selecting the level of difficulty the user is introduced to a new panel in which they have the game board on the bottom and the upper is where the user has control over what plants he'd like to purchase and when to simulate the new wave. In order to purchase a plant the user must firstly have enough points for the certain plant unless their purchase button will not function. Once the user has a sufficient amount of sun points for their plant they must select the plant, press purchase and click on the grid below to place the plant. Once the user is ready they may press the simulate wave button in order to start the game.
 
Known issues that were fixed: Missing documentation was updated and each class was given its own description aswell as method documentation. Sequence diagram which was missing from the first milestone was created. A new class named CoolDown.java was created in order to keep the plants from being placed straight away after being purchased.	
