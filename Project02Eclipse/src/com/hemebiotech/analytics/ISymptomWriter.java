package com.hemebiotech.analytics;

import java.util.Map;

public interface ISymptomWriter {
  void writeSymptoms(Map<String, Integer> symptoms);
}

   {
    for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
      writer.write(entry.getKey() + ": " + entry.getValue());
      writer.newLine();
    }
  } catch (IOException e) {
    e.printStackTrace();
  }