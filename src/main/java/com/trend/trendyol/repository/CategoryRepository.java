package com.trend.trendyol.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trend.trendyol.model.Category;

public interface CategoryRepository  extends JpaRepository<Category, Long> {


}
