/* 
  The Observer Pattern
  - With it, we can subscribe certain objects, the `observers` to another object, called the `observable`. Whenever an event occurs the observable notifies all its observers

  - observers: an array of observers that will get notified whenever a specific event occurs
  - subscribe(): a method in order to add observers to the observers list
  - unsubscribe(): a method in order to remove observers from the observers list
  - notify(): a method to notify all observers whenever a specific event occurs

  - This pattern use useful when working with asynchronous and event-based data.
  - Maybe we want to notify the user when data has finished downloading or whenever users sent new messages and all other members need to be notified.

  - This is widely used in RxJS which is used by Angular/NgRx
  - If an observer becomes too complex, it may cause performance issues when notifying all subscribers.

*/

export type CallbackFunction = (args?: string) => unknown;

class Observable {
  constructor(private observers = <CallbackFunction[]>[]) {}

  subscribe(func: CallbackFunction) {
    this.observers.push(func);
  }

  unsubscribe(func: CallbackFunction) {
    this.observers = this.observers.filter((observer) => observer !== func);
  }

  notify(data: string) {
    this.observers.forEach((observer) => observer(data));
  }
}

export default new Observable();
