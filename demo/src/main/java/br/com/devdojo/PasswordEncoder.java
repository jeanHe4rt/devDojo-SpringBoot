package br.com.devdojo;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {
    public static void main(String[] args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode("jean"));
    }
}
// INSERT INTO userDevDojo (username,password,name,admin) VALUES ("jeanAt2","$2a$10$/JYbN.Bcs4ul6a4Ii5S52.ws6JtU8BLga9PDRbhM/5DkPuenj/CWa","Jean",true);
// insert into user_dev_dojo (id,admin,name,password,username)
// VALUES(0,TRUE,'jean','$2a$10$04a8DAdN7lBoVArCvTfMqO7jpCNOB3p0hdX90UvXtAUTfB6mI4XCK','jean');
// insert into user_dev_dojo (id,admin,name,password,username)
// VALUES(1,FALSE,'Carlos','$2a$10$04a8DAdN7lBoVArCvTfMqO7jpCNOB3p0hdX90UvXtAUTfB6mI4XCK','Carlos');