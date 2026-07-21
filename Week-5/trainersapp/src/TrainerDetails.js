import { useParams } from "react-router-dom";
import trainers from "./TrainersMock";

function TrainerDetails() {

    const { id } = useParams();

    const trainer = trainers.find(
        trainer => trainer.id === Number(id)
    );

    if (!trainer) {
        return <h2>Trainer Not Found</h2>;
    }

    return (
        <div>

            <h1>Trainer Details</h1>

            <p><b>ID:</b> {trainer.id}</p>

            <p><b>Name:</b> {trainer.name}</p>

            <p><b>Phone:</b> {trainer.phone}</p>

            <p><b>Email:</b> {trainer.email}</p>

            <p><b>Technology:</b> {trainer.technology}</p>

            <p><b>Skills:</b> {trainer.skills}</p>

        </div>
    );
}

export default TrainerDetails;