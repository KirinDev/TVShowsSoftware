package app.mappers;

import app.domain.model.User;
import app.mappers.dto.UserDTO;
import app.mappers.dto.UserRoleDTO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class UserMapper {

    private UserRoleMapper mapper = new UserRoleMapper();

    public UserMapper() {}

    public UserDTO toDTO(User user) {
        List<UserRoleDTO> roles = this.mapper.toDTO(user.getRoles());
        return new UserDTO(user.getId().getEmail(), user.getName(), roles);
    }

    public List<UserDTO> toDTO(List<User> users) {
        List<UserDTO> usersDTO = new ArrayList();
        Iterator var3 = users.iterator();

        while(var3.hasNext()) {
            User user = (User)var3.next();
            usersDTO.add(this.toDTO(user));
        }

        return usersDTO;
    }

    public List<UserDTO> toDTO(Set<User> users) {
        List<UserDTO> usersDTO = new ArrayList();
        Iterator var3 = users.iterator();

        while(var3.hasNext()) {
            User user = (User)var3.next();
            usersDTO.add(this.toDTO(user));
        }

        return usersDTO;
    }
}
