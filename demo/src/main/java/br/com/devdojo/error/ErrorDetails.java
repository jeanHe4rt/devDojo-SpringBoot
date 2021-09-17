package br.com.devdojo.error;

public class ErrorDetails {
    private String title;
    private int status;
    private  String detail;
    private  long timestamp;
    private String developerMessage;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getDeveloperMessage() {
        return developerMessage;
    }

    public void setDeveloperMessage(String developerMessage) {
        this.developerMessage = developerMessage;
    }

    public static final class ErrorDetailsBuilder {
        private String title;
        private int status;
        private  String detail;
        private  long timestamp;
        private String developerMessage;

        private ErrorDetailsBuilder() {
        }

        public static ErrorDetailsBuilder anErrorDetails() {
            return new ErrorDetailsBuilder();
        }

        public ErrorDetailsBuilder withTitle(String title) {
            this.title = title;
            return this;
        }

        public ErrorDetailsBuilder withStatus(int status) {
            this.status = status;
            return this;
        }

        public ErrorDetailsBuilder withDetail(String detail) {
            this.detail = detail;
            return this;
        }

        public ErrorDetailsBuilder withTimestamp(long timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public ErrorDetailsBuilder withDeveloperMessage(String developerMessage) {
            this.developerMessage = developerMessage;
            return this;
        }

        public ErrorDetails build() {
            ErrorDetails errorDetails = new ErrorDetails();
            errorDetails.setTitle(title);
            errorDetails.setStatus(status);
            errorDetails.setDetail(detail);
            errorDetails.setTimestamp(timestamp);
            errorDetails.setDeveloperMessage(developerMessage);
            return errorDetails;
        }
    }
}
