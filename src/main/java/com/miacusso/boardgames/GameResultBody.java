package com.miacusso.boardgames;

import com.miacusso.boardgames.db.PlayerDBO;

public class GameResultBody {

	private PlayerDBO winner;

	public PlayerDBO getWinner() {
		return winner;
	}

	public void setWinner(PlayerDBO winner) {
		this.winner = winner;
	}

}
