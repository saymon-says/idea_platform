package org.testJob.parser;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.testJob.model.Root;
import org.testJob.model.Ticket;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FlightTimeParser {

    public List<Ticket> parse() {

        ObjectMapper mapper = new ObjectMapper();
        try {
            Root root = mapper.readValue(getContentFile("tickets.json"), Root.class);
            return root.getTickets();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }


    public static Path getNormalizedPath(String fileName) {
        return Paths.get(fileName).toAbsolutePath().normalize();
    }

    public static String getContentFile(String fileName) throws IOException {
        return Files.readString(getNormalizedPath(fileName)).trim().replaceFirst("\ufeff", "");
    }
}
