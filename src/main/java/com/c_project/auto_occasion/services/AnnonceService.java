package com.c_project.auto_occasion.services;

import com.c_project.auto_occasion.connexion.Connexion;
import com.c_project.auto_occasion.dao.AnnonceDAO;
import com.c_project.auto_occasion.model.Annonce;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class AnnonceService {
    private AnnonceDAO annonceDAO;
    private Connexion con;

    public AnnonceService() {
        annonceDAO = new AnnonceDAO();
        con = new Connexion();
    }
    public void updateStatut(int newState, int id_annonce) throws Exception {
        Connection connection = null;
        try {
            connection = con.getConnection();
            annonceDAO.updateStatut(newState, id_annonce);
        } catch (SQLException e) {
            throw e;
        } finally {
            if(connection != null) {
                connection.close();
            }
        }
    }
    public List<Annonce> search(String keyword, Date date, Integer categoryId, BigDecimal price, Integer brandId, String model) throws Exception {
        Connection connection = null;
        List<Annonce> annonces = new ArrayList<>();
        try {
            connection = con.getConnection();
            annonces = annonceDAO.search( keyword, date, categoryId, price, brandId, model );
        } catch (SQLException e) {
            throw e;
        } finally {
            if(connection != null) {
                connection.close();
            }
        }
        return annonces;
    }
    public List<Annonce> findAllUser_s_Annonces(int id_user) throws Exception {
        List<Annonce> user_s_annonces = new ArrayList<>();
        try {
            user_s_annonces = annonceDAO.findAllUserSAnnonce(id_user);
        } catch (SQLException e) {
            throw e;
        }
        return user_s_annonces;
    }
    public Annonce findOneAnnonceOfAnUser(int id_user, int id_annonce) throws Exception {
        Annonce an_annonce_of_an_user = new Annonce();
        try {
            an_annonce_of_an_user = annonceDAO.findOneAnnonceOfAnUser(id_user, id_annonce);
        } catch (SQLException e) {
            throw e;
        }
        return an_annonce_of_an_user;
    }
    public void create(Annonce newAnnonce) throws Exception {
        try {
            annonceDAO.createAnnonce(newAnnonce);
        } catch (SQLException e) {
            throw e;
        }
    }
    public void delete(int id_annonce) throws Exception {
        try {
            annonceDAO.deleteAnnonce(id_annonce);
        } catch (SQLException e) {
            throw e;
        }
    }
    public List<Annonce> allAnnonces() throws Exception {
        List<Annonce> annonces = new ArrayList<>();
        try {
            annonces = annonceDAO.findAllAnnonce();
        } catch (SQLException e) {
            throw e;
        }
        return annonces;
    }
    public Annonce oneAnnonce(int id_annonce) throws Exception {
        Annonce one_annonce = new Annonce();
        try {
            one_annonce = annonceDAO.findOneAnnonce(id_annonce);
        } catch (SQLException e) {
            throw e;
        }
        return one_annonce;
    }
}
