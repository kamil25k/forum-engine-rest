package pl.kamil25k.forum.user;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "User")
public class UserDto {

    private String username;

    public UserDto() {
    }

    public UserDto(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public static class Builder {
        private String username;

        public Builder setUsername(String username) {
            this.username = username;
            return this;
        }

        public UserDto build() {
            return new UserDto(username);
        }

    }

    @Override
    public String toString() {
        return "UserDto{" +
                "username='" + username + '\'' +
                '}';
    }
}
