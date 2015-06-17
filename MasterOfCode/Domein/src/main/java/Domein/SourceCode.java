package Domein;

//@fileName

import javax.xml.bind.annotation.XmlRootElement;

//@content
//@isReadOnly

/**
 *
 * @author mikerooijackers
 */
@XmlRootElement
public class SourceCode {
    private String fileName;
    private String path;
    private String content;
    private boolean isEditable;

    /**
     * constructor
     */
    public SourceCode() {
    }

    /**
     * is editable
     * @return
     */
    public boolean isIsEditable() {
        return isEditable;
    }

    /**
     * set is editable
     * @param isEditable
     */
    public void setIsEditable(boolean isEditable) {
        this.isEditable = isEditable;
    }

    /**
     * get filename
     * @return
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * set filename
     * @param fileName
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * get path
     * @return
     */
    public String getPath() {
        return path;
    }

    /**
     * set path
     * @param path
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * get contect
     * @return
     */
    public String getContent() {
        return content;
    }

    /**
     * set contect
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }
}