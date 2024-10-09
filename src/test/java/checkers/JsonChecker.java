package checkers;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Team;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import static org.assertj.core.api.Assertions.assertThat;

public class JsonChecker {
    ClassLoader cl = JsonChecker.class.getClassLoader();
    public void checkJson(String fileName) throws IOException {
        String jsonString = readJsonFromResource(fileName);
        ObjectMapper objectMapper = new ObjectMapper();
        Team team = objectMapper.readValue(jsonString, Team.class);
        assertThat(team.getTeamName()).isEqualTo("Torro Grill");
        assertThat(team.getTeamLogo()).isEqualTo("https://example.com/logo.png");
        assertThat(team.getStaff()[0].getId()).isEqualTo(1);
        assertThat(team.getStaff()[0].getFirstName()).isEqualTo("Rick");
        assertThat(team.getStaff()[0].getLastName()).isEqualTo("Astley");
        assertThat(team.getStaff()[0].getVacation()).isEqualTo("chief");
        assertThat(team.getStaff()[1].getId()).isEqualTo(2);
        assertThat(team.getStaff()[1].getFirstName()).isEqualTo("Anna");
        assertThat(team.getStaff()[1].getLastName()).isEqualTo("de Armas");
        assertThat(team.getStaff()[1].getVacation()).isEqualTo("waitress");
    }

    public String readJsonFromResource(String fileName) throws IOException {
        try (InputStream inputStream = cl.getResourceAsStream(fileName)) {
            try (Scanner scanner = new Scanner(inputStream, StandardCharsets.UTF_8)) {
                return scanner.useDelimiter("\\A").next();
            }
        }
    }
}