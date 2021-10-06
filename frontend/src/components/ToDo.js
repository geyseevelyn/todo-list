import React from "react";

const ToDo = ({ todo, handleToggle }) => {

    /*
    const handleClick = (e) => {
        e.preventDefault()
        handleToggle(e.currentTarget.id)
    } */

    return (
        <div onClick={() => handleToggle(todo.id)} className={todo.complete ? "underline" : ""}>
            {todo.task}
        </div>
    );
};

export default ToDo;