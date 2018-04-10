package OLD;

import java.util.Arrays;

public class Team {
	String name;
	int num_of_players;
	Player[] players = new Player[20];
	
	public Team(String name, Player[] players) {
		this.name = name;
		this.num_of_players = players.length;
		
		for(int i = 0; i < players.length && i < this.players.length; i++) {
			this.players[i] = players[i];
		}

	}
	
	
	public String getName() {
		return name;
	}
	public int getNum_of_players() {
		return num_of_players;
	}
	public Player[] getPlayers() {
		return players;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setNum_of_players(int num_of_players) {
		this.num_of_players = num_of_players;
	}
	public void setPlayers(Player[] players) {
		this.players = players;
	}
	
	
	public String add_player(Player player) {
		if(this.num_of_players == 20)
			return "We are sorry, you cannot add any more players to the team.";
		this.num_of_players ++;
		this.players[num_of_players-1] = player;
		return "OLD.Player successfully added. Good Luck!";
		
	}
	
	public int expert_shots() {
		int counter = 0;
		for (Player p : this.players) {
			if(p == null)
				return counter;
			else if(p.getNum_of_points() > 100)
				counter++;
		}
		return counter;
	}
	
	

	public String toString() {
		return this.name + " has " + this.num_of_players + " players, which are: " + Arrays.toString(this.players) ;
	}
	
	
	
	
	
}
