package com.usm.service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.usm.exception.DataNotFoundException;
import com.usm.model.Themes;
import com.usm.repository.ThemesRepo;
import jakarta.validation.Valid;
@Service
public class ThemesService {
	
		@Autowired
		ThemesRepo repo;

		public Themes addthemes(@Valid Themes theme) {
			
			return repo.save(theme);
		}

		public List<Themes> getAllThemes() {
			
			return repo.findAll();
		}

		

		

		public Themes fetchThemesDataByName(String themeName) {
			
			Optional<Themes> dataOptional = repo.findByThemeName(themeName);
			if (dataOptional.isPresent()) {
				return dataOptional.get();
			} else {
				throw new DataNotFoundException("Theme Name is not valid");
			}
		}

		public Themes updateThemeData(String themeName, Themes theme) {
			Themes ut=repo.findByThemeName(themeName).orElseThrow(
					()-> new DataNotFoundException("Data is not available with theme name:"+themeName));
			ut.setThemeName(theme.getThemeName());
			ut.setRisk(theme.getRisk());
			ut.setEquities(theme.getEquities());
			ut.setFixedIncome(theme.getFixedIncome());
			ut.setInvestmentHorizon(theme.getInvestmentHorizon());
			ut.setCommodities(theme.getCommodities());
					
			return repo.save(ut);
		}
		
		
		

	

		
	}


