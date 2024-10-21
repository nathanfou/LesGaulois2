package personnages;

public class Druide {
	private String nom;
	private int effetPotionMin = 5;
	private int effetPotionMax = 10;


	
	public Druide(String nom, int effetPotion) {
		this.nom = nom;

		parler("Bonjour, je suis le druide " + nom + " et ma potion peut aller d'une force " + effetPotionMin + " à " + effetPotionMax + ".");
	}
	
	

	public String getNom() {
	return nom;
	}
	
	public void parler(String texte) {
	System.out.println(prendreParole() + "« " + texte + "»");
	}
	
	private String prendreParole() {
	return "Le druide " + nom + " : ";
	}

}