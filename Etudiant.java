public class Etudiant {
    private int id;
    private String nom;
    private String prenom;
    private String sexe;
    private String filiere;
    
    public Etudiant(int id, String nom, String prenom, String c, String filiere) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = c;
        this.filiere = filiere;
    }
    
    public Etudiant(String nom, String prenom, String sexe2, String filiere) {
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe2;
        this.filiere = filiere;
    }
    
    public int getId() {
        return id;
    }
    
    public String getNom() {
        return nom;
    }
    
    public String getPrenom() {
        return prenom;
    }
    
    public String getSexe() {
        return sexe;
    }
    
    public String getFiliere() {
        return filiere;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    public void setSexe(String sexe) {
        this.sexe = sexe;
    }
    
    public void setFiliere(String filiere) {
        this.filiere = filiere;
    }
    
    // redéfinition de la méthode equals pour comparer deux étudiants par leur id
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Etudiant etudiant = (Etudiant) o;
        return id == etudiant.id;
    }
}

