package CH23_Network.chating;

import java.io.Serializable;

public class InfoDto implements Serializable {    // 데이터 직렬화

    private String nickname;
    private String message;
    private Info command;  // JOIN, SEND, EXIT


    public String getNickname() {
        return nickname;
    }

    public String getMessage() {
        return message;
    }

    public Info getCommand() {
        return command;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setCommand(Info command) {
        this.command = command;
    }
}
