package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {

  private ISymptomReader reader;
  private ISymptomWriter writer;

  public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
    this.reader = reader;
    this.writer = writer;
  }

  public List<String> getSymptoms() {
    return reader.GetSymptoms();
  }

  public Map<String, Integer> countSymptoms(List<String> symptoms) {
    Map<String, Integer> symptomCounts = new HashMap<>();

    for (String symptom : symptoms) {
      symptomCounts.put(symptom, symptomCounts.getOrDefault(symptom, 0) + 1);
    }

    return symptomCounts;
  }

  public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
    return new TreeMap<>(symptoms);
  }

  public void writeSymptoms(Map<String, Integer> symptoms) {
    writer.writeSymptoms(symptoms);
  }

  public static void main(String[] args) {
    AnalyticsCounter analyticsCounter = new AnalyticsCounter(
        new ReadSymptomDataFromFile("symptoms.txt"),
        new WriteSymptomDataToFile());
    List<String> symptoms = analyticsCounter.getSymptoms();
    Map<String, Integer> symptomCounts = analyticsCounter.countSymptoms(symptoms);
    Map<String, Integer> sortedSymptoms = analyticsCounter.sortSymptoms(symptomCounts);
    analyticsCounter.writeSymptoms(sortedSymptoms);
  }
}
