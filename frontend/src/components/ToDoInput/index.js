import React, { useState } from "react";

const ToDoInput = ({ addTask }) => {

    const[userInput, setUserInput] = useState('');

    const handleChange = (e) => {
        setUserInput(e.currentTarget.value);
    }

    const handleSubmit = (e) => {
        e.preventDefault();
        addTask(userInput);
        setUserInput("");
    }

    return (
        <form className="form" onSubmit={handleSubmit}>
            <input value={userInput} type="text" onChange={handleChange} placeholder="Adicionar uma tarefa"/>
            <button className="btn-add">Adicionar</button>
        </form>
    );
}

export default ToDoInput;