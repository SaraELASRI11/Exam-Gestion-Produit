package com.Maven.Examen;

import java.util.ArrayList;
import java.util.List;

public class ProduitService {

	private List<Produit> produits = new ArrayList<>();

	public boolean produitExiste(Long id, String nom) {
	    for (Produit p : produits) {
	        if (p.getId().equals(id) || p.getNom().equals(nom)) {
	            return true;
	        }
	    }
	    return false;
	}
	
	public boolean ValidationProduit(double prix, int quantite) {
	    return prix >= 0 && quantite >= 0;
	}

    public void createProduit(Produit produit) {
      
    	    if (!produitExiste(produit.getId(), produit.getNom())) {
    	        if (ValidationProduit(produit.getPrix(), produit.getQuantite())) {
    	            produits.add(produit);
    	        } else {
    	            // Gestion d'exception : Valeurs invalides
    	        	
    	            throw new IllegalArgumentException("Le prix et la quantité doivent être positifs.");
    	        }
    	    } else {
    	        // Gestion d'exception : Produit déjà existant
    	    	
    	        throw new IllegalArgumentException("Un produit avec le même ID ou nom existe déjà.");
    	    }
    		}
   public Produit readProduit(Long id) {
	        for (Produit p : produits) {
	            if (p.getId().equals(id)) {
	                return p;
	            }
	        }
	        return null;
	    }

   public void deleteProduit(Long id) {
       
	   	Produit produitToRemove = null;

	       for (Produit p : produits) {
	           if (p.getId().equals(id)) {
	               produitToRemove = p;
	               break;
	           }
	       }

	       if (produitToRemove != null) {
	           produits.remove(produitToRemove);
	       }
	        }
}
