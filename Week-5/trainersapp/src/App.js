import {
    BrowserRouter,
    Routes,
    Route,
    Link
} from "react-router-dom";

import Home from "./Home";
import TrainersList from "./TrainerList";
import TrainerDetails from "./TrainerDetails";

function App() {

    return (

        <BrowserRouter>

            <div style={{ margin: "30px" }}>

                <nav>

                    <Link to="/">Home</Link>

                    {" | "}

                    <Link to="/trainers">Trainers</Link>

                </nav>

                <hr />

                <Routes>

                    <Route
                        path="/"
                        element={<Home />}
                    />

                    <Route
                        path="/trainers"
                        element={<TrainersList />}
                    />

                    <Route
                        path="/trainers/:id"
                        element={<TrainerDetails />}
                    />

                </Routes>

            </div>

        </BrowserRouter>

    );
}

export default App;