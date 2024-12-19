package phr_solution.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import phr_solution.entity.Patient;

@AllArgsConstructor
@Data
public class PatientRequestDto {
    private String name;
    private int age;
    private String gender;

    public void save(Patient newPatient) {

    }
}
