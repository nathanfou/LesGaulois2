package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipement;
	private int nbEquipement = 0;
	private String texte;
	

	public Romain(String nom, int force, int nbEquipement) {
	this.nom = nom;
	this.force = force;
	this.nbEquipement = nbEquipement;
	assert force > 0;
	this.equipement = new Equipement[2];
	}
	
	public String getNom() {
	return nom;
	}
	
	public void parler(String texte) {
	System.out.println(prendreParole() + "� " + texte + "�");
	}
	
	private String prendreParole() {
	return "Le romain " + nom + " : ";
	}
	
//	public void recevoirCoup(int forceCoup) {
//		assert force > 0;
//		int forcedebut;
//		forcedebut = force;
//		force -= forceCoup;
//		if (force > 0) {
//			parler("A�e");
//		}
//		else {
//			parler("J'abandonne...");
//		}
//		assert force < forcedebut;
//	}
	
	
	
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		forceCoup = CalculResistanceEquipement(forceCoup);
		force -= forceCoup;
		if (force == 0) {
		parler("Aïe");
		equipementEjecte = ejecterEquipement();
		parler("J'abandonne...");
		}
		return equipementEjecte;
	}
	
	
	
	private int CalculResistanceEquipement(int forceCoup) {
		 texte = "Ma force est de " + this.force + ", et la force ducoup est de " + forceCoup;
		int resistanceEquipement = 0;
		if ((nbEquipement != 0)) 
		{texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
		for (int i = 0; i < nbEquipement;) {
		if ((equipement[i] != null &&
		equipement[i].equals(Equipement.BOUCLIER)) == true) {
		resistanceEquipement += 8;
		} else {
		System.out.println("Equipement casque");
		resistanceEquipement += 5;
		}
		i++;
		}
		texte =+ resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
		}
	
	
	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom.toString() + "s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
		if (equipement[i] == null) {
		} else {
		equipementEjecte[nbEquipementEjecte] =
		equipement[i];
		nbEquipementEjecte++;
		equipement[i] = null;
		}
		}
		return equipementEjecte;
		}
	
    public void sEquiper(Equipement equipement) {
        switch (nbEquipement) {
            case 2:
                System.out.println("Le soldat " + this.getNom() + " est déjà bien protégé !");
                break;
            case 1:
                if (dejaEquipe(equipement)) {
                    System.out.println("Le soldat " + this.getNom() + " possède déjà un " + equipement + " !");
                } else {
                    ajouterEquipement(equipement);
                }
                break;
            case 0:
                ajouterEquipement(equipement);
                break;
        }
    }
		
    private boolean dejaEquipe(Equipement equipement) {
        return this.equipement[0] == equipement || this.equipement[1] == equipement;
    }

    private void ajouterEquipement(Equipement equipement) {
        this.equipement[nbEquipement] = equipement;
        nbEquipement++;
        System.out.println("Le soldat " + this.getNom() + " s'équipe avec un " + equipement + ".");
    }

	
	
	
	

	public static void main(String[] args) {
		Romain minus = new Romain("Minus",6, 0);	
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
	}
}