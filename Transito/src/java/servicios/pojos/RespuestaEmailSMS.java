package servicios.pojos;

public class RespuestaEmailSMS {
    private String smscode;
    private boolean emailStatus;

    public RespuestaEmailSMS() {
    }

    public RespuestaEmailSMS(String smscode, boolean emailStatus) {
        this.smscode = smscode;
        this.emailStatus = emailStatus;
    }

    public String getSmscode() {
        return smscode;
    }

    public void setSmscode(String smscode) {
        this.smscode = smscode;
    }

    public boolean isEmailStatus() {
        return emailStatus;
    }

    public void setEmailStatus(boolean emailStatus) {
        this.emailStatus = emailStatus;
    }

    public void setEmailstatus(boolean enviado) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
