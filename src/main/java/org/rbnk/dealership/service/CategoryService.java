package org.rbnk.dealership.service;

import org.rbnk.dealership.entity.Category;

import javax.persistence.Query;
import java.util.List;

public interface CategoryService {
    public void saveCategory(Category category);

    public void updateCategory(Category category);

    public void deleteCategory(Long id);

    public Category getCarCategoryById(Long id);

    public List<Category> getAllCategories();
}
