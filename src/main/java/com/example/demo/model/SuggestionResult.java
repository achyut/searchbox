package com.example.demo.model;

import lombok.Data;

import java.util.List;

@Data
public class SuggestionResult {
  Long page;
  List<Suggestion> results;
  Long total_pages;
  Long total_results;
}
