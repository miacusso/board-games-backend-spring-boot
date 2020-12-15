package com.miacusso.boardgames;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.miacusso.boardgames.db.DatabaseConnector;
import com.miacusso.boardgames.db.GameDBO;
import com.miacusso.boardgames.db.PlayerDBO;

@RestController
public class BoardgamesController {

	private final DatabaseConnector dbConnector = new DatabaseConnector();

	@CrossOrigin
	@GetMapping("/{game}/players")
	public List<PlayerDBO> getPlayers(@PathVariable int game) {
		GameDBO gameDBO = new GameDBO();
		gameDBO.setId(game);
		List<PlayerDBO> dbResponse = dbConnector.retrievePlayersForGame(gameDBO);
		return dbResponse;
	}

	@CrossOrigin
	@GetMapping("/{game}/result-table")
	public Map<String, Integer> getResultTable(@PathVariable int game) {
		GameDBO gameDBO = new GameDBO();
		gameDBO.setId(game);
		Map<String, Integer> dbResponse = dbConnector.retrieveResultsCountForGame(gameDBO);
		return dbResponse;
	}

	@CrossOrigin
	@PostMapping("/{game}/winner")
	public String registerGameWinner(@PathVariable int game, @RequestBody GameResultBody gameResult) {
		
		dbConnector.insertGameResult(gameResult.getWinner().getId(), game);

		return "OK";
	}

	@CrossOrigin
	@GetMapping("/{game}/delete-result-table")
	public String deleteGameResultTable(@PathVariable int game) {

		GameDBO gameDBO = new GameDBO();
		gameDBO.setId(game);

		dbConnector.removeResultsForGame(gameDBO);

		return "OK";
	}

}
