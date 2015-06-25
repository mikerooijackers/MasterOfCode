/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domein;

import org.json.simple.JSONAware;
import org.json.simple.JSONObject;

/**
 *
 * @author Gebruiker
 */
public class UnitTestFile implements JSONAware {
    private String name;
    private String description;

    public UnitTestFile() {
    }

    public UnitTestFile(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toJSONString() {
        JSONObject obj = new JSONObject();
        obj.put("TestName", name);
        obj.put("Description", this.description);
        return obj.toJSONString();
    }
}
