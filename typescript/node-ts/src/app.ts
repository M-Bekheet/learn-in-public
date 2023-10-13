import express from 'express';
import todoRoutes from './routes/todos';
const app = express();

const port = process.env.PORT || 5050;

app.use('/todos', todoRoutes);

app.listen(port, () => {
  console.log('Server is running on', port);
});
