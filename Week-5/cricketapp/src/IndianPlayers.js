function IndianPlayers() {

  const players = [
    "Virat",
    "Rohit",
    "Gill",
    "Rahul",
    "Pant",
    "Hardik"
  ];

  const oddPlayers = players.filter((_, index) => index % 2 === 0);
  const evenPlayers = players.filter((_, index) => index % 2 === 1);

  const T20Players = [
    "Virat",
    "Rohit",
    "Hardik"
  ];

  const RanjiPlayers = [
    "Pujara",
    "Rahane",
    "Jaiswal"
  ];

  const mergedPlayers = [...T20Players, ...RanjiPlayers];

  return (
    <div>

      <h2>Odd Team Players</h2>

      {oddPlayers.map((player, index) => (
        <p key={index}>{player}</p>
      ))}

      <h2>Even Team Players</h2>

      {evenPlayers.map((player, index) => (
        <p key={index}>{player}</p>
      ))}

      <h2>Merged Players</h2>

      {mergedPlayers.map((player, index) => (
        <p key={index}>{player}</p>
      ))}

    </div>
  );
}

export default IndianPlayers;