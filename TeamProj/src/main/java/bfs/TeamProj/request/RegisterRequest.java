package bfs.TeamProj.request;

import lombok.Data;

@Data
public class RegisterRequest {
    private String userName;
    private String password;
    private String createDate;
    private String email;
    private String modificationDate;
}
