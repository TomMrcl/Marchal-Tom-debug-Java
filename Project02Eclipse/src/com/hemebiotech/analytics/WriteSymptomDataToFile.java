package com.hemebiotech.analytics;

public class WriteSymptomDataToFile implements ISymptomWriter {

  @Override
  public void writeSymptoms(Map<String, Integer> symptoms) {
    try (
      BufferedWriter writer = new BufferedWriter(new FileWriter("result.out"))
    ) {
      for (Map.Entry<String, Integer> entry : symptoms.entrySet()) {
        writer.write(entry.getKey() + ": " + entry.getValue());
        writer.newLine();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
