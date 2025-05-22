import React from 'react';
import AddTodo from './components/AddTodo';
import TodoList from './components/TodoList';
import SummaryButton from './components/SummaryButton';

function App() {
  return (
    <div className="App">
      <h1>Todo Summary Assistant</h1>
      <AddTodo />
      <TodoList />
      <SummaryButton />
    </div>
  );
}

export default App;
