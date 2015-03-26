package Domein;

//@fileName

import javax.xml.bind.annotation.XmlRootElement;

//@content
//@isReadOnly
@XmlRootElement
public class SourceCode {
    private String fileName;
    private String path;
    private String content;

    public SourceCode() {
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}