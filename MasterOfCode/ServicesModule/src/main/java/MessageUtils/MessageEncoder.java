/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MessageUtils;

import Sockets.Messages.BaseMessage;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;
import org.json.simple.JSONValue;

/**
 *
 * @author JordiK
 */
public class MessageEncoder implements Encoder.Text<BaseMessage> {

    @Override
    public String encode(BaseMessage object) throws EncodeException {
        return JSONValue.toJSONString(object);
    }

    @Override
    public void init(EndpointConfig config) {
        System.out.println("Encoder initiated");
    }

    @Override
    public void destroy() {
        System.out.println("Encoder destroyed");
    }
    
}
