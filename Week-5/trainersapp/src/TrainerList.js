import { Link } from "react-router-dom";
import trainers from "./TrainersMock";

function TrainersList() {
    return (
        <div>
            <h1>Trainers List</h1>

            <ul>
                {trainers.map((trainer) => (
                    <li key={trainer.id}>
                        <Link to={`/trainers/${trainer.id}`}>
                            {trainer.name}
                        </Link>
                    </li>
                ))}
            </ul>
        </div>
    );
}

export default TrainersList;