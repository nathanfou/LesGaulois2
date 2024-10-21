package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois[] villageois;
	private int nbVillageois = 0;
	private int nbVillageoisMaximum;
	
	public Village(String nom, int nbVillageoisMaximum ) {
		this.nbVillageoisMaximum = nbVillageoisMaximum;
		this.nom = nom;
		villageois = new Gaulois[nbVillageoisMaximum];
	}
	

	public String getNom() {
		return nom;
		
	}
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	
	public void ajouterHabitant(Gaulois gaulois) {
		if (nbVillageois < nbVillageoisMaximum) {
		villageois[nbVillageois] = gaulois;
		nbVillageois++;
		}	
	}


	
	public Gaulois trouverHabitant(int nbVillageois) {
		return villageois[nbVillageois];
		
	}
	public void afficherVillageois() {
		System.out.println("Dans le village du chef "+ chef.getNom() + " vivent les légendaires Gaulois : ");
		for(int i = 0; i<nbVillageois;i++) {
			Gaulois habitant = trouverHabitant(i);
			System.out.println("-" + habitant.getNom());
		}
		}
		
	
	
	
	public static void main(String[] args) {
		Village village = new Village("Village des irréductibles",30);
		//Gaulois gaulois = village.trouverHabitant(30);
		//parce que le 30 eme habitant est le numéro 29 dans le tableau
		Gaulois asterix = new Gaulois("Asterix", 8);
		Chef abraracourcix = new Chef("Abraracourcix",6,village);
		village.ajouterHabitant(asterix);
		village.setChef(abraracourcix);
		Gaulois gaulois = village.trouverHabitant(0);
		Gaulois obelix = new Gaulois("Obélix",25);
		village.ajouterHabitant(obelix);
		village.afficherVillageois();
		
	}
	
}