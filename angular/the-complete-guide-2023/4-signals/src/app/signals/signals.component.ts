import { NgFor } from "@angular/common";
import { Component, signal, computed, effect } from "@angular/core";

@Component({
  selector: "app-signals",
  templateUrl: "./signals.component.html",
  standalone: true,
  imports: [NgFor],
})
export class SignalsComponent {
  actions = signal<string[]>([]);
  counter = signal(0);
  doubleCounter = computed(() => this.counter() * 2); //this will always be updated whenever the this.counter changes

  constructor() {
    effect(() => console.log(this.counter())); //this will be triggered whenever this.counter changes
  }

  increment() {
    this.counter.update((c) => c + 1);
    this.actions.mutate((prev) => prev.push("INCREMENT"));
  }

  decrement() {
    this.counter.update((c) => c - 1);
    this.actions.update((prev) => [...prev, "DECREMENT"]);
  }
}
