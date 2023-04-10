import java.util.List;

public interface IGestionEtudiants {
    Etudiant ajouterEtudiant(Etudiant e);
    List<Etudiant> rechercherParMC(String mc);
    void trierListeEtudiantsParNom();
    List<Etudiant> listeDesEtudiants();
}
