package com.usm.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.usm.model.Themes;

@Repository
public interface ThemesRepo extends JpaRepository<Themes, String> {

	Optional<Themes> findByThemeName(String themeName);

}
