package com.example.demo.controller;

import com.example.demo.model.Doc;
import com.example.demo.model.GenerateDocument;
import com.example.demo.model.SuggestionResult;
import com.example.demo.service.SearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class SearchController {

  @Autowired
  SearchService searchService;

  @GetMapping("/find")
  @ResponseBody
  public List<Doc> fetchByNameOrDesc(@RequestParam(value = "q", required = false) String query) {
    log.info("searching by name {}",query);
    List<Doc> docs = searchService.processSearch(query) ;
    log.info("docs {}",docs);
    return docs;
  }


  @GetMapping("/suggestions")
  @ResponseBody
  public SuggestionResult fetchSuggestions(@RequestParam(value = "q", required = false) String query) {
    log.debug("fetch suggests {}",query);
    SuggestionResult suggests = searchService.fetchSuggestions(query);
    log.debug("suggests {}",suggests);
    return suggests;
  }


  @PostMapping("/generate")
  @ResponseBody
  public GenerateDocument generate(@RequestBody  GenerateDocument generateDocument) {
    log.debug("generate request: {}", generateDocument);
    return searchService.generate(generateDocument);
  }
}
