import { useState } from 'react';
import './App.css';
import data from './data.json';

import Header from './components/Header/';
import ToDoList from './components/ToDoList/';
import ToDoInput from './components/ToDoInput/';

function App() {

  const [toDoList, setToDoList] = useState(data);

  const handleToggle = (id) => {
    let mapped = toDoList.map(task => {
      return task.id === id ? { ...task, complete: !task.complete } : { ...task };
    });
    setToDoList(mapped);
  }

  //mostra as tarefas não completadas 
  const handleFilter  = () => {
    let filtered = toDoList.filter(task => {
      return !task.complete;
    });
    setToDoList(filtered);
  }

  //adicionar tarefas
  const addTask = (userInput) => {
    let add = [...toDoList];
    add = [...add, { id: toDoList.length + 1, task: userInput, complete: false }];
    setToDoList(add);
  }
  
  return (
    <div className="App">
      <Header />
      <ToDoList toDoList={toDoList} handleToggle={handleToggle} />
      <ToDoInput addTask={addTask} />
      <button className="btn-delete" onClick={handleFilter}>Deletar tarefas concluídas</button>
    </div>
  );
};

export default App;
