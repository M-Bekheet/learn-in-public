/* 
  - The Command Pattern encapsulates a request as an object, thereby letting you parameterize other objects with different requests, queue or log requests, and support undoable operations.
  - This pattern is mainly used to avoid having a strict structure in your objects, and to be able to add new commands without having to change the existing code.
  - For example, imagine a Restaurant Order Management class that needs to process orders by doing such tasks: placeOrder, trackOrder, and cancelOrder. 
  - The problem is that the Restaurant Order Management class is tightly coupled to the Order class, and if we want to add a new order type, we need to change the Restaurant Order Management class. And also that if instead of placing an order, you wanted to change the system and `subscribe to the order` functionality(placing & tracking), you would need to change the Restaurant Order Management class again.
  - Here comes the Command Pattern to `decouple` such tasks/commands from the main class and give the ability to add new commands without having to change the existing class code.
  - Some other benefits: having a queue/history of commands, logging commands, and undoing commands.
*/

type Execute = (orders: string[], ...args: any) => void;

class OrderManager {
  constructor(private orders: string[]) {}

  execute(command: Command, ...args: any) {
    return command.execute(this.orders, ...args);
  }
}

// Command Interface

class Command {
  execute: Execute;
  constructor(execute: Execute) {
    this.execute = execute;
  }
}
// Commands

function PlaceOrderCommand(order: string, id: string) {
  return new Command((orders: string[]) => {
    orders.push(id);
    console.log(`You have successfully ordered ${order} (${id})`);
  });
}

function CancelOrderCommand(id: string) {
  return new Command((orders: string[]) => {
    orders.splice(orders.indexOf(id), 1);
    console.log(`You have canceled your order  ${id}`);
  });
}

function TrackOrderCommand(id: string) {
  return new Command(() => {
    console.log(`Your order ${id} is on the way`);
  });
}

function ListOrdersCommand() {
  return new Command(() => {
    console.log("Current Orders: " + orders.join(", "));
  });
}

const orders = <string[]>[];
const orderManager = new OrderManager(orders);
orderManager.execute(PlaceOrderCommand("Pizza", "1"));
orderManager.execute(PlaceOrderCommand("Burger", "2"));
orderManager.execute(PlaceOrderCommand("Fries", "3"));

orderManager.execute(CancelOrderCommand("2"));
orderManager.execute(TrackOrderCommand("3"));

orderManager.execute(ListOrdersCommand());
