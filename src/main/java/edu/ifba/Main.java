package edu.ifba;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        Aluno aluno = new Aluno();
        aluno.setNome("João da Silva");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("mariadb");
        var em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(aluno);
        em.getTransaction().commit();

        System.out.println("Aluno persistido com sucesso: " + aluno.getNome());

        // Fechando o EntityManager e o EntityManagerFactory
        em.close();
        emf.close();
    }
}