package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@Entity
@Table(name = "userdata")
@Getter
@Setter
public class UserData {
    @Id
    @NonNull
    int userId;
    String userName;
}
