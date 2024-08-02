package com.dsi.tp1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dsi.tp1.entities.Etudiant;
import com.dsi.tp1.repositories.AdresseRepository;
import com.dsi.tp1.repositories.EtudiantRepository;

@Service
public class EtudiantServiceImpl implements IEtudiantService{

	@Autowired
	AdresseRepository adresseRepo;
	
	@Autowired
	EtudiantRepository etudiantRepo;
	

	public List<Etudiant> getAllEtudiant() {
		return etudiantRepo.findAll();
	}
	
	public Etudiant findEtudiant(int id) {
		
		// with optional
		 
		 
		Optional<Etudiant> etudiant=etudiantRepo.findById(id);
		if (etudiant.isPresent())
			return etudiant.get();
		return null;

		
		
		
		}
	
	public boolean saveEtudiant(Etudiant etudiant) {
		
	    adresseRepo.save(etudiant.getAdrissa());
		if (etudiantRepo.save(etudiant)!=null)
				return true;
		return false;
	}
	
	public boolean deleteEtudiant(int id) {
		etudiantRepo.deleteById(id);
		return etudiantRepo.existsById(id);
	}
	
	public Etudiant updateEtudiant(Etudiant etudiant, int id) {
		
		etudiant.setCode(id);
		return etudiantRepo.save(etudiant);
	}

	@Override
	public List<Etudiant> findEtudiantsParNom(String nom) {
		return etudiantRepo.findAllByNom(nom);
	}
	
}