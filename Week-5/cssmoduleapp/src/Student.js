import styles from "./Student.module.css";

function Student() {
    return (
        <div className={styles.container}>

            <div className={styles.card}>

                <h1 className={styles.title}>
                    Student Details
                </h1>

                <p className={styles.detail}>
                    Name: Nisha
                </p>

                <p className={styles.detail}>
                    Department: CSE
                </p>

                <p className={styles.detail}>
                    College: ABC Engineering College
                </p>

                <button className={styles.button}>
                    View Profile
                </button>

            </div>

        </div>
    );
}

export default Student;