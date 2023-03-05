import logo from './logo.svg';
import './App.css';
import {useState} from "react";

function GoalForm(props) {
  const [formData, setFormData] = useState({goal: "", by:""});

  function changeHandler(e) {
    setFormData({...formData, [e.target.name]: e.target.value});
  }

  function submitHandler(e) {
    e.preventDefault();
    props.onAdd(formData);
    setFormData({goal: "", by: ""});
  };

  return (
    <div>
      <h1>Goals</h1>
      <form onSubmit={submitHandler}>
        <input type="text" name="goal" placeholder="Type Goal Here" value={formData.goal} onChange={changeHandler} />
        <input type="text" name="by" placeholder="Complete Goal By" value={formData.by} onChange={changeHandler} />
        <button>Submit Goal!</button>
      </form>
    </div>
  );
}


function ListOfGoals(props) {
  return (
    <ul>
      {props.allGoals.map((g) => (
        <li key={g.goal}>
          <span>Goal = {g.goal}, Due Date = {g.by}</span>
        </li>
      ))}
    </ul>
  );
}



function App() {
  const [allGoals, updateAllGoals] = useState([]);

  function addGoal(goal) {
    updateAllGoals([...allGoals, goal]);
  }

  return (
    <div className="App">
      <GoalForm onAdd={addGoal} />
      <ListOfGoals allGoals={allGoals} />
    </div>
  );
}

export default App;
