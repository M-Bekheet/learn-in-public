import { Request, RequestHandler, Response, Router } from 'express';
import { createTodos } from '../controllers/todos';

const router = Router();

router.post('', createTodos);

export default router;
