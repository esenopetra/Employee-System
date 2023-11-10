package employeeesystem.controller;

import employeeesystem.model.Employee;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import employeeesystem.service.EmpService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")

public class EmpController {
    @Autowired
    public EmpService empService;
    @GetMapping("/")
    public String home(Model model) {
        List<Employee> employee = empService.getAllEmp();
        model.addAttribute("employee", employee);

        return "index";
    }

    @GetMapping("/addemployee")
    public String addEmp() {

        return "add_emp";
    }
    @PostMapping("/register")
    public String empRegister(@ModelAttribute Employee e, HttpSession session)
    {
        empService.registerEmp(e);
        session.setAttribute("msg","Employee Added..");
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model){
        Employee employee = empService.findEmpById(id);
        model.addAttribute("emp", employee);
        return "edit";
    }
    @PostMapping("/editemp")
    public String editemp(@ModelAttribute Employee employee){
        empService.registerEmp(employee);
        return "redirect:/";
    }
    @GetMapping("/delete/{id}")
    public String deleteEmp(@PathVariable int id){
        empService.deleteEmp(id);
        return "redirect:/";
    }
}
