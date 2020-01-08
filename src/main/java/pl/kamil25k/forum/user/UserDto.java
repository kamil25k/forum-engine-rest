package pl.kamil25k.forum.user;

import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
@ApiModel(value = "User")
public class UserDto {

    private String username;

    public UserDto() {
    }

    public UserDto(String username) {
        this.username = username;
    }
}
