/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mocjms.messages.reply;

/**
 *
 * @author Gebruiker
 */
public class CreateWorkspaceReply {
    private String path;

    public CreateWorkspaceReply() {
    }

    public CreateWorkspaceReply(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
