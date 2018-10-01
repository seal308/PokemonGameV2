package logic;

public class Trainer {
	private int pokeLeft;
	private String name;
	private PokeGenerator pokeGen;

	public Trainer(String name) {
		this.name = name;
		pokeGen = new PokeGenerator();
	}
}
