package org.example.openAPI;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Players {
    public int id;
    public String first_name;
    public String last_name;
    public String position;
    public Team team;
}
