package com.student.online.admission.system.rd.year.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * @Author Lawson Matutu
Zimbabwe Open University 3rd Year Project
 **/
@Entity
@Setter
@Getter
@NoArgsConstructor
public class Role {
    /*

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String name;

    @ManyToMany(mappedBy="roles")
    private Collection<User> users = new HashSet<>();

    public Role(String name) {
        this.name = name;
    }

    public  void  assignRoleToUser (User user){
        user.getRoles().add(this);
        this.getUsers().add(user);

    }


    public  void  removeUserFromRole(User user){
        user.getRoles().remove(this);
        this.getUsers().remove(user);

    }

    public  void  removeAllUsersFromRole(){        List<User> roleUsers= this.getUsers().stream().toList();
            roleUsers.forEach(this::removeUserFromRole);
        }
    }



    public  String getName(){
        return  name!=null? name:"";
    }

     */


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "roles")
    private Collection<User> users = new HashSet<>();

    public Role(String name) {
        this.name = name;
    }

    public void assignRoleToUser(User user){
        user.getRoles().add(this);
        this.getUsers().add(user);
    }

    public void removeUserFromRole(User user){
        user.getRoles().remove(this);
        this.getUsers().remove(user);

    }

    public void removeAllUsersFromRole(){
        if (this.getUsers() != null){
            List<User> roleUsers = this.getUsers().stream().toList();
            roleUsers.forEach(this :: removeUserFromRole);
        }
    }
    public  String getName(){
        return name != null? name : "";
    }
}


