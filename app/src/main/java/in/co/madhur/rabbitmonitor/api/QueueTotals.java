
package in.co.madhur.rabbitmonitor.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class QueueTotals {

    @Expose
    private Integer messages;
    @SerializedName("messages_details")
    @Expose
    private MessagesDetails messagesDetails;
    @SerializedName("messages_ready")
    @Expose
    private Integer messagesReady;
    @SerializedName("messages_ready_details")
    @Expose
    private MessagesReadyDetails messagesReadyDetails;
    @SerializedName("messages_unacknowledged")
    @Expose
    private Integer messagesUnacknowledged;
    @SerializedName("messages_unacknowledged_details")
    @Expose
    private MessagesUnacknowledgedDetails messagesUnacknowledgedDetails;

    /**
     * 
     * @return
     *     The messages
     */
    public Integer getMessages() {
        return messages;
    }

    /**
     * 
     * @param messages
     *     The messages
     */
    public void setMessages(Integer messages) {
        this.messages = messages;
    }

    /**
     * 
     * @return
     *     The messagesDetails
     */
    public MessagesDetails getMessagesDetails() {
        return messagesDetails;
    }

    /**
     * 
     * @param messagesDetails
     *     The messages_details
     */
    public void setMessagesDetails(MessagesDetails messagesDetails) {
        this.messagesDetails = messagesDetails;
    }

    /**
     * 
     * @return
     *     The messagesReady
     */
    public Integer getMessagesReady() {
        return messagesReady;
    }

    /**
     * 
     * @param messagesReady
     *     The messages_ready
     */
    public void setMessagesReady(Integer messagesReady) {
        this.messagesReady = messagesReady;
    }

    /**
     * 
     * @return
     *     The messagesReadyDetails
     */
    public MessagesReadyDetails getMessagesReadyDetails() {
        return messagesReadyDetails;
    }

    /**
     * 
     * @param messagesReadyDetails
     *     The messages_ready_details
     */
    public void setMessagesReadyDetails(MessagesReadyDetails messagesReadyDetails) {
        this.messagesReadyDetails = messagesReadyDetails;
    }

    /**
     * 
     * @return
     *     The messagesUnacknowledged
     */
    public Integer getMessagesUnacknowledged() {
        return messagesUnacknowledged;
    }

    /**
     * 
     * @param messagesUnacknowledged
     *     The messages_unacknowledged
     */
    public void setMessagesUnacknowledged(Integer messagesUnacknowledged) {
        this.messagesUnacknowledged = messagesUnacknowledged;
    }

    /**
     * 
     * @return
     *     The messagesUnacknowledgedDetails
     */
    public MessagesUnacknowledgedDetails getMessagesUnacknowledgedDetails() {
        return messagesUnacknowledgedDetails;
    }

    /**
     * 
     * @param messagesUnacknowledgedDetails
     *     The messages_unacknowledged_details
     */
    public void setMessagesUnacknowledgedDetails(MessagesUnacknowledgedDetails messagesUnacknowledgedDetails) {
        this.messagesUnacknowledgedDetails = messagesUnacknowledgedDetails;
    }

}
