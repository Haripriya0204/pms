package com.usm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usm.model.Themes;
import com.usm.service.ThemesService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/Themes")
public class ThemesController {
	@Autowired
	ThemesService ts;
	
	@PostMapping("/addthemes")
    public ResponseEntity<Themes> addPthemes(@Valid @RequestBody Themes theme)
    {
    	 Themes themes =ts.addthemes(theme);

        return new ResponseEntity<>(themes,HttpStatus.OK);

    } 
	
	 @GetMapping("/fetchThemes") 
	  public ResponseEntity<List<Themes>> getAllThemes() {
			List<Themes> dataList = ts.getAllThemes();
			return new ResponseEntity<>(dataList, HttpStatus.OK);

		}
	 
	 
	 @PutMapping("/update/{themeName}")
		public ResponseEntity<Themes> updateMasterData(@RequestBody Themes theme,@PathVariable("themeName") String themeName) {
			Themes updatedData= ts.updateThemeData(themeName,theme);
			return new ResponseEntity<>(updatedData, HttpStatus.OK);
					
		}
	 
	 @GetMapping("/fetchByName/{themeName}")
		public ResponseEntity<Themes> getDataBythemeName(@PathVariable("themeName") String themeName) {
			Themes theme = ts.fetchThemesDataByName(themeName);
			return new ResponseEntity<>(theme, HttpStatus.OK);
		} 
	
	

}
