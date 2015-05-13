/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sockets.Messages;

import org.json.simple.JSONAware;

/**
 *
 * @author JordiK
 */
public abstract class BaseMessage implements JSONAware {
    public abstract void doAction();
}
