/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mocjms.messages.reply;

/**
 *
 * @author May
 */
public class CompileReply {

    private String results;

    public CompileReply() {
    }

    public CompileReply(String compilationResult) {
        this.results = compilationResult;
    }

    public String getCompilationResult() {
        return results;
    }

    public void setCompilationResult(String compilationResult) {
        this.results = compilationResult;
    }
}