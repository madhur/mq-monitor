
package in.co.madhur.rabbitmonitor.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Context {

    @Expose
    private String node;
    @Expose
    private String description;
    @Expose
    private String path;
    @Expose
    private Integer port;
    @SerializedName("ignore_in_use")
    @Expose
    private Boolean ignoreInUse;

    /**
     * 
     * @return
     *     The node
     */
    public String getNode() {
        return node;
    }

    /**
     * 
     * @param node
     *     The node
     */
    public void setNode(String node) {
        this.node = node;
    }

    /**
     * 
     * @return
     *     The description
     */
    public String getDescription() {
        return description;
    }

    /**
     * 
     * @param description
     *     The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 
     * @return
     *     The path
     */
    public String getPath() {
        return path;
    }

    /**
     * 
     * @param path
     *     The path
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * 
     * @return
     *     The port
     */
    public Integer getPort() {
        return port;
    }

    /**
     * 
     * @param port
     *     The port
     */
    public void setPort(Integer port) {
        this.port = port;
    }

    /**
     * 
     * @return
     *     The ignoreInUse
     */
    public Boolean getIgnoreInUse() {
        return ignoreInUse;
    }

    /**
     * 
     * @param ignoreInUse
     *     The ignore_in_use
     */
    public void setIgnoreInUse(Boolean ignoreInUse) {
        this.ignoreInUse = ignoreInUse;
    }

}
