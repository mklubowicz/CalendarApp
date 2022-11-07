package Models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task {

    public Task(LocalDate date,String name, Boolean important, String duration, String description, Category category){
        this.date = date;
        this.name = name;
        this.important = important;
        this.duration = duration;
        this.description = description;
        this.category = category;
    }
    private LocalDate date;
    private String name;

    private Boolean important;

    private String duration;

    private String description = "";
    private Category category;

    private static List<Task> taskList = null;

    public void setName(String n){
        this.name = n;
    }
    public String getName(){
        return name;
    }

    public void setImportant(Boolean b){
        this.important =b;
    }

    public Boolean getImportant(){
        return important;
    }

    public void setDuration(String dur){
        this.duration = dur;
    }

    public String getDuration(){
        return duration;
    }

    public void setCategory(Category c){
        this.category = c;
    }
    public String getCategory(){
        return category.toString();
    }

    public void setDescription(String d){
        this.description = d;
    }
    public String getDescription(){
        return description;
    }

    public static List<Task> getAll(){
        if(taskList != null){
            return taskList;
        }
        try{
            List<String[]> taskImport= new BufferedReader(new FileReader(User.getLoggedUser().getUsername()+"/tasks.txt"))
                    .lines()
                    .map(s -> s.split(" "))
                    .collect(Collectors.toList());
            taskList = taskImport.stream()
                    .map((String[] s)->
                            new Task(
                                    LocalDate.parse(s[0]),
                                    s[1],
                                    Boolean.parseBoolean(s[2]),
                                    s[3],
                                    s[4],
                                    new Category(s[5])
                            ))
                    .collect(Collectors.toList());
        }catch(Exception e){
            e.printStackTrace();
        }
        return taskList;
    }

    public static List<Task> search(LocalDate date){
        List<Task> tasks = Task.getAll();
        List<Task> filteredTasks = new ArrayList();
        for(Task task : tasks){
            if(task.getDate().equals(date)){
                filteredTasks.add(task);
            }
        }
        return filteredTasks;
    }
    public Object[] toTableRow() {
        return new Object[] { name, duration, category.toString(), important ? "    ❗" : ""};
    }
    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public static void add(Task task) {
        getAll().add(task);
        save();
    }

    public static void modify(Task task) {
    }


    public static void delete(Task task) {
    }

    public static void save() {
        List<Task> clients = getAll();

    }
}
