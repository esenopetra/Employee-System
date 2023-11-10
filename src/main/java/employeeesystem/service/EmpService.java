package employeeesystem.service;

import employeeesystem.model.Employee;
import employeeesystem.repository.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class EmpService {
    @Autowired
    public EmpRepo empRepo;
    public void registerEmp(Employee e) {
        empRepo.save(e);
    }

    public List<Employee> getAllEmp() {
        return empRepo.findAll();
    }

    public Employee findEmpById(int id) {
        Optional<Employee> employee = empRepo.findById(id);
        if (employee.isPresent())
        {
            return employee.get();
        }

        return null;
    }


    public void deleteEmp(int id) {
        empRepo.deleteById(id);
    }
}
