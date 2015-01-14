/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.dao;

import java.util.Vector;

/**
 *
 * @author otm
 * @param <T>
 */
public interface DAO<T> {
    
        /**
	 * Permet de récupérer un objet via son ID
	 * @param id
	 * @return
	 */
	public  T find(String id);
         
        
        /**
         * Permet de requperer tout les objets
         * @param id
         * @return 
         */
        public  Vector<T> all();
	
        
	/**
	 * Permet de créer une entrée dans la base de données
	 * par rapport à un objet
	 * @param obj
	 */
	public  boolean create(T obj);
	
        
	/**
	 * Permet de mettre à jour les données d'une entrée dans la base 
	 * @param obj
	 */
	public  boolean update(T obj);
	
        
	/**
	 * Permet la suppression d'une entrée de la base
	 * @param obj
	 */
	public  boolean delete(T obj);
        
}
    


	
    

