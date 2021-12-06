package com.example.demo.service;

import com.example.demo.model.Doc;
import com.example.demo.model.Suggestion;
import com.example.demo.model.SuggestionResult;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class SearchService {
  Faker faker = new Faker();

  public SuggestionResult fetchSuggestions(String query) {
    List<Suggestion> suggestions = new ArrayList<>();
    int n = faker.random().nextInt(5,10);
    for(int i=0; i<n; i++) {
      Suggestion suggestion = new Suggestion(faker.regexify(query+"[a-z][0-9]"));
      suggestions.add(suggestion);
    }
    SuggestionResult suggestionResult = new SuggestionResult();
    suggestionResult.setResults(suggestions);
    return suggestionResult;
  }

  public List<Doc> processSearch(String query) {
    int n = faker.random().nextInt(5,10);
    List<Doc> docs = new ArrayList<>();
    for(int i=0; i<n; i++) {
      Doc doc = new Doc(UUID.randomUUID().toString(), query +" " + faker.name().fullName());
      docs.add(doc);
    }
    return docs;
  }
}
