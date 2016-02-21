package org.apache.eagle.correlation.client;

import java.util.List;

/**
 * Created by yonzhang on 2/20/16.
 */
public interface IMetadataClient {
    List findAllTopics();
    List findAllGroups();
}
