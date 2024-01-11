package com.Maven.Examen;

public class ProduitService {

	  public Produit readProduit(Long id) {
	        for (Produit p : produits) {
	            if (p.getId().equals(id)) {
	                return p;
	            }
	        }
	        return null;
	    }
}
