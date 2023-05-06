package org.itstep.pd011.controllers;

import org.itstep.pd011.models.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

// общий сегмент маршрута для всех методов действия контроллера
@RequestMapping("/student")
@Controller
public class StudentController {
    // данные для обработки
    private static Student student = new Student();

    // вывод формы по GET-запросу --> /student/
    @GetMapping("/")
    public ModelAndView index() {
        return new ModelAndView("student-form", "student", student);
    } // index

    // обработчик формы по post-запросу --> /student/addStudent
    // параметр Student st - это View-Model :)
    @PostMapping("/addStudent")
    public String addStudent(@ModelAttribute("SpringWeb") Student st, Model model) {

        // получить данные из формы
        // student.setSurname(st.getSurname());
        // student.setName(st.getName());
        //...

        // в д.с. проще присвоить объект целиком
        student = st;

        // передать введенные данные в представление
        model.addAttribute("student", student);
        return "student-details";
    } // addStudent

    // увеличить возраст студента на значение, переданное в маршруте
    @RequestMapping(value="/inc-age/{value}")
    public String incAge(@PathVariable String value, Model model) {

        // увеличить возраст студента на заданное значение
        student.setAge(student.getAge() + Integer.parseInt(value));

        // вывод измененных данных
        model.addAttribute("student", student);
        return "student-details";
    } // incAge


    // просмотр данных студента  --> /student/details
    @GetMapping("/details")
    public String showStudent(Model model) {

        model.addAttribute("student", student);
        return "student-details";
    } // showStudent
} // class StudentController
