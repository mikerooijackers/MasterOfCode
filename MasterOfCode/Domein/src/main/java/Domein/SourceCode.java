package Domein;

//@fileName

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;
import org.json.simple.JSONAware;
import org.json.simple.JSONObject;

//@content
//@isReadOnly

/**
 *
 * @author mikerooijackers
 */
@XmlRootElement
public class SourceCode implements Serializable, JSONAware {
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

    @Override
    public String toJSONString() {
        JSONObject obj = new JSONObject();
        obj.put("FileName", this.fileName);
        obj.put("Path", path);
        obj.put("Content", this.content);
        obj.put("Editable", this.isEditable);
        return obj.toJSONString();
    }
}