import React, { useEffect, useState } from 'react';
import { getTodos, deleteTodo } from '../services/api';

function TodoList() {
  const [todos, setTodos] = useState([]);

  useEffect(() => {
    getTodos().then(setTodos);
  }, []);

  const handleDelete = async (id) => {
    await deleteTodo(id);
    setTodos(prev => prev.filter(todo => todo.id !== id));
  };

  return (
    <div>
      <h2>My Todos</h2>
      <ul>
        {todos.map(todo => (
          <li key={todo.id}>
            {todo.title}
            <button onClick={() => handleDelete(todo.id)}>❌</button>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default TodoList;
