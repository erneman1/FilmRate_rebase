package ua.cursor.filmrate.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import ua.cursor.filmrate.entity.Category;
import ua.cursor.filmrate.repository.CategoryRepository;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    public Category getById(Long id) {
        return categoryRepository.getById(id);
    }

    @PostConstruct
    private void testCreate(){
        categoryRepository.save(new Category(null, "Horror", new HashSet<>()));
        categoryRepository.save(new Category(null, "Detective", new HashSet<>()));
        categoryRepository.save(new Category(null, "Drama", new HashSet<>()));
        categoryRepository.save(new Category(null, "Comedy", new HashSet<>()));
        categoryRepository.save(new Category(null, "Fantastic", new HashSet<>()));
        categoryRepository.save(new Category(null, "Fantasy", new HashSet<>()));
        categoryRepository.save(new Category(null, "Thriller", new HashSet<>()));
        categoryRepository.save(new Category(null, "Action", new HashSet<>()));
        categoryRepository.save(new Category(null, "Travel", new HashSet<>()));
    }
}
