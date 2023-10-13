import { RequestHandler } from 'express';
import { Todo } from '../models/todo';

const TODOS: Todo[] = [];

export const createTodos: RequestHandler = (req, res) => {
  try {
    const text = (req.body as { text: string }).text;
    const newTodo = new Todo(
      Math.floor(Math.random() * 400).toString(),
      text,
      false
    );
    res.send(newTodo);
  } catch (error) {
    res.status(500).send('Bad thing happened');
  }
};
