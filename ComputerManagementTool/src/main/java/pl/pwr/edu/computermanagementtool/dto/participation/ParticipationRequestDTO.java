package pl.pwr.edu.computermanagementtool.dto.participation;

public class ParticipationRequestDTO {

    private int deviceId;
    private int userId;

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
