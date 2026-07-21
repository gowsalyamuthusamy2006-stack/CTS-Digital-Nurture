function ListofPlayers() {

  const players = [
    { name: "Virat", score: 95 },
    { name: "Rohit", score: 88 },
    { name: "Gill", score: 45 },
    { name: "Rahul", score: 67 },
    { name: "Pant", score: 80 },
    { name: "Hardik", score: 55 },
    { name: "Jadeja", score: 72 },
    { name: "Ashwin", score: 60 },
    { name: "Shami", score: 50 },
    { name: "Bumrah", score: 90 },
    { name: "Siraj", score: 65 }
  ];

  const lowScorePlayers = players.filter(player => player.score < 70);

  return (
    <div>
      <h2>All Players</h2>

      {players.map((player, index) => (
        <p key={index}>
          {player.name} - {player.score}
        </p>
      ))}

      <h2>Players Scoring Below 70</h2>

      {lowScorePlayers.map((player, index) => (
        <p key={index}>
          {player.name} - {player.score}
        </p>
      ))}
    </div>
  );
}

export default ListofPlayers;