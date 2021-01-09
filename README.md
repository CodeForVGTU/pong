# Refactored Pong Game
## Coded using clean code practise and two design patterns.
First Design Pattern is Singleton used to create board instance. File name is BoardSingleton.java in objects package.<br>
<i>Singleton is a creational design pattern that lets you ensure that a class has only one instance, while providing a global access point to this instance.</i><br><hr>
Second Design Pattern is Command. It's used for user input to move paddle up and down. For That we created Command interface. MovePaddleDown and MovePaddleUp implements Command interface. In PaddleController class we create instance for player inputs using command pattern.<br>
<i>Command is a behavioral design pattern that turns a request into a stand-alone object that contains all information about the request.</i><br>
![pong-1](https://i.imgur.com/rbm1igq.png)
![pong-2](https://i.imgur.com/Nm1SJtk.png)
![pong-3](https://i.imgur.com/RE6Vx9R.png)
Some unit test are written in tests folder.
There will be bug of font path in Constants class so you need to set path accordingly to your computer file system.
