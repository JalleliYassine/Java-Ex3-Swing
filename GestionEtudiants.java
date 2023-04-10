import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GestionEtudiants implements IGestionEtudiants {
    private List<Etudiant> listeEtudiants;
    
    public GestionEtudiants() {
        listeEtudiants = new ArrayList<>();
    }
    
    @Override
    public Etudiant ajouterEtudiant(Etudiant e) {
        if (!listeEtudiants.contains(e)) {
            if (e.getId() == 0) {
                int maxId = 0;
                for (Etudiant etudiant : listeEtudiants) {
                    if (etudiant.getId() > maxId) {
                        maxId = etudiant.getId();
                    }
                }
                e = new Etudiant(maxId + 1, e.getNom(), e.getPrenom(), e.getSexe(), e.getFiliere());
            }
            listeEtudiants.add(e);
            return e;
        }
        return null;
    }

    @Override
    public List<Etudiant> rechercherParMC(String mc) {
        List<Etudiant> resultat = new ArrayList<>();
        for (Etudiant etudiant : listeEtudiants) {
            if (etudiant.getNom().toLowerCase().contains(mc.toLowerCase())
                    || etudiant.getPrenom().toLowerCase().contains(mc.toLowerCase())) {
                        resultat.add(etudiant);
                    }
                }
                return resultat;
            }
        
            @Override
            public void trierListeEtudiantsParNom() {
                Collections.sort(listeEtudiants, (e1, e2) -> e1.getNom().compareTo(e2.getNom()));
            }
        
            @Override
            public List<Etudiant> listeDesEtudiants() {
                return listeEtudiants;
            }

            
        }
        

