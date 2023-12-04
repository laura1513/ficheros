package org.example.openAPI;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Team {
    public int id;
    public String abbreviation;
    public String city;
    public String conference;
    public String division;
    public String full_name;
    public String name;
}
