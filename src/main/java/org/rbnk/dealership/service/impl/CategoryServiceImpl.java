package org.rbnk.dealership.service.impl;

import lombok.RequiredArgsConstructor;
import org.rbnk.dealership.entity.Category;
import org.rbnk.dealership.service.CategoryService;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final EntityManager entityManager;

    public void saveCategory(Category category) {
        entityManager.getTransaction().begin();
        entityManager.persist(category);
        entityManager.getTransaction().commit();
    }

    public void updateCategory(Category category) {
        entityManager.getTransaction().begin();
        entityManager.merge(category);
        entityManager.getTransaction().commit();
    }

    public void deleteCategory(Long id) {
        entityManager.getTransaction().begin();
        Category category = entityManager.find(Category.class, id);
        if (category != null) {
            entityManager.remove(category);
        }
        entityManager.getTransaction().commit();
    }

    public Category getCarCategoryById(Long id) {
        Category category = entityManager.find(Category.class, id);
        return category;
    }

    public List<Category> getAllCategories() {
        entityManager.getTransaction().begin();
        String jpqlQuery = "SELECT c FROM Category c";
        Query query = entityManager.createQuery(jpqlQuery, Category.class);
        List<Category> categories = query.getResultList();
        entityManager.getTransaction().commit();
        return categories;
    }

}
