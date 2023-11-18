/* 
  Mediator pattern:
   - The mediator aka the middleware pattern makes it easy for us to simplify many-to-many relationships between objects, by letting all communication flow through one central point, the middleware.
   - Instead of objects interacting directly with each other, they interact through the mediator.
   - This reduces the dependencies between communicating objects, thereby reducing coupling, and makes it easier to modify, extend, and reuse individual components.
   - This is commonly used in Express.js to intercept the incoming requests and interact as auth guards, headers modifiers, loggers, etc.
  - Chatroom example:
    ==> The mediator is the chatroom.
    ==> The users are the colleagues.
    ==> The messages are the notifications.
  - See how the users are not directly interacting with each other, but through the mediator, the chatroom.
   */

class ChatRoom {
  logMessage(user: User, message: string) {
    console.log(
      `[${new Date().toLocaleString()}] ${user.getName()}: ${message}`
    );
  }
}

class User {
  constructor(private name: string, private chatRoom: ChatRoom) {}

  sendMessage(message: string) {
    this.chatRoom.logMessage(this, message);
  }

  getName() {
    return this.name;
  }
}

const room = new ChatRoom();
const john = new User("John Doe", room);
const jane = new User("Jane Eyre", room);

john.sendMessage("Hey, how are you doing?");
jane.sendMessage("Hii, I am doing well, how about you?");
john.sendMessage("I am doing well too, thanks for asking!");
