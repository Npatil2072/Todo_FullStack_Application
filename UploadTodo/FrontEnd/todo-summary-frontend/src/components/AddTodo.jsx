import React, { useState } from 'react';
import { addTodo } from '../services/api';

function AddTodo() {
  const [title, setTask] = useState('');

  const handleAdd = async () => {
    if (!title.trim()) return;
    await addTodo({ title, completed: false });
    setTask('');
    window.location.reload(); // Simple reload for now
  };

  return (
    <div>
      <input
        type="text"
        placeholder="Add a new todo"
        value={title}
        onChange={e => setTask(e.target.value)}
      />
      <button onClick={handleAdd}>Add</button>
    </div>
  );
}

export default AddTodo;
