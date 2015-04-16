package mocjms.messaging.requestreply;

import java.io.Serializable;

/**
 *
 * @author Maja Pesic
 */
public interface IReplyListener {
    public void onReply(Serializable request,Serializable reply);
}
