package com.lina.supercuisinier.services.utilisateur;

import com.lina.supercuisinier.dtos.utilisateur.UtilisateurDto;
import com.lina.supercuisinier.models.utilisateur.Utilisateur;
import com.lina.supercuisinier.repository.UtilisateurRepository;
import org.springframework.stereotype.Service;

@Service
public class UtilisateurService {
    private UtilisateurRepository utilisateurRepository;

    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    public UtilisateurDto saveUtilisateur(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur).toUtilisateurDto();
    }

    public boolean existsByNomUtilisateur(String nomUtilisateur) {
        return utilisateurRepository.existsByNomUtilisateur(nomUtilisateur);
    }

    public UtilisateurDto findByNomUtilisateur(String nomUtilisateur) {
        Utilisateur utilisateur = utilisateurRepository.findByNomUtilisateur(nomUtilisateur);
        if (utilisateur != null) {
            return utilisateur.toUtilisateurDto();
        }
        return null;
    }

    public boolean validateAuthentification(String nomUtilisateur, String motPasse) {
        Utilisateur utilisateur = findByNomUtilisateur(nomUtilisateur).toUtilisateur();
        if (utilisateur != null) {
            return motPasse.equals(utilisateur.getMotPasse());
        }
        return false;
    }
}
